package brental.util;
// Generated Jan 5, 2014 1:07:36 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * TypVybaveni generated by hbm2java
 */
public class TypVybaveni  implements java.io.Serializable {


     private Integer typVybaveniId;
     private String barva;
     private double cenaZaPujceniDen;
     private String nazev;
     private double vaha;
     private Padlo padlo;
     private Vesta vesta;
     private Set vybavenis = new HashSet(0);
     private Lod lod;

    public TypVybaveni() {
    }

	
    public TypVybaveni(String barva, double cenaZaPujceniDen, String nazev, double vaha) {
        this.barva = barva;
        this.cenaZaPujceniDen = cenaZaPujceniDen;
        this.nazev = nazev;
        this.vaha = vaha;
    }
    public TypVybaveni(String barva, double cenaZaPujceniDen, String nazev, double vaha, Padlo padlo, Vesta vesta, Set vybavenis, Lod lod) {
       this.barva = barva;
       this.cenaZaPujceniDen = cenaZaPujceniDen;
       this.nazev = nazev;
       this.vaha = vaha;
       this.padlo = padlo;
       this.vesta = vesta;
       this.vybavenis = vybavenis;
       this.lod = lod;
    }
   
    public Integer getTypVybaveniId() {
        return this.typVybaveniId;
    }
    
    public void setTypVybaveniId(Integer typVybaveniId) {
        this.typVybaveniId = typVybaveniId;
    }
    public String getBarva() {
        return this.barva;
    }
    
    public void setBarva(String barva) {
        this.barva = barva;
    }
    public double getCenaZaPujceniDen() {
        return this.cenaZaPujceniDen;
    }
    
    public void setCenaZaPujceniDen(double cenaZaPujceniDen) {
        this.cenaZaPujceniDen = cenaZaPujceniDen;
    }
    public String getNazev() {
        return this.nazev;
    }
    
    public void setNazev(String nazev) {
        this.nazev = nazev;
    }
    public double getVaha() {
        return this.vaha;
    }
    
    public void setVaha(double vaha) {
        this.vaha = vaha;
    }
    public Padlo getPadlo() {
        return this.padlo;
    }
    
    public void setPadlo(Padlo padlo) {
        this.padlo = padlo;
    }
    public Vesta getVesta() {
        return this.vesta;
    }
    
    public void setVesta(Vesta vesta) {
        this.vesta = vesta;
    }
    public Set getVybavenis() {
        return this.vybavenis;
    }
    
    public void setVybavenis(Set vybavenis) {
        this.vybavenis = vybavenis;
    }
    public Lod getLod() {
        return this.lod;
    }
    
    public void setLod(Lod lod) {
        this.lod = lod;
    }




}

