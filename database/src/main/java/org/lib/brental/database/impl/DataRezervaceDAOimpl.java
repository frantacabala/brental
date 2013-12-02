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
import java.util.List;
import java.util.Map;
import org.lib.brental.integration.RezervaceDAO;
import org.lib.brental.model.FakturaId;

import org.lib.brental.model.Rezervace;
import org.lib.brental.model.RezervaceId;
import org.lib.brental.model.VybaveniId;
import org.lib.brental.model.ZakaznikId;
import org.lib.brental.model.ZamestnanecId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
class DataRezervaceDAOimpl implements RezervaceDAO {

    public DataRezervaceDAOimpl(Connection con) {
    }
   PreparedStatement psCreate;
    public void vytvorRezervaci(ZakaznikId id_zak, ZamestnanecId id_zam, FakturaId id_fak, List<VybaveniId> vybaveni, Date ds, Date dk) throws BRentalException {
        Rezervace rez = new Rezervace(new RezervaceId(idCount++), id_zak, id_zam, id_fak, vybaveni, ds, dk);
  
    }

    public void prijmiRezervaci(Rezervace rez) {
        rez.setStav(true);
        rezervaceToId.put(rez.getId(), rez);
    }

    public Collection<VybaveniId> getVybaveni(Rezervace rez) {
        return new ArrayList<VybaveniId>(rez.getVybaveni());
    }

    public void zrusRezervaci(RezervaceId id) {
        rezervaceToId.remove(id);
    }

    public Collection<Rezervace> getRezervace() throws BRentalException {
        return new ArrayList<Rezervace>(rezervaceToId.values());
    }
}
