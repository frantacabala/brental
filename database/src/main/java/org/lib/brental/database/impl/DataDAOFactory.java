/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.database.impl;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.lib.brental.database.AbstractDataDAOFactoryService;
import org.lib.brental.integration.AbstractDAOFactoryService;
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
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.launch.Framework;

/**
 *
 * @author john
 */
public class DataDAOFactory extends AbstractDataDAOFactoryService {

    BundleContext context;
    Connection con;
    DataAutoDAOimpl auto;
    DataFakturaDAOimpl faktura;
    DataLodDAOimpl lod;
    DataVestaDAOimpl vesta;
    DataOtherDAOimpl other;
    DataPadloDAOimpl padlo;
    DataRezervaceDAOimpl rezervace;
    DataZakaznikDAOimpl zakaznik;
    DataZamestnanecDAOimpl zam;
    String url;
    String user;
    String pass;
    Statement st;
    ResultSet rs;
    private static DataDAOFactory instance;

    public DataDAOFactory() {
        url = "jdbc:mysql://localhost:3306/brental";
        user = "root";
        pass = "fakum392a";
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find the driver in the classpath!", e);
        }

        try {
            con = DriverManager.getConnection(url, user, pass);
            DatabaseMetaData dm = con.getMetaData();
            rs = dm.getTables(null, null, "auto", null);
            testIfExist(dm);
            //JOptionPane.showMessageDialog(null, "OK");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nejde se pripojit");
            Logger.getLogger(DataDAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void testIfExist(DatabaseMetaData dm) {
        try {
            rs = dm.getTables(null, null, "auto", null);
            if (rs == null) {
                JOptionPane.showMessageDialog(null, " neni");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataDAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setContext(BundleContext context) {
        this.context = context;
    }

    @Override
    public AutoDAO getAutoDAO() {
        //JOptionPane.showMessageDialog(null,"jojo");
        if (auto == null) {
            auto = new DataAutoDAOimpl(con);
        }
        return auto;
    }

    @Override
    public FakturaDAO getFakturaDAO() {
        if (faktura == null) {
            faktura = new DataFakturaDAOimpl(con);
        }
        return faktura;
    }

    @Override
    public LodDAO getLodDAO() {
        if (lod == null) {
            lod = new DataLodDAOimpl(con);
        }
        return lod;
    }

    @Override
    public RezervaceDAO getRezervaceDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ZakaznikDAO getZakaznikDAO() {
        if (zakaznik == null) {
            zakaznik = new DataZakaznikDAOimpl(con);
        }
        return zakaznik;
    }

    @Override
    public ZamestnanecDAO getZamestnanecDAO() {
        if (zam == null) {
            zam = new DataZamestnanecDAOimpl(con);
        }
        return zam;
    }

    @Override
    public VestaDAO getVestaDAO() {
        if(vesta==null){
            vesta = new DataVestaDAOimpl(con);
        }
        return vesta;
    }

    @Override
    public OtherDAO getOtherDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PadloDAO getPadloDAO() {
        if (padlo == null) {
            padlo = new DataPadloDAOimpl(con);

        }
        return padlo;
    }

    public void exit() {
        try {
            Bundle bnd = context.getBundle(0);
            Framework fw = (Framework) bnd;
            fw.stop();
            fw.waitForStop(0);
        } catch (InterruptedException ex) {
            Logger.getLogger(DataDAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BundleException ex) {
            Logger.getLogger(DataDAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
