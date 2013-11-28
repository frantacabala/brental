/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.bussines;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.lib.brental.bussines.impl.BrentalFacadeDefault;
import org.osgi.util.tracker.ServiceTracker;
import org.lib.brental.utils.BRentalException;
import org.lib.brental.model.*;

/**
 *
 * @author john
 */
public abstract class BrentalFacade {

    private static ServiceTracker st;
    private static BrentalFacade brentalFacade;

    public static BrentalFacade getDefault() {
        if (brentalFacade == null) {
            brentalFacade = (BrentalFacade) st.getService();
            if (brentalFacade == null) {
                brentalFacade = new BrentalFacadeDefault();
            }
        }
        return brentalFacade;
    }
    
    // operations for car 
    public abstract Auto vytvorAuto(String spz,int kapacita,int cena_zakoupeni, Date datum_zakoupeni) throws BRentalException;
    
    public abstract void smazAuto(AutoId id) throws BRentalException;
    
    public abstract void aktualizujAuto(Auto auto) throws BRentalException;
    
    public abstract Collection<Auto> getAuta() throws BRentalException;
    
    
    //operations for facture
    public abstract Faktura vytvorFakturu(RezervaceId id, ZamestnanecId id_zam, Date datum_vystaveni, Date datum_splatnosti) throws BRentalException;
    
    public abstract void smazFakturu(FakturaId id ) throws BRentalException;
    
    public abstract void aktualizujFakturu(Faktura fak) throws BRentalException;
    
    public abstract Collection<Faktura> getFaktury() throws BRentalException;
    
    
    //operations for boat
    
    public abstract Lod vytvorLod(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha,
            int delka, int max_ponor, String model, int nostnost, int sirka, String typ, String vyrobce) throws BRentalException;
    
    public abstract void smazLod(VybaveniId id) throws BRentalException;
    
    public abstract void aktualizujLod(Lod lod) throws BRentalException;
    
    public abstract Collection<Lod> getLode() throws BRentalException;
    
    //operations for rezervation
    
    public abstract void vytvorRezervaci(ZakaznikId id_zak, ZamestnanecId id_zam, FakturaId id_fak, List<VybaveniId> vybaveni, Date ds, Date dk) throws BRentalException;

    public abstract void zrusRezervaci(RezervaceId id) throws BRentalException;

    public abstract void prijmiRezervaci(Rezervace rez) throws BRentalException;

    public abstract Collection<VybaveniId> getVybaveni(Rezervace rez) throws BRentalException;

    public abstract Collection<Rezervace> getRezervace() throws BRentalException;
    
    /*
    public abstract Vybaveni vytvorVybaveni(String nazev, int pocet, String velikost) throws BRentalException;
    
    public abstract void smazVybaveni(VybaveniId id) throws BRentalException;
    
    public abstract void aktualizujVybaveni(Vybaveni vyb) throws BRentalException;
    
    public abstract Collection<Vybaveni> getVybaveni() throws BRentalException;
    */
    
    public abstract Vesta vytvorVestu(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena,
                                        int vaha, String typ, String velikost, String vyrobce) throws BRentalException;
    
    public abstract void smazVestu(VybaveniId id) throws BRentalException;
    
    public abstract void aktualizujVestu(Vesta vest) throws BRentalException;
    
    public abstract Collection<Vesta> getVesty() throws BRentalException;
    
    
    
    public abstract Padlo vytvorPadlo(String nazev, int nakup_cena, Date datum_nakup, String barva, 
                        int pujc_cena, int vaha, int delka, int sirka_listu,String typ) throws BRentalException;
    
    public abstract void smazPadlo(VybaveniId id) throws BRentalException;
    
    public abstract void aktualizujPadlo(Padlo padlo) throws BRentalException;
    
    public abstract Collection<Padlo> getPadla() throws BRentalException;
    
    
    
    public abstract Other vytvorOther(String nazev, int nakup_cena, Date datum_nakup, String barva, 
                                       int pujc_cena, int vaha, String poznamka) throws BRentalException;
    
    public abstract void smazOther(VybaveniId id) throws BRentalException;
    
    public abstract void aktualizujOther(Other other) throws BRentalException;
    
    public abstract Collection<Other> getOther() throws BRentalException;
    
    
    
    public abstract Zakaznik vytvorZakaznika(String jmeno,String prijimeni, Adresa adresa, int cislo_op) throws BRentalException;
    
    public abstract void smazZakanika(ZakaznikId id) throws BRentalException;
    
    public abstract void aktualizujZakaznika(Zakaznik zak) throws BRentalException;
    
    public abstract Collection<Zakaznik> getZakazniky() throws BRentalException;
    
    
    
    public abstract Zamestnanec vytvorZamestnance(String jmeno,String prijimeni,String login, String heslo,Adresa adresa, String funkce) throws BRentalException;
    
    public abstract void smazZamestnance(ZamestnanecId id) throws BRentalException;
    
    public abstract void aktualizujZamestnance(Zamestnanec zam) throws BRentalException;
    
    public abstract Collection<Zamestnanec> getZamestnance() throws BRentalException;
    
    
    

}