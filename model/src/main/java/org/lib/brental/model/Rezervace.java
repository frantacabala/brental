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
    private Date datum_start;
    private Date datum_konec;
    
    public Rezervace(RezervaceId id, ZakaznikId id_zak, List<VybaveniId> vybaveni, List<LodId> lode,Date ds, Date dk) {
        this.id = id;
        this.id_zak = id_zak;
        this.vybaveni = vybaveni;
        this.lode = lode;
        this.datum_start = ds;
        this.datum_konec=dk;
    }
    
    public int getPocVybav(){
        return vybaveni.size();
    }
    
    public int getPocLodi(){
        return lode.size();
    }

    public RezervaceId getId() {
        return id;
    }

    public ZakaznikId getId_zak() {
        return id_zak;
    }

    public List<VybaveniId> getVybaveni() {
        return vybaveni;
    }

    public List<LodId> getLode() {
        return lode;
    }

    public Date getDatum_start() {
        return datum_start;
    }

    public Date getDatum_konec() {
        return datum_konec;
    }
    
    
    
}
