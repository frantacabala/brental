/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.model;

/**
 *
 * @author john
 */
public class Zakaznik {
    private ZakaznikId id;
    private String jmeno;
    private String prijimeni;
    private Adresa adresa;
    private int cislo_op;
    
    public Zakaznik(ZakaznikId id,String jmeno,String prijimeni, Adresa adresa, int cislo_op){
        this.id=id;
        this.jmeno=jmeno;
        this.prijimeni=prijimeni;
        this.adresa=adresa;
        this.cislo_op=cislo_op;
    }

    public ZakaznikId getId() {
        return id;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijimeni() {
        return prijimeni;
    }

    public int getCislo_op() {
        return cislo_op;
    }
    
    
    
}
