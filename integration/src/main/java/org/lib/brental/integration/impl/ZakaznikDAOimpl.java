/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lib.brental.integration.ZakaznikDAO;
import org.lib.brental.model.Adresa;
import org.lib.brental.model.Zakaznik;
import org.lib.brental.model.ZakaznikId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class ZakaznikDAOimpl implements ZakaznikDAO {

    private static int idCount;
    
    private Map<ZakaznikId,Zakaznik> zakaznici = new ConcurrentHashMap<ZakaznikId, Zakaznik>();
    
    public ZakaznikDAOimpl() {
        try {
            create("Jan", "Kusy",  new Adresa("VANICKOVA", "PRAHA", 16000), 1234);
             create("Jan", "Kusy",  new Adresa("VANICKOVA", "PRAHA", 16000), 1234);
            create("Jan", "Kusy",  new Adresa("VANICKOVA", "PRAHA", 16000), 1234);
        } catch (BRentalException ex) {
            Logger.getLogger(ZakaznikDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    
    public Zakaznik create(String jmeno,String prijimeni, Adresa adresa,int cislo_op) throws BRentalException{
        Zakaznik zak = new Zakaznik(new ZakaznikId(idCount++), jmeno, prijimeni,adresa,cislo_op);
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
