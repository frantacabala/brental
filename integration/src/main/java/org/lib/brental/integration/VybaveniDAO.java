/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration;

import java.util.Collection;
import java.util.Date;
import org.lib.brental.model.Vybaveni;
import org.lib.brental.model.VybaveniId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public interface VybaveniDAO {
    public Vybaveni create(VybaveniId id, String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha,String evid) throws BRentalException;
    
    public void delete(VybaveniId id) throws BRentalException;
    
    public void update(Vybaveni vyb) throws BRentalException;
    
    public Vybaveni find(VybaveniId id) throws BRentalException;

    public Collection<Vybaveni> getAll() throws BRentalException;
}
