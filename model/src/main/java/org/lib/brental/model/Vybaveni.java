/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private String evid;
    
    public Vybaveni(){
        
    }
    
    public Vybaveni(VybaveniId id, String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha, String evid) {
        this.id = id;
        this.nazev = nazev;
        this.nakup_cena = nakup_cena;
        try {
            this.datum_nakup = new SimpleDateFormat("yyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(datum_nakup));
        } catch (ParseException ex) {
            Logger.getLogger(Vybaveni.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.barva = barva;
        this.pujc_cena = pujc_cena;
        this.vaha = vaha;
        this.evid = evid;
       
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

    public String getEvid() {
        return evid;
    }

   

    

    

    
    
}
