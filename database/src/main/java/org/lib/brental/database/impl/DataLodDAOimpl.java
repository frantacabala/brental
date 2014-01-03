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
import org.lib.brental.integration.LodDAO;
import org.lib.brental.model.Lod;
import org.lib.brental.model.Vybaveni;
import org.lib.brental.model.VybaveniId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
class DataLodDAOimpl implements LodDAO {

    private Connection con;
    PreparedStatement psCreate;
    PreparedStatement psGet;
    ResultSet rs;

    public DataLodDAOimpl(Connection con) {
        this.con = con;
    }

    public Lod create(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha, String evid, int delka, int max_ponor, String model, int nostnost, int sirka, String typ, String vyrobce) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(VybaveniId id) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void update(Lod lod) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Lod find(VybaveniId id) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Collection<Vybaveni> getAll() throws BRentalException {
        ArrayList<Vybaveni> lode = new ArrayList<Vybaveni>();
        String sql = "select vybaveniID,nazev,datum_zakoupeni, barva,cena_za_pujceni_den,vaha,evid_cislo,delka,max_ponor,model,nosnost_osob,sirka,typ,vyrobce\n"
                + "from (select vybaveniID,datum_zakoupeni,evid_cislo,barva,cena_za_pujceni_den,nazev,vaha,Typ_vybaveni.typ_vybaveniID\n"
                + "from Vybaveni \n"
                + "inner join Typ_vybaveni on Vybaveni.typ_vybaveniID=Typ_vybaveni.typ_vybaveniID) \n"
                + "as tb \n"
                + "inner join Lod on Lod.lodID=tb.typ_vybaveniID";

        try {
            psGet = con.prepareStatement(sql);
            rs = psGet.executeQuery();
            while (rs.next()) {
                Date date = new Date();
                Date date2 = new Date();

                date = new SimpleDateFormat("yyy-MM-dd", Locale.ENGLISH).parse(rs.getString(3));

                Lod lod = new Lod(new VybaveniId(rs.getInt(1)),rs.getString(2),1234,date,rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getInt(9),rs.getString(10),rs.getInt(11),rs.getInt(12),rs.getString(13),rs.getString(14));
                
                
                lode.add(lod);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataLodDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DataLodDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        }



        return lode;
    }
}
