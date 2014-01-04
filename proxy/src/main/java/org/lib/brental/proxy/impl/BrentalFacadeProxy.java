/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.proxy.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.lib.brental.bussines.BrentalFacadeService;
import org.lib.brental.connection.ConnectionService;
import org.lib.brental.model.Adresa;
import org.lib.brental.model.Auto;
import org.lib.brental.model.AutoId;
import org.lib.brental.model.Faktura;
import org.lib.brental.model.FakturaId;
import org.lib.brental.model.Lod;
import org.lib.brental.model.Other;
import org.lib.brental.model.Padlo;
import org.lib.brental.model.Rezervace;
import org.lib.brental.model.RezervaceId;
import org.lib.brental.model.Vesta;
import org.lib.brental.model.Vybaveni;
import org.lib.brental.model.VybaveniId;
import org.lib.brental.model.Zakaznik;
import org.lib.brental.model.ZakaznikId;
import org.lib.brental.model.Zamestnanec;
import org.lib.brental.model.ZamestnanecId;
import org.lib.brental.protocol.entity.Auta;
import org.lib.brental.protocol.entity.CreateAuto;
import org.lib.brental.protocol.entity.GetAuta;
import org.lib.brental.protocol.entity.SmazAuto;
import org.lib.brental.utils.BRentalException;


/**
 *
 * @author john
 */
public class BrentalFacadeProxy extends BrentalFacadeService{

    public BrentalFacadeProxy() {
        
    }
    

    @Override
    public void vytvorAuto(String spz, int kapacita, int cena_zakoupeni, Date datum_zakoupeni, Date datum_tk) throws BRentalException {
        ConnectionService.getDefault().<Auta>send(new CreateAuto(spz, kapacita, cena_zakoupeni, datum_zakoupeni, datum_tk));
    }

    @Override
    public void smazAuto(AutoId id) throws BRentalException {
        ConnectionService.getDefault().<Auta>send(new SmazAuto(id));
    }

    @Override
    public void aktualizujAuto(Auto auto) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Auto> getAuta() throws BRentalException {
       return ConnectionService.getDefault().<Auta>send(new GetAuta()).getAuta();
    }

    @Override
    public void vytvorFakturu(ZamestnanecId id_zam, Date datum_vystaveni, Date datum_splatnosti) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void smazFakturu(FakturaId id) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aktualizujFakturu(Faktura fak) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Faktura> getFaktury() throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vytvorLod(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha, String evid, int delka, int max_ponor, String model, int nostnost, int sirka, String typ, String vyrobce) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void smazLod(VybaveniId id) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aktualizujLod(Lod lod) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Vybaveni> getLode() throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vytvorRezervaci(ZakaznikId id_zak, ZamestnanecId id_zam, FakturaId id_fak, List<VybaveniId> vybaveni, Date ds, Date dk) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void zrusRezervaci(RezervaceId id) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void prijmiRezervaci(Rezervace rez) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<VybaveniId> getVybaveni(Rezervace rez) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Rezervace> getRezervace() throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vytvorVestu(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha, String evid, String typ, String velikost, String vyrobce) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void smazVestu(VybaveniId id) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aktualizujVestu(Vesta vest) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Vybaveni> getVesty() throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vytvorPadlo(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha, String evid, int delka, int sirka_listu, String typ) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void smazPadlo(VybaveniId id) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aktualizujPadlo(Padlo padlo) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Vybaveni> getPadla() throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vytvorOther(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha, String evid, String poznamka) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void smazOther(VybaveniId id) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aktualizujOther(Other other) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Vybaveni> getOther() throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vytvorZakaznika(String jmeno, String prijimeni, Adresa adresa, int cislo_op) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void smazZakanika(ZakaznikId id) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aktualizujZakaznika(Zakaznik zak) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Zakaznik> getZakazniky() throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vytvorZamestnance(String jmeno, String prijimeni, String funkce, Adresa adresa, String login, String heslo) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void smazZamestnance(ZamestnanecId id) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aktualizujZamestnance(Zamestnanec zam) throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Zamestnanec> getZamestnance() throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAvailable() {
        return ConnectionService.getDefault().isConnected();
    }
    
}
