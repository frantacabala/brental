/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.database.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.lib.brental.integration.VybaveniDAO;
import org.lib.brental.model.Padlo;
import org.lib.brental.model.Vybaveni;
import org.lib.brental.model.VybaveniId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class DataVybaveniDAOimpl implements VybaveniDAO {

    PreparedStatement psCreate;
    public DataVybaveniDAOimpl(Connection con) {
    }

    public Vybaveni create(VybaveniId id, String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha) throws BRentalException{
        Vybaveni vyb = new VybaveniImpl(new VybaveniId("VY"+Integer.toString(idCount++)),nazev,nakup_cena,datum_nakup,barva,pujc_cena,vaha);
        return vyb;
    }
    
    public void delete(VybaveniId id) throws BRentalException{
        vybaveni.remove(id);
    }
   
    public void update(Vybaveni vyb) throws BRentalException{
        vybaveni.put(vyb.getId(), vyb);
    }
    
    public Vybaveni find(VybaveniId id) throws BRentalException{
        return vybaveni.get(id);
        
    }
    
    public Collection<Vybaveni> getAll() throws BRentalException{
        return new ArrayList<Vybaveni>(vybaveni.values());
    }

    private static class VybaveniImpl extends Vybaveni<VybaveniImpl> {

        public VybaveniImpl(VybaveniId id, String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha) {
            super(id, nazev, nakup_cena, datum_nakup, barva, pujc_cena, vaha);
        }
    }
    
}
