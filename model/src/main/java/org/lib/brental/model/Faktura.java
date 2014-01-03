/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author john
 */
public class Faktura {
    private FakturaId id;
    private ZamestnanecId id_zam;
    private Date datum_vystaveni;
    private Date datum_splatnosti;
   

    public Faktura(FakturaId id, ZamestnanecId id_zam,Date datum_vystaveni,Date datum_splatnosti) {
        this.id = id;
        this.id_zam=id_zam;
        try {
            
            this.datum_vystaveni=new SimpleDateFormat("yyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(datum_vystaveni));
            this.datum_vystaveni=new SimpleDateFormat("yyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(datum_splatnosti));
        } catch (ParseException ex) {
            Logger.getLogger(Faktura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public FakturaId getId() {
        return id;
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
