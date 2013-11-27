/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration;

import java.util.Collection;
import org.lib.brental.model.Lod;
import org.lib.brental.model.LodId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public interface LodDAO {
    public Lod create(String typ,int kapacita) throws BRentalException;
    public void delete(LodId id) throws BRentalException;
    public void update(Lod lod) throws BRentalException;
    public Lod find (LodId id) throws BRentalException;
    public Collection<Lod> getAll() throws BRentalException;
}
