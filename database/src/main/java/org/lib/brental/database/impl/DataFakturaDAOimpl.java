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
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lib.brental.integration.FakturaDAO;
import org.lib.brental.model.Faktura;
import org.lib.brental.model.FakturaId;
import org.lib.brental.model.RezervaceId;
import org.lib.brental.model.ZamestnanecId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
class DataFakturaDAOimpl implements FakturaDAO {
     Connection con;
    PreparedStatement psCreate;
    PreparedStatement psGet;
    ResultSet rs;

    public DataFakturaDAOimpl(Connection con) {
        this.con=con;
    }
    

    public Faktura create( ZamestnanecId id_zam, Date datum_vystaveni, Date datum_splatnosti) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(FakturaId id) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void update(Faktura fak) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Faktura find(FakturaId id) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Collection<Faktura> getAll() throws BRentalException {
        ArrayList<Faktura> z = new ArrayList<Faktura>();

        String sql = "select fakturaID,zamestnanecID,vystaveni,splatnost from Faktura";
        try {
            psGet = con.prepareStatement(sql);
            rs = psGet.executeQuery();
            while (rs.next()) {
                
                Faktura fak = new Faktura(new FakturaId(rs.getInt(1)),new ZamestnanecId(rs.getInt(2)),rs.getDate(3),rs.getDate(4));
                
                z.add(fak);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAutoDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return z;
    }
    
}
