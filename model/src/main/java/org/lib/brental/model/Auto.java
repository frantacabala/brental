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
public class Auto {
    private AutoId id;
    private int cena_zakoupeni;
    private Date datum_zakoupeni;
    private String znacka;
    private int kapacita; // kapacita v lodich

    public Auto(AutoId id, String znacka, int kapacita,int cena_zakoupeni, Date datum_zakoupeni) {
        this.id = id;
        this.znacka = znacka;
        this.kapacita = kapacita;
        this.cena_zakoupeni=cena_zakoupeni;
        this.datum_zakoupeni=datum_zakoupeni;
    }

    public int getKapacita() {
        return kapacita;
    }

    public int getCena_zakoupeni() {
        return cena_zakoupeni;
    }

    public Date getDatum_zakoupeni() {
        return datum_zakoupeni;
    }
    
    

    public AutoId getId() {
        return id;
    }

    public String getZnacka() {
        return znacka;
    }
    
    
    
    
}
