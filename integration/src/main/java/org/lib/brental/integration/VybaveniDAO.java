/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration;

import java.util.Collection;
import org.lib.brental.model.Vybaveni;
import org.lib.brental.model.VybaveniId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public interface VybaveniDAO {
    public Vybaveni create(String nazev,int pocet,String velikost) throws BRentalException;
    
    public void delete(VybaveniId id) throws BRentalException;
    
    public void update(Vybaveni vyb) throws BRentalException;
    
    public Vybaveni find(VybaveniId id) throws BRentalException;

    public Collection<Vybaveni> getAll() throws BRentalException;
}
