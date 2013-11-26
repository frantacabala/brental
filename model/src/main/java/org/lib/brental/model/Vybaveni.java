/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.model;

/**
 *
 * @author john
 */
public class Vybaveni {
    private VybaveniId id;
    private String nazev;
    private int pocet;
    private String velikost; // M,L,...male velke, cislo atd

    public Vybaveni(VybaveniId id, String nazev, int pocet, String velikost) {
        this.id = id;
        this.nazev = nazev;
        this.pocet = pocet;
        this.velikost = velikost;
    }

    public VybaveniId getId() {
        return id;
    }

    public String getNazev() {
        return nazev;
    }

    public int getPocet() {
        return pocet;
    }

    public String getVelikost() {
        return velikost;
    }
    
}
