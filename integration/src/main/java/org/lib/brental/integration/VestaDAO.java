/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration;

import java.util.Collection;
import java.util.Date;
import org.lib.brental.model.Vesta;
import org.lib.brental.model.VybaveniId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public interface VestaDAO {
    public Vesta create(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, 
                        int vaha,String typ, String velikost, String vyrobce) throws BRentalException;
    public void delete(VybaveniId id) throws BRentalException;
    public void update(Vesta lod) throws BRentalException;
    public Vesta find (VybaveniId id) throws BRentalException;
    public Collection<Vesta> getAll() throws BRentalException;
}
