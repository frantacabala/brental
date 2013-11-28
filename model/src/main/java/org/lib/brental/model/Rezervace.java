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
    private FakturaId id_fak;
    private ZamestnanecId id_zam;
    private boolean stav; // true - schvalena, false - cekajici
    private List<VybaveniId> vybaveni;
    
    private Date datum_start;
    private Date datum_konec;
    
    public Rezervace(RezervaceId id, ZakaznikId id_zak,ZamestnanecId id_zam,FakturaId id_fak, List<VybaveniId> vybaveni,Date ds, Date dk) {
        this.id = id;
        this.id_zak = id_zak;
        this.id_fak=id_fak;
        this.id_zam=id_zam;
        this.vybaveni = vybaveni;
        this.datum_start = ds;
        this.datum_konec=dk;
        this.stav=false;
        
    }

    public boolean getStav() {
        return stav;
    }

    public FakturaId getId_fak() {
        return id_fak;
    }

    public ZamestnanecId getId_zam() {
        return id_zam;
    }

    public void setStav(boolean stav) {
        this.stav = stav;
    }
    
    public int getPocVybav(){
        return vybaveni.size();
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
   
    public Date getDatum_start() {
        return datum_start;
    }

    public Date getDatum_konec() {
        return datum_konec;
    }
    
    
    
}
