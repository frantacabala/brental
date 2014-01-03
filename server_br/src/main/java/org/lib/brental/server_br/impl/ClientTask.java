/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.server_br.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lib.brental.bussines.BrentalFacadeInterface;
import org.lib.brental.model.Auto;
import org.lib.brental.model.AutoId;
import org.lib.brental.protocol.BrentalCommand;
import org.lib.brental.protocol.Disconnect;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
class ClientTask implements Runnable {
    
    private Socket s;
    private BrentalFacadeInterface facade;
    
     static final Logger logger = Logger.getLogger(ClientTask.class.getName());
    static Class[] preloaded = {
        Auto.class,
        AutoId.class
    };
    

    public ClientTask(Socket socket, BrentalFacadeInterface facade) {
        s=socket;
        this.facade=facade;
    }

    @Override
    public void run() {
        try (Socket s = this.s;
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream())) {
            for (;;) {
                logger.log(Level.INFO, "waiting for command");
                BrentalCommand comm = (BrentalCommand) ois.readObject();
                logger.log(Level.INFO, "command: {0}", comm.toString());
                if (comm instanceof Disconnect) {
                    break;
                }
                Object result;
                try {
                    result = comm.execute(facade);
                } catch (BRentalException ex) {
                    result = ex;
                }
                logger.log(Level.INFO, "result: {0}", result.toString());
                oos.writeObject(result);
                oos.flush();
            }
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(ClientTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
