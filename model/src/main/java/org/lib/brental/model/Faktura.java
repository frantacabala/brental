/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.model;

import java.util.Collection;
import java.util.Date;

/**
 *
 * @author john
 */
public class Faktura {
    private FakturaId id;
    private ZamestnanecId id_zam;
    private Date datum_vystaveni;
    private Date datum_splatnosti;
    private RezervaceId id_rez;

    public Faktura(FakturaId id, RezervaceId id_rez,ZamestnanecId id_zam,Date datum_vystaveni,Date datum_splatnosti) {
        this.id = id;
        this.id_rez = id_rez;
        this.id_zam=id_zam;
        this.datum_splatnosti=datum_splatnosti;
        this.datum_vystaveni=datum_vystaveni;
    }

    public FakturaId getId() {
        return id;
    }

    public RezervaceId getId_rez() {
        return id_rez;
    }

    public ZamestnanecId getId_zam() {
        return id_zam;
    }

    public Date getDatum_vystaveni() {
        return datum_vystaveni;
    }

    public Date getDatum_splatnosti() {
        return datum_splatnosti;
    }
    
    
    
    
}
