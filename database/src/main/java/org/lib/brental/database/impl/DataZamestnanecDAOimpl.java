/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.database.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lib.brental.integration.ZamestnanecDAO;
import org.lib.brental.model.Adresa;
import org.lib.brental.model.Zamestnanec;
import org.lib.brental.model.ZamestnanecId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class DataZamestnanecDAOimpl implements ZamestnanecDAO {

    Connection con;
    PreparedStatement psCreate;
    PreparedStatement psGet;
    ResultSet rs;
    

    public DataZamestnanecDAOimpl(Connection con) {
        this.con=con;
    }

    public Zamestnanec create(String jmeno, String prijimeni, String funkce, Adresa adresa, String login, String heslo) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(ZamestnanecId id) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void update(Zamestnanec zam) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Zamestnanec find(ZamestnanecId id) throws BRentalException {
        String sql = "select zamestnanecID,jmeno, prijmeni,login,heslo,ulice,mesto,psc,pracovni_pozice from Zamestnanec where zamestnanecID=?";
        Zamestnanec zam=null;
        try {
            psGet = con.prepareStatement(sql);
            psGet.setInt(1, id.getId());
            rs = psGet.executeQuery();
            while (rs.next()) {
                zam = new Zamestnanec(new ZamestnanecId(rs.getInt(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),new Adresa(rs.getString(6), rs.getString(7), rs.getInt(8)),rs.getString(9));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAutoDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return zam;
    
    }

    public Collection<Zamestnanec> getAll() throws BRentalException {
        ArrayList<Zamestnanec> z = new ArrayList<Zamestnanec>();

        String sql = "select zamestnanecID,jmeno, prijmeni,login,heslo,ulice,mesto,psc,pracovni_pozice from Zamestnanec";
        try {
            psGet = con.prepareStatement(sql);
            rs = psGet.executeQuery();
            while (rs.next()) {
                Zamestnanec zam = new Zamestnanec(new ZamestnanecId(rs.getInt(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),new Adresa(rs.getString(6), rs.getString(7), rs.getInt(8)),rs.getString(9));
                
                z.add(zam);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAutoDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return z;
    }
}
