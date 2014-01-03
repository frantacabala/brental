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
public class Other extends Vybaveni<Other> {
    private String poznamka;
    
    public Other(VybaveniId id, String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha,String evid, String poznamka) {
        super(id, nazev, nakup_cena, datum_nakup, barva, pujc_cena, vaha,evid);
        this.poznamka=poznamka;
    }

    public Other() {
        
    }

    public String getPoznamka() {
        return poznamka;
    }
    
}
