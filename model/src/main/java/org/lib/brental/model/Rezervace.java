/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author john
 */
public class Rezervace {
    private RezervaceId id;
    private ZakaznikId id_zak;
    private List<VybaveniId> vybaveni;
    private List<LodId> lode;
    private Date datum;

    public Rezervace(RezervaceId id, ZakaznikId id_zak, List<VybaveniId> vybaveni, List<LodId> lode) {
        this.id = id;
        this.id_zak = id_zak;
        this.vybaveni = vybaveni;
        this.lode = lode;
        datum=new Date();
    }
    
    public int getPocVybav(){
        return vybaveni.size();
    }
    
    public int getPocLodi(){
        return lode.size();
    }
    
    
    
}
