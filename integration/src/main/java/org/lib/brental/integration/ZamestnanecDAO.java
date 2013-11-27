/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration;

import java.util.Collection;
import org.lib.brental.model.Adresa;
import org.lib.brental.model.Zamestnanec;
import org.lib.brental.model.ZamestnanecId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public interface ZamestnanecDAO {
     public Zamestnanec create(String jmeno,Adresa adresa, String funkce) throws BRentalException;
    
    public void delete(ZamestnanecId id) throws BRentalException;
    
    public void update(Zamestnanec zam) throws BRentalException;
    
    public Zamestnanec find(ZamestnanecId id) throws BRentalException;
    
    public Collection<Zamestnanec> getAll() throws BRentalException;
    
}
