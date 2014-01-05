/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.model;

import java.io.Serializable;

/**
 *
 * @author john
 */
public class Adresa implements Serializable {
    private String ulice;
    private String mesto;
    private int psc;
    
    public Adresa(String ulice, String mesto, int psc){
        this.mesto=mesto;
        this.ulice=ulice;
        this.psc=psc;
    }

    public String getUlice() {
        return ulice;
    }

    public String getMesto() {
        return mesto;
    }
    
    public int getPsc(){
        return psc;
    }
    
    @Override
    public String toString(){
        
        return ulice+","+mesto+","+psc;
    }
    
}
