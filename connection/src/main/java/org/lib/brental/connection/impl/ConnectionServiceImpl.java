/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.connection.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lib.brental.connection.ConnectionService;
import org.lib.brental.model.Auto;
import org.lib.brental.protocol.BrentalCommand;
import org.lib.brental.protocol.Disconnect;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class ConnectionServiceImpl extends ConnectionService {

    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Socket socket;
    private static Class[] preloaded = {
        Auto.class,};

    public ConnectionServiceImpl() {
    }
    
    @Override
    public void connect(InetAddress ia, int port) throws BRentalException {
        try {
            socket = new Socket(ia, port);
            // socket.setSoTimeout(3000); !!!
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ConnectionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void disconnect() {
        try (
                ObjectInputStream ois = this.ois;
                ObjectOutputStream oos = this.oos;
                Socket socket = this.socket) {
            send(new Disconnect());
        } catch (BRentalException | IOException ex) {
            Logger.getLogger(ConnectionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object send(BrentalCommand brentalCommand) throws BRentalException {
       if (!isConnected()) {
            throw new BRentalException("Connection refused");
        }
        try {
            oos.writeObject(brentalCommand);
            oos.flush();
            Object response = null;
            if (!(brentalCommand instanceof Disconnect)) {
                response = ois.readObject();
                if (response instanceof BRentalException) {
                    throw (BRentalException) response;
                }
            }
            return response;
        } catch (IOException ex) {
            Logger.getLogger(ConnectionServiceImpl.class.getName()).log(Level.INFO, null, ex);
            throw new BRentalException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean isConnected() {
        return socket != null;
    }
}
