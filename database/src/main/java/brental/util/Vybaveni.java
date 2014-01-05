package brental.util;
// Generated Jan 5, 2014 1:07:36 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Vybaveni generated by hbm2java
 */
public class Vybaveni  implements java.io.Serializable {


     private Integer vybaveniId;
     private TypVybaveni typVybaveni;
     private Double cenaZakoupeni;
     private Date datumZakoupeni;
     private String evidCislo;

    public Vybaveni() {
    }

	
    public Vybaveni(String evidCislo) {
        this.evidCislo = evidCislo;
    }
    public Vybaveni(TypVybaveni typVybaveni, Double cenaZakoupeni, Date datumZakoupeni, String evidCislo) {
       this.typVybaveni = typVybaveni;
       this.cenaZakoupeni = cenaZakoupeni;
       this.datumZakoupeni = datumZakoupeni;
       this.evidCislo = evidCislo;
    }
   
    public Integer getVybaveniId() {
        return this.vybaveniId;
    }
    
    public void setVybaveniId(Integer vybaveniId) {
        this.vybaveniId = vybaveniId;
    }
    public TypVybaveni getTypVybaveni() {
        return this.typVybaveni;
    }
    
    public void setTypVybaveni(TypVybaveni typVybaveni) {
        this.typVybaveni = typVybaveni;
    }
    public Double getCenaZakoupeni() {
        return this.cenaZakoupeni;
    }
    
    public void setCenaZakoupeni(Double cenaZakoupeni) {
        this.cenaZakoupeni = cenaZakoupeni;
    }
    public Date getDatumZakoupeni() {
        return this.datumZakoupeni;
    }
    
    public void setDatumZakoupeni(Date datumZakoupeni) {
        this.datumZakoupeni = datumZakoupeni;
    }
    public String getEvidCislo() {
        return this.evidCislo;
    }
    
    public void setEvidCislo(String evidCislo) {
        this.evidCislo = evidCislo;
    }




}


