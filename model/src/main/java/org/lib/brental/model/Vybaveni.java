/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.model;

import java.util.Date;

/**
 *
 * @author john
 */
public abstract class Vybaveni<T extends Vybaveni<T>> {
    private VybaveniId id;
    private String nazev;
    private int nakup_cena;
    private Date datum_nakup;
    private String barva;
    private int pujc_cena;
    private int vaha;
    
    public Vybaveni(VybaveniId id, String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha) {
        this.id = id;
        this.nazev = nazev;
        this.nakup_cena = nakup_cena;
        this.datum_nakup = datum_nakup;
        this.barva = barva;
        this.pujc_cena = pujc_cena;
        this.vaha = vaha;
       
    }

    public VybaveniId getId() {
        return id;
    }

    public String getNazev() {
        return nazev;
    }

    public int getNakup_cena() {
        return nakup_cena;
    }

    public Date getDatum_nakup() {
        return datum_nakup;
    }

    public String getBarva() {
        return barva;
    }

    public int getPujc_cena() {
        return pujc_cena;
    }

    public int getVaha() {
        return vaha;
    }

   

    

    

    
    
}
