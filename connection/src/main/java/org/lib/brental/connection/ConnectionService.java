/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.connection;

import java.net.InetAddress;
import org.lib.brental.connection.impl.ConnectionServiceImpl;
import org.lib.brental.protocol.BrentalCommand;
import org.lib.brental.utils.BRentalException;
import org.osgi.util.tracker.ServiceTracker;

/**
 *
 * @author john
 */
public abstract class ConnectionService {
    private static ConnectionService instance;
    private static ServiceTracker st;
    
    
    public ConnectionService(){
        
    }
    
    public static ConnectionService getDefault(){
        if(instance == null){
            instance=(ConnectionService)st.getService();
            if(instance == null){
                instance = new ConnectionServiceImpl();
            }
        }
        return instance;
    }

    public static void setSt(ServiceTracker st) {
        ConnectionService.st = st;
    }
    
     public abstract void connect(InetAddress ia, int port) throws BRentalException;

    public abstract void disconnect();

    public abstract <T> T send(BrentalCommand brentalCommand) throws BRentalException;

    public abstract boolean isConnected();
    
}
