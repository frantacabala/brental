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
public interface BrentalFacadeInterface {

    // operations for car 
    public  void vytvorAuto(String spz,int kapacita,int cena_zakoupeni, Date datum_zakoupeni,Date datum_tk) throws BRentalException;
    
    public  void smazAuto(AutoId id) throws BRentalException;
    
    public  void aktualizujAuto(Auto auto) throws BRentalException;
    
    public  Collection<Auto> getAuta() throws BRentalException;
    
    
    //operations for facture
    public  void vytvorFakturu( ZamestnanecId id_zam, Date datum_vystaveni, Date datum_splatnosti) throws BRentalException;
    
    public  void smazFakturu(FakturaId id ) throws BRentalException;
    
    public  void aktualizujFakturu(Faktura fak) throws BRentalException;
    
    public  Collection<Faktura> getFaktury() throws BRentalException;
    
    
    //operations for boat
    
    public  void vytvorLod(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha,String evid,
            int delka, int max_ponor, String model, int nostnost, int sirka, String typ, String vyrobce) throws BRentalException;
    
    public  void smazLod(VybaveniId id) throws BRentalException;
    
    public  void aktualizujLod(Lod lod) throws BRentalException;
    
    public  Collection<Vybaveni> getLode() throws BRentalException;
    
    //operations for rezervation
    
    public  void vytvorRezervaci(ZakaznikId id_zak, ZamestnanecId id_zam, FakturaId id_fak, List<VybaveniId> vybaveni, Date ds, Date dk) throws BRentalException;

    public  void zrusRezervaci(RezervaceId id) throws BRentalException;

    public  void prijmiRezervaci(Rezervace rez) throws BRentalException;

    public  Collection<VybaveniId> getVybaveni(Rezervace rez) throws BRentalException;

    public  Collection<Rezervace> getRezervace() throws BRentalException;
    
    
    public  void vytvorVestu(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena,
                                        int vaha,String evid, String typ, String velikost, String vyrobce) throws BRentalException;
    
    public  void smazVestu(VybaveniId id) throws BRentalException;
    
    public  void aktualizujVestu(Vesta vest) throws BRentalException;
    
    public  Collection<Vybaveni> getVesty() throws BRentalException;
    
    
    
    public  void vytvorPadlo(String nazev, int nakup_cena, Date datum_nakup, String barva, 
                        int pujc_cena, int vaha,String evid, int delka, int sirka_listu,String typ) throws BRentalException;
    
    public  void smazPadlo(VybaveniId id) throws BRentalException;
    
    public  void aktualizujPadlo(Padlo padlo) throws BRentalException;
    
    public  Collection<Vybaveni> getPadla() throws BRentalException;
    
    
    
    public  void vytvorOther(String nazev, int nakup_cena, Date datum_nakup, String barva, 
                                       int pujc_cena, int vaha,String evid, String poznamka) throws BRentalException;
    
    public  void smazOther(VybaveniId id) throws BRentalException;
    
    public  void aktualizujOther(Other other) throws BRentalException;
    
    public  Collection<Vybaveni> getOther() throws BRentalException;
    
    
    
    public  void vytvorZakaznika(String jmeno,String prijimeni, Adresa adresa, int cislo_op) throws BRentalException;
    
    public  void smazZakanika(ZakaznikId id) throws BRentalException;
    
    public  void aktualizujZakaznika(Zakaznik zak) throws BRentalException;
    
    public  Collection<Zakaznik> getZakazniky() throws BRentalException;
    
    
    
    public  void vytvorZamestnance(String jmeno,String prijimeni,String funkce,Adresa adresa,String login,String heslo) throws BRentalException;
    
    public  void smazZamestnance(ZamestnanecId id) throws BRentalException;
    
    public  void aktualizujZamestnance(Zamestnanec zam) throws BRentalException;
    
    public  Collection<Zamestnanec> getZamestnance() throws BRentalException;
    
    public boolean isAvailable();
    
    
    

}