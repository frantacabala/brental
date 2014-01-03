/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
            create("Jan", "Kusy", "ADMIN", new Adresa("VANICKOVA", "PRAHA", 16000), "jkusy", "pass1234");
            create("Jan", "Kusy", "ADMIN", new Adresa("VANICKOVA", "PRAHA", 16000), "jkusy", "pass1234");
            create("Jan", "Kusy", "ADMIN", new Adresa("VANICKOVA", "PRAHA", 16000), "jkusy", "pass1234");
        } catch (BRentalException ex) {
            Logger.getLogger(ZamestnanecDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Zamestnanec create(String jmeno,String prijimeni,String funkce,Adresa adresa,String login,String heslo) throws BRentalException{
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
