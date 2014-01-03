/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration;

import java.util.Collection;
import java.util.Date;
import org.lib.brental.model.Faktura;
import org.lib.brental.model.FakturaId;
import org.lib.brental.model.RezervaceId;
import org.lib.brental.model.ZamestnanecId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public interface FakturaDAO {
    public Faktura create(ZamestnanecId id_zam,Date datum_vystaveni,Date datum_splatnosti) throws BRentalException;
    public void delete(FakturaId id) throws BRentalException;
    public void update(Faktura fak) throws BRentalException;
    public Faktura find (FakturaId id) throws BRentalException;
    public Collection<Faktura> getAll() throws BRentalException;
}
