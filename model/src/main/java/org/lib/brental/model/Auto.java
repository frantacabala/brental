/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.model;

/**
 *
 * @author john
 */
public class Auto {
    private AutoId id;
    private String znacka;
    private int kapacita;

    public Auto(AutoId id, String znacka, int kapacita) {
        this.id = id;
        this.znacka = znacka;
        this.kapacita = kapacita;
    }

    public int getKapacita() {
        return kapacita;
    }
    
    

    public AutoId getId() {
        return id;
    }

    public String getZnacka() {
        return znacka;
    }
    
    
    
    
}
