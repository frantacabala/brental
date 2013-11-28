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
public class Padlo extends Vybaveni<Padlo> {
    private int delka;
    private int sirka_listu;
    private String typ;
    
    public Padlo(VybaveniId id, String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha, int delka, int sirka_listu,String typ){
                super(id, nazev, nakup_cena, datum_nakup, barva, pujc_cena, vaha);
                this.delka=delka;
                this.sirka_listu=sirka_listu;
                this.typ=typ;
                
    }

    public int getDelka() {
        return delka;
    }

    public int getSirka_listu() {
        return sirka_listu;
    }

    public String getTyp() {
        return typ;
    }
    
    
    
    
}