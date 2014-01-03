/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.database;


import org.lib.brental.database.impl.DataDAOFactory;
import org.lib.brental.integration.AutoDAO;
import org.lib.brental.integration.FakturaDAO;
import org.lib.brental.integration.LodDAO;
import org.lib.brental.integration.OtherDAO;
import org.lib.brental.integration.PadloDAO;
import org.lib.brental.integration.RezervaceDAO;
import org.lib.brental.integration.VestaDAO;
import org.lib.brental.integration.VybaveniDAO;
import org.lib.brental.integration.ZakaznikDAO;
import org.lib.brental.integration.ZamestnanecDAO;

/**
 *
 * @author john
 */
public abstract class AbstractDataDAOFactoryService {

    private static AbstractDataDAOFactoryService instance;
    
    public static AbstractDataDAOFactoryService getDefault(){
       
            //instance = (AbstractDAOFactory)st.getService();
            if(instance == null){
                instance = new DataDAOFactory();
            }
        
        return instance;
    }

    public abstract AutoDAO getAutoDAO();

    public abstract FakturaDAO getFakturaDAO();

    public abstract LodDAO getLodDAO();

    public abstract RezervaceDAO getRezervaceDAO();

    

    public abstract ZakaznikDAO getZakaznikDAO();

    public abstract ZamestnanecDAO getZamestnanecDAO();

    public abstract VestaDAO getVestaDAO();

    public abstract OtherDAO getOtherDAO();

    public abstract PadloDAO getPadloDAO();
}
