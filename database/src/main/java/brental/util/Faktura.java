package brental.util;
// Generated Jan 5, 2014 1:07:36 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Faktura generated by hbm2java
 */
public class Faktura  implements java.io.Serializable {


     private Integer fakturaId;
     private Zamestnanec zamestnanec;
     private int cislo;
     private String soubor;
     private Date splatnost;
     private Date vystaveni;
     private Set rezervaces = new HashSet(0);

    public Faktura() {
    }

	
    public Faktura(int cislo, Date splatnost, Date vystaveni) {
        this.cislo = cislo;
        this.splatnost = splatnost;
        this.vystaveni = vystaveni;
    }
    public Faktura(Zamestnanec zamestnanec, int cislo, String soubor, Date splatnost, Date vystaveni, Set rezervaces) {
       this.zamestnanec = zamestnanec;
       this.cislo = cislo;
       this.soubor = soubor;
       this.splatnost = splatnost;
       this.vystaveni = vystaveni;
       this.rezervaces = rezervaces;
    }
   
    public Integer getFakturaId() {
        return this.fakturaId;
    }
    
    public void setFakturaId(Integer fakturaId) {
        this.fakturaId = fakturaId;
    }
    public Zamestnanec getZamestnanec() {
        return this.zamestnanec;
    }
    
    public void setZamestnanec(Zamestnanec zamestnanec) {
        this.zamestnanec = zamestnanec;
    }
    public int getCislo() {
        return this.cislo;
    }
    
    public void setCislo(int cislo) {
        this.cislo = cislo;
    }
    public String getSoubor() {
        return this.soubor;
    }
    
    public void setSoubor(String soubor) {
        this.soubor = soubor;
    }
    public Date getSplatnost() {
        return this.splatnost;
    }
    
    public void setSplatnost(Date splatnost) {
        this.splatnost = splatnost;
    }
    public Date getVystaveni() {
        return this.vystaveni;
    }
    
    public void setVystaveni(Date vystaveni) {
        this.vystaveni = vystaveni;
    }
    public Set getRezervaces() {
        return this.rezervaces;
    }
    
    public void setRezervaces(Set rezervaces) {
        this.rezervaces = rezervaces;
    }




}

