/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.database.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.lib.brental.integration.OtherDAO;
import org.lib.brental.model.Other;
import org.lib.brental.model.VybaveniId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
class DataOtherDAOimpl implements OtherDAO {

    PreparedStatement psCreate;    
    public DataOtherDAOimpl(Connection con) {
    }

    public Other create(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha, String poznamka) throws BRentalException {
        Other other = new Other(new VybaveniId("OT"+Integer.toString(idCount++)),nazev,nakup_cena,datum_nakup,barva,pujc_cena,vaha,poznamka);
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

    public Collection<Other> getAll() throws BRentalException {
        return new ArrayList<Other>(others.values());
    }
    
}
