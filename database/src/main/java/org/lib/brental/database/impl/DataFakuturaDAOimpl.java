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
class DataFakuturaDAOimpl implements FakturaDAO {

    public DataFakuturaDAOimpl(Connection con) {
    }
    
    PreparedStatement psCreate;
    
    
    public Faktura create(RezervaceId id, ZamestnanecId id_zam, Date datum_vystaveni, Date datum_splatnosti) throws BRentalException{
        Faktura fak = new Faktura(new FakturaId(idCount++), id, id_zam, datum_vystaveni, datum_splatnosti);
        return fak;
    }
    
    public void delete(FakturaId id) throws BRentalException{
        faktury.remove(id);
    }
   
    public void update(Faktura fak) throws BRentalException{
        faktury.put(fak.getId(), fak);
    }
    
    public Faktura find(FakturaId id) throws BRentalException{
        return faktury.get(id);
        
    }
    
    public Collection<Faktura> getAll() throws BRentalException{
        return new ArrayList<Faktura>(faktury.values());
    }
}
