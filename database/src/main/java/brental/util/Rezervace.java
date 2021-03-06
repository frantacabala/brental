package brental.util;
// Generated Jan 5, 2014 1:07:36 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Rezervace generated by hbm2java
 */
public class Rezervace  implements java.io.Serializable {


     private Integer rezervaceId;
     private Zakaznik zakaznik;
     private Faktura faktura;
     private Zamestnanec zamestnanec;
     private KontrolniBod kontrolniBod;
     private Date doData;
     private Date odData;
     private boolean potvrzena;

    public Rezervace() {
    }

	
    public Rezervace(Date doData, Date odData, boolean potvrzena) {
        this.doData = doData;
        this.odData = odData;
        this.potvrzena = potvrzena;
    }
    public Rezervace(Zakaznik zakaznik, Faktura faktura, Zamestnanec zamestnanec, KontrolniBod kontrolniBod, Date doData, Date odData, boolean potvrzena) {
       this.zakaznik = zakaznik;
       this.faktura = faktura;
       this.zamestnanec = zamestnanec;
       this.kontrolniBod = kontrolniBod;
       this.doData = doData;
       this.odData = odData;
       this.potvrzena = potvrzena;
    }
   
    public Integer getRezervaceId() {
        return this.rezervaceId;
    }
    
    public void setRezervaceId(Integer rezervaceId) {
        this.rezervaceId = rezervaceId;
    }
    public Zakaznik getZakaznik() {
        return this.zakaznik;
    }
    
    public void setZakaznik(Zakaznik zakaznik) {
        this.zakaznik = zakaznik;
    }
    public Faktura getFaktura() {
        return this.faktura;
    }
    
    public void setFaktura(Faktura faktura) {
        this.faktura = faktura;
    }
    public Zamestnanec getZamestnanec() {
        return this.zamestnanec;
    }
    
    public void setZamestnanec(Zamestnanec zamestnanec) {
        this.zamestnanec = zamestnanec;
    }
    public KontrolniBod getKontrolniBod() {
        return this.kontrolniBod;
    }
    
    public void setKontrolniBod(KontrolniBod kontrolniBod) {
        this.kontrolniBod = kontrolniBod;
    }
    public Date getDoData() {
        return this.doData;
    }
    
    public void setDoData(Date doData) {
        this.doData = doData;
    }
    public Date getOdData() {
        return this.odData;
    }
    
    public void setOdData(Date odData) {
        this.odData = odData;
    }
    public boolean isPotvrzena() {
        return this.potvrzena;
    }
    
    public void setPotvrzena(boolean potvrzena) {
        this.potvrzena = potvrzena;
    }




}


