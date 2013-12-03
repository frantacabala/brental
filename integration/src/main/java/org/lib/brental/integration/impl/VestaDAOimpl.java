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
import org.lib.brental.integration.VestaDAO;
import org.lib.brental.model.Vesta;
import org.lib.brental.model.VybaveniId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class VestaDAOimpl implements VestaDAO {

    private static int idCount;
    
    private Map<VybaveniId,Vesta> vesty = new ConcurrentHashMap<VybaveniId, Vesta>();
    
    public VestaDAOimpl(){
        
    }
    
    public Vesta create(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha, String typ, String velikost, String vyrobce) throws BRentalException {
        
        
        Vesta vesta = new Vesta(new VybaveniId("VE"+Integer.toString(idCount++)),nazev,nakup_cena,datum_nakup,barva,pujc_cena,vaha,typ,velikost,vyrobce);
        vesty.put(vesta.getId(), vesta);
        return vesta;
    }

    public void delete(VybaveniId id) throws BRentalException{
        vesty.remove(id);
    }
   
    public void update(Vesta vesta) throws BRentalException{
        vesty.put(vesta.getId(), vesta);
    }
    
    public Vesta find(VybaveniId id) throws BRentalException{
        return vesty.get(id);
        
    }
    
    public Collection<Vesta> getAll(){
        return new ArrayList<Vesta>(vesty.values());
        
    }
    
}
