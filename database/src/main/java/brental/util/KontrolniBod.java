package brental.util;
// Generated Jan 5, 2014 1:07:36 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * KontrolniBod generated by hbm2java
 */
public class KontrolniBod  implements java.io.Serializable {


     private Integer kontrolniBodId;
     private double kmReky;
     private String nazev;
     private String reka;
     private Set rezervaces = new HashSet(0);
     private Set rezervaces_1 = new HashSet(0);

    public KontrolniBod() {
    }

	
    public KontrolniBod(double kmReky) {
        this.kmReky = kmReky;
    }
    public KontrolniBod(double kmReky, String nazev, String reka, Set rezervaces, Set rezervaces_1) {
       this.kmReky = kmReky;
       this.nazev = nazev;
       this.reka = reka;
       this.rezervaces = rezervaces;
       this.rezervaces_1 = rezervaces_1;
    }
   
    public Integer getKontrolniBodId() {
        return this.kontrolniBodId;
    }
    
    public void setKontrolniBodId(Integer kontrolniBodId) {
        this.kontrolniBodId = kontrolniBodId;
    }
    public double getKmReky() {
        return this.kmReky;
    }
    
    public void setKmReky(double kmReky) {
        this.kmReky = kmReky;
    }
    public String getNazev() {
        return this.nazev;
    }
    
    public void setNazev(String nazev) {
        this.nazev = nazev;
    }
    public String getReka() {
        return this.reka;
    }
    
    public void setReka(String reka) {
        this.reka = reka;
    }
    public Set getRezervaces() {
        return this.rezervaces;
    }
    
    public void setRezervaces(Set rezervaces) {
        this.rezervaces = rezervaces;
    }
    public Set getRezervaces_1() {
        return this.rezervaces_1;
    }
    
    public void setRezervaces_1(Set rezervaces_1) {
        this.rezervaces_1 = rezervaces_1;
    }




}


