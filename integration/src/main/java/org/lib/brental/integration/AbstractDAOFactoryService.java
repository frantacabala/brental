/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration;

import org.lib.brental.integration.impl.DAOFactoryDefault;
import org.osgi.util.tracker.ServiceTracker;

/**
 *
 * @author john
 */
public abstract class AbstractDAOFactoryService {
    private static AbstractDAOFactoryService instance;
    private static ServiceTracker st;
    
    public static void setSt(ServiceTracker aSt){
        st=aSt;
    }
    
    public abstract AutoDAO getAutoDAO();
    
    public abstract FakturaDAO getFakturaDAO();
    
    public abstract LodDAO getLodDAO();
    
    public abstract RezervaceDAO getRezervaceDAO();
    
    public abstract VybaveniDAO getVybaveniDAO();
    
    public abstract ZakaznikDAO getZakaznikDAO();
    
    public abstract ZamestnanecDAO getZamestnanecDAO();
    
    public abstract VestaDAO getVestaDAO();
    
    public abstract OtherDAO getOtherDAO();
    
    public abstract PadloDAO getPadloDAO();
    
    public static AbstractDAOFactoryService getDefault(){
        if(instance == null){
            instance = (AbstractDAOFactoryService)st.getService();
            if(instance == null){
                instance = new DAOFactoryDefault();
            }
        }
        return instance;
    }
}
