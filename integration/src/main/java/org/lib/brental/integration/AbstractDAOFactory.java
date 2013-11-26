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
public abstract class AbstractDAOFactory {
    private static AbstractDAOFactory instance;
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
    
    public static AbstractDAOFactory getDefault(){
        if(instance == null){
            instance = (AbstractDAOFactory)st.getService();
            if(instance == null){
                instance = new DAOFactoryDefault();
            }
        }
        return instance;
    }
}
