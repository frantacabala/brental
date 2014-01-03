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
public class Lod extends Vybaveni<Lod> {

    private int delka;
    private int max_ponor;
    private String model;
    private int nostnost;
    private int sirka;
    private String typ;
    private String vyrobce;

    public Lod(VybaveniId id, String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha,String evid,
            int delka, int max_ponor, String model, int nostnost, int sirka, String typ, String vyrobce) {
        super(id, nazev, nakup_cena, datum_nakup, barva, pujc_cena, vaha,evid);
        this.delka = delka;
        this.max_ponor = max_ponor;
        this.model = model;
        this.nostnost = nostnost;
        this.sirka = sirka;
        this.typ = typ;
        this.vyrobce = vyrobce;

    }

    public Lod() {
       
    }

    public int getDelka() {
        return delka;
    }

    public int getMax_ponor() {
        return max_ponor;
    }

    public String getModel() {
        return model;
    }

    public int getNostnost() {
        return nostnost;
    }

    public int getSirka() {
        return sirka;
    }

    public String getTyp() {
        return typ;
    }

    public String getVyrobce() {
        return vyrobce;
    }
}
