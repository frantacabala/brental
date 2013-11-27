/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration;

import java.util.Collection;
import org.lib.brental.model.Adresa;
import org.lib.brental.model.Zakaznik;
import org.lib.brental.model.ZakaznikId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public interface ZakaznikDAO {
    public Zakaznik create(String jmeno, Adresa adresa) throws BRentalException;
    
    public void delete(ZakaznikId id) throws BRentalException;
   
    public void update(Zakaznik zak) throws BRentalException;
    
    public Zakaznik find(ZakaznikId id) throws BRentalException;
    
    public Collection<Zakaznik> getAll() throws BRentalException;
}
