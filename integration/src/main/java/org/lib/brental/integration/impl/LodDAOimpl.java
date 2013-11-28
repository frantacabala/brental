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
import org.lib.brental.integration.LodDAO;
import org.lib.brental.model.Lod;
import org.lib.brental.model.VybaveniId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
class LodDAOimpl implements LodDAO {

    public LodDAOimpl() {
    }
    
    private static int idCount;
    
    private Map<VybaveniId,Lod> lode = new ConcurrentHashMap<VybaveniId, Lod>();
    
    
    
    public Lod create(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha,
            int delka, int max_ponor, String model, int nostnost, int sirka, String typ, String vyrobce) throws BRentalException{
        
        Lod lod = new Lod(new VybaveniId("LO"+Integer.toString(idCount++)), nazev,  nakup_cena,  datum_nakup,  barva,  pujc_cena,  vaha,
             delka,  max_ponor,  model,  nostnost,  sirka,  typ,  vyrobce);
        lode.put(lod.getId(), lod);
        return lod;
    }
    
    public void delete(VybaveniId id) throws BRentalException{
        lode.remove(id);
    }
   
    public void update(Lod lod) throws BRentalException{
        lode.put(lod.getId(), lod);
    }
    
    public Lod find(VybaveniId id) throws BRentalException{
        return lode.get(id);
        
    }
    
    public Collection<Lod> getAll() throws BRentalException{
        return new ArrayList<Lod>(lode.values());
    }
}
