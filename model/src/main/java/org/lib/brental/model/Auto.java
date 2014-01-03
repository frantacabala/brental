/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author john
 */
public class Auto implements  Serializable{
    private AutoId id;
    private int cena_zakoupeni;
    private Date datum_zakoupeni;
    private String znacka;
    private Date datum_tk;
    private int kapacita; // kapacita v lodich

    public Auto(AutoId id, String znacka, int kapacita,int cena_zakoupeni, Date datum_zakoupeni,Date datum_tk) {
        this.id = id;
        this.znacka = znacka;
        this.kapacita = kapacita;
        this.cena_zakoupeni=cena_zakoupeni;
        try {
            this.datum_zakoupeni=new SimpleDateFormat("yyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(datum_zakoupeni));
            this.datum_tk=new SimpleDateFormat("yyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(datum_tk));
        } catch (ParseException ex) {
            Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public Date getDatum_tk() {
        return datum_tk;
    }
    
    
    
    
}
