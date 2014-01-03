/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.protocol;

import java.util.Date;
import org.lib.brental.bussines.BrentalFacadeInterface;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class CreateAuto extends BrentalCommand{

    private String spz;
    private int kapacita;
    private int cena_zakoupeni;
    private Date datum_zakoupeni;
    private Date datum_tk;
    
    public CreateAuto(){
        
    }

    public CreateAuto(String spz, int kapacita, int cena_zakoupeni, Date datum_zakoupeni, Date datum_tk) {
        this.spz = spz;
        this.kapacita = kapacita;
        this.cena_zakoupeni = cena_zakoupeni;
        this.datum_zakoupeni = datum_zakoupeni;
        this.datum_tk = datum_tk;
    }

    public String getSpz() {
        return spz;
    }

    public void setSpz(String spz) {
        this.spz = spz;
    }

    public int getKapacita() {
        return kapacita;
    }

    public void setKapacita(int kapacita) {
        this.kapacita = kapacita;
    }

    public int getCena_zakoupeni() {
        return cena_zakoupeni;
    }

    public void setCena_zakoupeni(int cena_zakoupeni) {
        this.cena_zakoupeni = cena_zakoupeni;
    }

    public Date getDatum_zakoupeni() {
        return datum_zakoupeni;
    }

    public void setDatum_zakoupeni(Date datum_zakoupeni) {
        this.datum_zakoupeni = datum_zakoupeni;
    }

    public Date getDatum_tk() {
        return datum_tk;
    }

    public void setDatum_tk(Date datum_tk) {
        this.datum_tk = datum_tk;
    }
    
    
    @Override
    public Object execute(BrentalFacadeInterface brentalFacede) throws BRentalException {
        return brentalFacede.vytvorAuto(spz, kapacita, cena_zakoupeni, datum_zakoupeni, datum_tk);
    }
    
    
    public String toString(){
        return String.format("%s(%s)", getClass().getSimpleName(),spz);
    }
}
