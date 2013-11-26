/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.model;

/**
 *
 * @author john
 */
public class Zamestnanec {
    private ZamestnanecId id;
    private String jmeno;
    private String funkce;

    public Zamestnanec(ZamestnanecId id, String jmeno, String funkce) {
        this.id = id;
        this.jmeno = jmeno;
        this.funkce = funkce;
    }

    public ZamestnanecId getId() {
        return id;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getFunkce() {
        return funkce;
    }
    
    
    
}
