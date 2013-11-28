/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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
public interface RezervaceDAO {

    public void vytvorRezervaci(ZakaznikId id_zak, ZamestnanecId id_zam, FakturaId id_fak, List<VybaveniId> vybaveni, Date ds, Date dk) throws BRentalException;

    public void zrusRezervaci(RezervaceId id) throws BRentalException;

    public void prijmiRezervaci(Rezervace rez) throws BRentalException;

    public Collection<VybaveniId> getVybaveni(Rezervace rez) throws BRentalException;

    public Collection<Rezervace> getRezervace() throws BRentalException;
}
