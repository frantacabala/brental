/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration;

import java.util.Collection;
import org.lib.brental.model.Faktura;
import org.lib.brental.model.FakturaId;
import org.lib.brental.model.RezervaceId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public interface FakturaDAO {
    public Faktura create(RezervaceId id) throws BRentalException;
    public void delete(FakturaId id) throws BRentalException;
    public void update(Faktura fak) throws BRentalException;
    public Faktura find (FakturaId id) throws BRentalException;
    public Collection<Faktura> getAll() throws BRentalException;
}
