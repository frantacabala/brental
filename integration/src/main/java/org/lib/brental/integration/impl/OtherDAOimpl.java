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
import org.lib.brental.integration.OtherDAO;
import org.lib.brental.model.Other;
import org.lib.brental.model.Vybaveni;
import org.lib.brental.model.VybaveniId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
class OtherDAOimpl implements OtherDAO {

    private static int idCount;
    
    private Map<VybaveniId,Other> others = new ConcurrentHashMap<VybaveniId, Other>();
        
    public OtherDAOimpl() {
    }

    public Other create(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha,String evid, String poznamka) throws BRentalException {
        Other other = new Other(new VybaveniId(idCount++),nazev,nakup_cena,datum_nakup,barva,pujc_cena,vaha,evid,poznamka);
        others.put(other.getId(), other);
        return other;
    }

    public void delete(VybaveniId id) throws BRentalException {
    others.remove(id);
    }

    public void update(Other other) throws BRentalException {
        others.put(other.getId(), other);
    }

    public Other find(VybaveniId id) throws BRentalException {
      return others.get(id);
    }

    public Collection<Vybaveni> getAll() throws BRentalException {
        return new ArrayList<Vybaveni>(others.values());
    }
    
}
