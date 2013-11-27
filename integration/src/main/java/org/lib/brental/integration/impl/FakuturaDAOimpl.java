/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.lib.brental.integration.FakturaDAO;
import org.lib.brental.model.Faktura;
import org.lib.brental.model.FakturaId;
import org.lib.brental.model.RezervaceId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
class FakuturaDAOimpl implements FakturaDAO {

    public FakuturaDAOimpl() {
    }
    
    private static int idCount;
    
    private Map<FakturaId,Faktura> faktury = new ConcurrentHashMap<FakturaId, Faktura>();
    
    
    
    public Faktura create(RezervaceId id) throws BRentalException{
        Faktura fak = new Faktura(new FakturaId(idCount++), id);
        faktury.put(fak.getId(), fak);
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
