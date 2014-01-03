/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration;

import java.util.Collection;
import java.util.Date;
import org.lib.brental.model.Lod;
import org.lib.brental.model.Vybaveni;
import org.lib.brental.model.VybaveniId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public interface LodDAO {
    public Lod create(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha,String evid,
            int delka, int max_ponor, String model, int nostnost, int sirka, String typ, String vyrobce) throws BRentalException;
    public void delete(VybaveniId id) throws BRentalException;
    public void update(Lod lod) throws BRentalException;
    public Lod find (VybaveniId id) throws BRentalException;
    public Collection<Vybaveni> getAll() throws BRentalException;
}
