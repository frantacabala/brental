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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lib.brental.integration.VestaDAO;
import org.lib.brental.model.Vesta;
import org.lib.brental.model.Vybaveni;
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
        try {
            create("Vesta1",2000,new Date(),"cervena",500,1,"sdsdss3123","Zachranna","L","vestyssro");
            create("Vesta1",2000,new Date(),"cervena",500,1,"sdsdss3123","Zachranna","L","vestyssro");
            create("Vesta1",2000,new Date(),"cervena",500,1,"sdsdss3123","Zachranna","L","vestyssro");
            create("Vesta1",2000,new Date(),"cervena",500,1,"sdsdss3123","Zachranna","L","vestyssro");
        } catch (BRentalException ex) {
            Logger.getLogger(VestaDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Vesta create(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha,String evid, String typ, String velikost, String vyrobce) throws BRentalException {
        
        
        Vesta vesta = new Vesta(new VybaveniId(idCount++),nazev,nakup_cena,datum_nakup,barva,pujc_cena,vaha,evid,typ,velikost,vyrobce);
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
    
    public Collection<Vybaveni> getAll(){
        return new ArrayList<Vybaveni>(vesty.values());
        
    }
    
}
