/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.lib.brental.integration.RezervaceDAO;
import org.lib.brental.model.LodId;
import org.lib.brental.model.Rezervace;
import org.lib.brental.model.RezervaceId;
import org.lib.brental.model.VybaveniId;
import org.lib.brental.model.ZakaznikId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
class RezervaceDAOimpl implements RezervaceDAO {

    public RezervaceDAOimpl() {
    }
    
    private static int idCount;
    private Map<RezervaceId, Rezervace> rezervaceToId;
   
    
    
    public void vytvorRezervaci(ZakaznikId id_zak, List<VybaveniId> vybaveni, List<LodId> lode, Date s, Date k) throws BRentalException{
        Rezervace rez = new Rezervace(new RezervaceId(idCount++), id_zak, vybaveni, lode, s, k);
        rezervaceToId.put(rez.getId(),rez);
        
    }
    
    public void zrusRezervaci(ZakaznikId id){
        rezervaceToId.remove(id);  
    }
    
    public Collection<Rezervace> getRezervace() throws BRentalException{
        return new ArrayList<Rezervace>(rezervaceToId.values());
    }
    
}
