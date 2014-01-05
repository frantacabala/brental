package brental.util;
// Generated Jan 5, 2014 1:07:36 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Zakaznik generated by hbm2java
 */
public class Zakaznik  implements java.io.Serializable {


     private Integer zakaznikId;
     private String adresa;
     private String cisloOp;
     private String jmeno;
     private String prijmeni;
     private String ulice;
     private String mesto;
     private int psc;
     private Set rezervaces = new HashSet(0);

    public Zakaznik() {
    }

	
    public Zakaznik(String jmeno, String prijmeni, String ulice, String mesto, int psc) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.ulice = ulice;
        this.mesto = mesto;
        this.psc = psc;
    }
    public Zakaznik(String adresa, String cisloOp, String jmeno, String prijmeni, String ulice, String mesto, int psc, Set rezervaces) {
       this.adresa = adresa;
       this.cisloOp = cisloOp;
       this.jmeno = jmeno;
       this.prijmeni = prijmeni;
       this.ulice = ulice;
       this.mesto = mesto;
       this.psc = psc;
       this.rezervaces = rezervaces;
    }
   
    public Integer getZakaznikId() {
        return this.zakaznikId;
    }
    
    public void setZakaznikId(Integer zakaznikId) {
        this.zakaznikId = zakaznikId;
    }
    public String getAdresa() {
        return this.adresa;
    }
    
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    public String getCisloOp() {
        return this.cisloOp;
    }
    
    public void setCisloOp(String cisloOp) {
        this.cisloOp = cisloOp;
    }
    public String getJmeno() {
        return this.jmeno;
    }
    
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }
    public String getPrijmeni() {
        return this.prijmeni;
    }
    
    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }
    public String getUlice() {
        return this.ulice;
    }
    
    public void setUlice(String ulice) {
        this.ulice = ulice;
    }
    public String getMesto() {
        return this.mesto;
    }
    
    public void setMesto(String mesto) {
        this.mesto = mesto;
    }
    public int getPsc() {
        return this.psc;
    }
    
    public void setPsc(int psc) {
        this.psc = psc;
    }
    public Set getRezervaces() {
        return this.rezervaces;
    }
    
    public void setRezervaces(Set rezervaces) {
        this.rezervaces = rezervaces;
    }




}


