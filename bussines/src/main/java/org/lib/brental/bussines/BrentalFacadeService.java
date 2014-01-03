/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.bussines;

import javax.swing.JOptionPane;
import org.lib.brental.bussines.impl.BrentalFacadeDefault;
import org.osgi.util.tracker.ServiceTracker;

/**
 *
 * @author john
 */
public abstract class BrentalFacadeService implements BrentalFacadeInterface{

    private static ServiceTracker st;
    private static BrentalFacadeService brentalFacade;

    public static BrentalFacadeService getDefault() {
        if (brentalFacade == null) {
            brentalFacade = (BrentalFacadeService) st.getService();
            //JOptionPane.showMessageDialog(null,"Class: "+ brentalFacade.getClass());
            if (brentalFacade == null) {
                brentalFacade = new BrentalFacadeDefault();
            }
        }
        
        return brentalFacade;
    }
    
    
    
     public static void setSt(ServiceTracker aSt) {
        st = aSt;
    }
    

}