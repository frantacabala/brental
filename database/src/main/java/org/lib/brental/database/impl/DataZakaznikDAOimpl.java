/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.database.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lib.brental.integration.ZakaznikDAO;
import org.lib.brental.model.Adresa;
import org.lib.brental.model.Zakaznik;
import org.lib.brental.model.ZakaznikId;
import org.lib.brental.model.Zamestnanec;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class DataZakaznikDAOimpl implements ZakaznikDAO {

    Connection con;
    PreparedStatement psCreate;
    PreparedStatement psGet;
    ResultSet rs;

    public DataZakaznikDAOimpl(Connection con) {
        this.con = con;
    }

    public Zakaznik create(String jmeno, String prijimeni, Adresa adresa, int cislo_op) throws BRentalException {
        Zakaznik z = null;
        // ZakaznikId id, String jmeno, String prijimeni, Adresa adresa, int cislo_op
        // String addresa

//        String sql = "INSERT INTO Zakaznik\n"
//                + "	(jmeno, prijmeni, adresa, cislo_op)\n"
//                + "VALUES\n"
//                + "	(?, ?, ?, ?)";
//                
//                try {
//            psGet = con.prepareStatement(sql);
//            psGet.setString(1, jmeno);
//            psGet.setString(2, prijimeni);
//            psGet.setString(3, kapacita);
//            psGet.setInt(5, cena_zakoupeni);
//            psGet.setDate(4, sqlDate1);
//            psGet.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(DataAutoDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
//        }


        return z;

    }

    public void delete(ZakaznikId id) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void update(Zakaznik zak) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Zakaznik find(ZakaznikId id) throws BRentalException {
        String sql = "select zakaznikID,jmeno,prijmeni,ulice,mesto,psc,cislo_op from Zakaznik where zakaznikID=?";
        Zakaznik zak = null;
        try {
            psGet = con.prepareStatement(sql);
            psGet.setInt(1, id.getId());
            rs = psGet.executeQuery();
            while (rs.next()) {

                zak = new Zakaznik(new ZakaznikId(rs.getInt(1)), rs.getString(2), rs.getString(3), new Adresa(rs.getString(4), rs.getString(5), rs.getInt(6)), rs.getInt(7));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAutoDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return zak;
    }

    public Collection<Zakaznik> getAll() throws BRentalException {
        ArrayList<Zakaznik> z = new ArrayList<Zakaznik>();

        String sql = "select zakaznikID,jmeno,prijmeni,ulice,mesto,psc,cislo_op from Zakaznik";
        try {
            psGet = con.prepareStatement(sql);
            rs = psGet.executeQuery();
            while (rs.next()) {

                Zakaznik zak = new Zakaznik(new ZakaznikId(rs.getInt(1)), rs.getString(2), rs.getString(3), new Adresa(rs.getString(4), rs.getString(5), rs.getInt(6)), rs.getInt(7));

                z.add(zak);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAutoDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return z;
    }
}
