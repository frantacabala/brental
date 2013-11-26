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
    private Adresa adresa;
    
    public Zakaznik(ZakaznikId id,String jmeno, Adresa adresa){
        this.id=id;
        this.jmeno=jmeno;
        this.adresa=adresa;
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
    
    
    
}
