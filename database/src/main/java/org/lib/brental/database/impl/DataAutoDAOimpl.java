/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.database.impl;

//import brental.util.HibernateUtil;
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
import javax.swing.JOptionPane;
//import org.hibernate.Query;
//import org.hibernate.Session;
import org.lib.brental.integration.AutoDAO;
import org.lib.brental.model.Auto;
import org.lib.brental.model.AutoId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
class DataAutoDAOimpl implements AutoDAO {

    Connection con;
    PreparedStatement psCreate;
    PreparedStatement psGet;
    ResultSet rs;

    public DataAutoDAOimpl(Connection con) {
        this.con = con;
    }

    public Auto create(String spz, int kapacita, int cena_zakoupeni, Date datum_zakoupeni,Date datum_tk) throws BRentalException {
        Auto a= null;
        
        java.sql.Date sqlDate1 = new java.sql.Date(datum_zakoupeni.getTime());
        java.sql.Date sqlDate2 = new java.sql.Date(datum_tk.getTime());
        
        
        String sql = "INSERT INTO Auto"
                + " (SPZ, platnost_TK, lode_kapacita, datum_zakoupeni,cena_zakopeni)"
                + "VALUES (?,?,?,?,?)";
        try {
            psGet = con.prepareStatement(sql);
            psGet.setString(1, spz);
            psGet.setDate(2, sqlDate2);
            psGet.setInt(3, kapacita);
            psGet.setInt(5, cena_zakoupeni);
            psGet.setDate(4, sqlDate1);
            psGet.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataAutoDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
    }

    public void delete(AutoId id) throws BRentalException {
        String sql = "delete from Auto where autoID=? ";
        try {
            psGet = con.prepareStatement(sql);
            psGet.setInt(1, id.getId());
            
            psGet.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataAutoDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Auto aut) throws BRentalException {
        String sql = "UPDATE Auto SET SPZ = ?, platnost_tk = ? , lode_kapacita = ?, datum_zakoupeni=?,cena_zakopeni=? WHERE autoID = ? ";
         java.sql.Date sqlDate1= new java.sql.Date(aut.getDatum_zakoupeni().getTime());
        java.sql.Date sqlDate2;
        sqlDate2 = new java.sql.Date(aut.getDatum_tk().getTime());
        String ste = aut.getZnacka()+Integer.toString(aut.getCena_zakoupeni()) +Integer.toString(aut.getKapacita()) + aut.getId().getId() + sqlDate1 + sqlDate2 ;
        JOptionPane.showMessageDialog(null,ste);
        try {
            psGet = con.prepareStatement(sql);
            psGet.setString(1, aut.getZnacka());
            psGet.setDate(2, sqlDate2);
            psGet.setInt(3, aut.getKapacita());
            psGet.setInt(5, aut.getCena_zakoupeni());
            psGet.setDate(4, sqlDate1);
            psGet.setInt(6, aut.getId().getId());
            
            psGet.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataAutoDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Auto find(AutoId id) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Collection<Auto> getAll() throws BRentalException {
        ArrayList<Auto> auta = new ArrayList<Auto>();
        String getSql = "select * from "
                + "	(select vybaveniID,datum_zakoupeni,evid_cislo,barva,cena_za_pujceni_den,nazev,vaha,typ_vybaveni.typ_vybaveniID  "
                + "		from vybaveni \n"
                + "		inner join typ_vybaveni on vybaveni.typ_vybaveniID=typ_vybaveni.typ_vybaveniID"
                + "	) as tb "
                + "inner join padlo on padlo.padloID=tb.typ_vybaveniID";
        String sql = "select autoID,SPZ,lode_kapacita,cena_zakopeni,datum_zakoupeni,platnost_TK from Auto";
        try {
            psGet = con.prepareStatement(sql);
            rs = psGet.executeQuery();
            while (rs.next()) {
                Date date = new Date();
                Date date2 = new Date();
                
                date = new SimpleDateFormat("yyy-MM-dd", Locale.ENGLISH).parse(rs.getString(5));
                date2 = new SimpleDateFormat("yyy-MM-dd", Locale.ENGLISH).parse(rs.getString(6));
                Auto a = new Auto(new AutoId(rs.getInt(1)), rs.getString(2), rs.getInt(3), rs.getInt(4), date,date2);

                auta.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAutoDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DataAutoDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        }



        return auta;



    }
    
//    public Collection<Auto> getAll() throws BRentalException {
//        String hql=null;
//        ArrayList<Auto> auta = new ArrayList<Auto>();
//        hql="from Auto";
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        Query q = session.createQuery(hql);
//        auta=(ArrayList)q.list();
//        return auta;
//
//    }
    
    
}
