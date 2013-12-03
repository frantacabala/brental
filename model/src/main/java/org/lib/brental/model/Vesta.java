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
public class Vesta extends Vybaveni<Vesta>{
    private String typ;
    private String velikost;
    private String vyrobce;

    public Vesta(VybaveniId id, String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha,String typ, String velikost, String vyrobce) {
        super(id, nazev, nakup_cena, datum_nakup, barva, pujc_cena, vaha);
        this.typ=typ;
        this.velikost=velikost;
        this.vyrobce=vyrobce;
    }

    public String getTyp() {
        return typ;
    }

    public String getVelikost() {
        return velikost;
    }

    public String getVyrobce() {
        return vyrobce;
    }
    
    
    
    
    
}
