/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration;

import java.util.Collection;
import java.util.Date;
import org.lib.brental.model.Auto;
import org.lib.brental.model.AutoId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public interface AutoDAO {
    public Auto create(String spz,int kapacita,int cena_zakoupeni, Date datum_zakoupeni, Date datum_tk) throws BRentalException;
    public void delete(AutoId id) throws BRentalException;
    public void update(Auto aut) throws BRentalException;
    public Auto find (AutoId id) throws BRentalException;
    public Collection<Auto> getAll() throws BRentalException;
}
