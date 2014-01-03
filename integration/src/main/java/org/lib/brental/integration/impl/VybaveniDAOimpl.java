/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration.impl;

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
public class VybaveniDAOimpl implements VybaveniDAO {

    private static int idCount;
    private Map<VybaveniId,Vybaveni> vybaveni = new ConcurrentHashMap<VybaveniId, Vybaveni>();
    
    public VybaveniDAOimpl() {
    }

    public Vybaveni create(VybaveniId id, String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha,String evid) throws BRentalException{
        Vybaveni vyb = new Vybaveni(new VybaveniId(idCount++),nazev,nakup_cena,datum_nakup,barva,pujc_cena,vaha,evid) {};
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
