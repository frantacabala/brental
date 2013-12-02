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
import org.lib.brental.integration.PadloDAO;
import org.lib.brental.model.Padlo;
import org.lib.brental.model.VybaveniId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
class DataPadloDAOimpl implements PadloDAO {

    PreparedStatement psCreate;
    public DataPadloDAOimpl(Connection con) {
    }

    public Padlo create(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha, int delka, int sirka_listu, String typ) throws BRentalException {
        Padlo padlo = new Padlo(new VybaveniId("PA"+Integer.toString(idCount++)),nazev,nakup_cena,datum_nakup,barva,pujc_cena,vaha,delka,sirka_listu,typ);
        return padlo;
    }

    public void delete(VybaveniId id) throws BRentalException {
     padla.remove(id);
    }

    public void update(Padlo padlo) throws BRentalException {
    padla.put(padlo.getId(), padlo);
    }

    public Padlo find(VybaveniId id) throws BRentalException {
        return padla.get(id);
    }

    public Collection<Padlo> getAll() throws BRentalException {
        return new ArrayList<Padlo>(padla.values());
    }
    
}
