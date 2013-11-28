/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.lib.brental.integration.ZamestnanecDAO;
import org.lib.brental.model.Adresa;
import org.lib.brental.model.Zamestnanec;
import org.lib.brental.model.ZamestnanecId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class ZamestnanecDAOimpl implements ZamestnanecDAO {

    private Map<ZamestnanecId,Zamestnanec> zamestnanci = new ConcurrentHashMap<ZamestnanecId, Zamestnanec>();
    private static int idCount;
    
    
    public ZamestnanecDAOimpl() {
        
    }
    
    public Zamestnanec create(String jmeno,String prijimeni,String login,String heslo,Adresa adresa, String funkce) throws BRentalException{
        Zamestnanec zam = new Zamestnanec(new ZamestnanecId(idCount++), jmeno,prijimeni,login,heslo,adresa, funkce);
        zamestnanci.put(zam.getId(), zam);
        return zam;
    }
    
    public void delete(ZamestnanecId id) throws BRentalException{
        zamestnanci.remove(id);
        idCount--;
    }
    
    public void update(Zamestnanec zam) throws BRentalException{
        zamestnanci.put(zam.getId(), zam);
    }
    
    public Zamestnanec find(ZamestnanecId id) throws BRentalException{
        return zamestnanci.get(id);
    }
    
    public Collection<Zamestnanec> getAll() throws BRentalException{
        return new ArrayList<Zamestnanec>(zamestnanci.values());
    }
    
}
