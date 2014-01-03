/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration;

import java.util.Collection;
import java.util.Date;
import org.lib.brental.model.Other;
import org.lib.brental.model.Vybaveni;
import org.lib.brental.model.VybaveniId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public interface OtherDAO {
    public Other create(String nazev, int nakup_cena, Date datum_nakup, String barva, 
                        int pujc_cena, int vaha,String evid, String poznamka) throws BRentalException;
    public void delete(VybaveniId id) throws BRentalException;
    public void update(Other other) throws BRentalException;
    public Other find (VybaveniId id) throws BRentalException;
    public Collection<Vybaveni> getAll() throws BRentalException;
}
