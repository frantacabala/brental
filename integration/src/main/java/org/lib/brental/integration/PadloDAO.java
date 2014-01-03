/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration;

import java.util.Collection;
import java.util.Date;
import org.lib.brental.model.Padlo;
import org.lib.brental.model.Vybaveni;
import org.lib.brental.model.VybaveniId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public interface PadloDAO {
    public Padlo create(String nazev, int nakup_cena, Date datum_nakup, String barva, 
                        int pujc_cena, int vaha,String evid, int delka, int sirka_listu,String typ) throws BRentalException;
    public void delete(VybaveniId id) throws BRentalException;
    public void update(Padlo padlo) throws BRentalException;
    public Padlo find (VybaveniId id) throws BRentalException;
    public Collection<Vybaveni> getAll() throws BRentalException;
}
