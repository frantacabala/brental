/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.lib.brental.integration.LodDAO;
import org.lib.brental.model.Lod;
import org.lib.brental.model.LodId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
class LodDAOimpl implements LodDAO {

    public LodDAOimpl() {
    }
    
    private static int idCount;
    
    private Map<LodId,Lod> lode = new ConcurrentHashMap<LodId, Lod>();
    
    
    
    public Lod create(String typ, int kapacita) throws BRentalException{
        Lod lod = new Lod(new LodId(idCount++), typ, kapacita);
        lode.put(lod.getId(), lod);
        return lod;
    }
    
    public void delete(LodId id) throws BRentalException{
        lode.remove(id);
    }
   
    public void update(Lod lod) throws BRentalException{
        lode.put(lod.getId(), lod);
    }
    
    public Lod find(LodId id) throws BRentalException{
        return lode.get(id);
        
    }
    
    public Collection<Lod> getAll() throws BRentalException{
        return new ArrayList<Lod>(lode.values());
    }
}
