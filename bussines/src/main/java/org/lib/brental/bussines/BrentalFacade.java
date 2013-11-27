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
    public abstract Auto vytvorAuto(String spz,int kapacita) throws BRentalException;
    
    public abstract void smazAuto(AutoId id) throws BRentalException;
    
    public abstract void aktualizujAuto(Auto auto) throws BRentalException;
    
    public abstract Collection<Auto> getAuta() throws BRentalException;
    
    
    //operations for facture
    public abstract Faktura vytvorFakturu(RezervaceId id) throws BRentalException;
    
    public abstract void smazFakturu(FakturaId id ) throws BRentalException;
    
    public abstract void aktualizujFakturu(Faktura fak) throws BRentalException;
    
    public abstract Collection<Faktura> getFaktury() throws BRentalException;
    
    
    //operations for boat
    
    public abstract Lod vytvorLod(String typ, int kapacita) throws BRentalException;
    
    public abstract void smazLod(LodId id) throws BRentalException;
    
    public abstract void aktualizujLod(Lod lod) throws BRentalException;
    
    public abstract Collection<Lod> getLode() throws BRentalException;
    
    //operations for rezervation
    
    public abstract void vytvorRezervaci(ZakaznikId id, List<VybaveniId> vybaveni, List<LodId> lode, Date s, Date k) throws BRentalException;
    
    public abstract void zrusRezervaci(ZakaznikId id) throws BRentalException;
    
    public abstract Collection<Rezervace> getRezervace() throws BRentalException;
    
    
    public abstract Vybaveni vytvorVybaveni(String nazev, int pocet, String velikost) throws BRentalException;
    
    public abstract void smazVybaveni(VybaveniId id) throws BRentalException;
    
    public abstract void aktualizujVybaveni(Vybaveni vyb) throws BRentalException;
    
    public abstract Collection<Vybaveni> getVybaveni() throws BRentalException;
    
    
    public abstract Zakaznik vytvorZakaznika(String jmeno, Adresa adresa) throws BRentalException;
    
    public abstract void smazZakanika(ZakaznikId id) throws BRentalException;
    
    public abstract void aktualizujZakaznika(Zakaznik zak) throws BRentalException;
    
    public abstract Collection<Zakaznik> getZakazniky() throws BRentalException;
    
    
    
    public abstract Zamestnanec vytvorZamestnance(String jmeno, Adresa adresa, String funkce) throws BRentalException;
    
    public abstract void smazZamestnance(ZamestnanecId id) throws BRentalException;
    
    public abstract void aktualizujZamestnance(Zamestnanec zam) throws BRentalException;
    
    public abstract Collection<Zamestnanec> getZamestnance() throws BRentalException;
    
    
    

}