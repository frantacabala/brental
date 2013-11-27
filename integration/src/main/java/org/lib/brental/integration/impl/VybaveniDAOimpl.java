/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.lib.brental.integration.VybaveniDAO;
import org.lib.brental.model.Vybaveni;
import org.lib.brental.model.VybaveniId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class VybaveniDAOimpl implements VybaveniDAO {

    private static int idCount;
    private Map<VybaveniId,Vybaveni> vybaveni = new ConcurrentHashMap<VybaveniId, Vybaveni>();
    
    public VybaveniDAOimpl() {
    }

    public Vybaveni create(String nazev,int pocet,String velikost) throws BRentalException{
        Vybaveni vyb = new Vybaveni(new VybaveniId(idCount++), nazev, pocet,velikost);
        vybaveni.put(vyb.getId(), vyb);
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
    
}
