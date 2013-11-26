/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.lib.brental.integration.ZakaznikDAO;
import org.lib.brental.model.Adresa;
import org.lib.brental.model.Zakaznik;
import org.lib.brental.model.ZakaznikId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class ZakaznikDAOimpl extends ZakaznikDAO {

    private static int idCount;
    
    private Map<ZakaznikId,Zakaznik> zakaznici = new ConcurrentHashMap<ZakaznikId, Zakaznik>();
    
    public ZakaznikDAOimpl() {
    }
    
    public Zakaznik create(String jmeno, Adresa adresa) throws BRentalException{
        Zakaznik zak = new Zakaznik(new ZakaznikId(idCount++), jmeno, adresa);
        zakaznici.put(zak.getId(), zak);
        return zak;
    }
    
    public void delete(ZakaznikId id) throws BRentalException{
        zakaznici.remove(id);
    }
   
    public void update(Zakaznik zak) throws BRentalException{
        zakaznici.put(zak.getId(), zak);
    }
    
    public Zakaznik find(ZakaznikId id) throws BRentalException{
        return zakaznici.get(id);
        
    }
    
    public Collection<Zakaznik> getAll() throws BRentalException{
        return new ArrayList<Zakaznik>(zakaznici.values());
    }
    
}