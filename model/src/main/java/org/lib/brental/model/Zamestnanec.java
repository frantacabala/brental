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
    private String prijimeni;
    private String login;
    private String heslo;
    private Adresa adresa;
    private String pracovni_pozice;

    public Zamestnanec(ZamestnanecId id, String jmeno,String prijimeni,String login, String heslo,Adresa adresa, String funkce) {
        this.id = id;
        this.jmeno = jmeno;
        this.prijimeni=prijimeni;
        this.login=login;
        this.heslo=heslo;
        this.adresa=adresa;
        this.pracovni_pozice = funkce;
    }

    public ZamestnanecId getId() {
        return id;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getFunkce() {
        return pracovni_pozice;
    }

    public String getPrijimeni() {
        return prijimeni;
    }

    public String getLogin() {
        return login;
    }

    public String getHeslo() {
        return heslo;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public String getPracovni_pozice() {
        return pracovni_pozice;
    }
    
    
    
    
}
