/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.server_br;

import java.net.Socket;
import org.lib.brental.bussines.BrentalFacadeInterface;
import org.lib.brental.server_br.impl.CreateClientTaskDefault;
import org.osgi.util.tracker.ServiceTracker;

/**
 *
 * @author john
 */
public abstract class CreateClientTaskService {
   private static CreateClientTaskService instance;
   private static ServiceTracker st;
   
   public static CreateClientTaskService getDefault() {
        if (instance == null) {
          instance = (CreateClientTaskService) st.getService();
          if (instance == null) {
              instance = new CreateClientTaskDefault();
          }
      } else {
       }
        return instance;
    }

    public static void setSt(ServiceTracker aSt) {
        st = aSt;
    }
    
    
     public abstract Runnable createClientTask(Socket socket, BrentalFacadeInterface facade);
}
