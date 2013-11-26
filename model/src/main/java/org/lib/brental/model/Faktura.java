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
    private Date datum;
    private RezervaceId id_rez;

    public Faktura(FakturaId id, RezervaceId id_rez) {
        this.id = id;
        this.id_rez = id_rez;
        datum=new Date();
    }
    
    
    
    
}
