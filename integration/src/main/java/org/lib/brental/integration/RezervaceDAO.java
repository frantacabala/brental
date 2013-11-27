/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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
public interface RezervaceDAO {
    public void vytvorRezervaci(ZakaznikId id_zak, List<VybaveniId> vybaveni, List<LodId> lode, Date s, Date k) throws BRentalException;
    public void zrusRezervaci(ZakaznikId id) throws BRentalException;
    
    public Collection<Rezervace> getRezervace() throws BRentalException;
}
