/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.database.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.lib.brental.integration.AutoDAO;
import org.lib.brental.model.Auto;
import org.lib.brental.model.AutoId;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
class DataAutoDAOimpl implements AutoDAO {

    public DataAutoDAOimpl(Connection con) {
    }
    PreparedStatement psCreate;
    
    
    public Auto create(String spz, int kapacita,int cena_zakoupeni, Date datum_zakoupeni) throws BRentalException{
        Auto fak = new Auto(new AutoId(idCount++), spz,kapacita,cena_zakoupeni,datum_zakoupeni);
        return fak;
    }
    
    public void delete(AutoId id) throws BRentalException{
        auta.remove(id);
    }
   
    public void update(Auto fak) throws BRentalException{
        auta.put(fak.getId(), fak);
    }
    
    public Auto find(AutoId id) throws BRentalException{
        return auta.get(id);
        
    }
    
    public Collection<Auto> getAll() throws BRentalException{
        return new ArrayList<Auto>(auta.values());
    }
}
