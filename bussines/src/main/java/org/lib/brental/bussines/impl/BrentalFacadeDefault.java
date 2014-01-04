/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.bussines.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.lib.brental.bussines.BrentalFacadeService;
import org.lib.brental.database.AbstractDataDAOFactoryService;
import org.lib.brental.model.Adresa;
import org.lib.brental.model.Auto;
import org.lib.brental.model.AutoId;
import org.lib.brental.model.Faktura;
import org.lib.brental.model.FakturaId;
import org.lib.brental.model.Lod;
import org.lib.brental.model.Rezervace;
import org.lib.brental.model.RezervaceId;
import org.lib.brental.model.Vybaveni;
import org.lib.brental.model.VybaveniId;
import org.lib.brental.model.Zakaznik;
import org.lib.brental.model.ZakaznikId;
import org.lib.brental.model.Zamestnanec;
import org.lib.brental.model.ZamestnanecId;
import org.lib.brental.utils.BRentalException;
import org.lib.brental.integration.AbstractDAOFactoryService;
import org.lib.brental.model.Other;
import org.lib.brental.model.Padlo;
import org.lib.brental.model.Vesta;

/**
 *
 * @author john
 */
public class BrentalFacadeDefault extends BrentalFacadeService {
    

    @Override
    public void vytvorAuto(String spz, int kapacita, int cena_zakoupeni, Date datum_zakoupeni, Date datum_tk) throws BRentalException {
         AbstractDataDAOFactoryService.getDefault().getAutoDAO().create(spz, kapacita, cena_zakoupeni, datum_zakoupeni, datum_tk);
    }

    @Override
    public void smazAuto(AutoId id) throws BRentalException {
        AbstractDataDAOFactoryService.getDefault().getAutoDAO().delete(id);
    }

    @Override
    public void aktualizujAuto(Auto auto) throws BRentalException {
        AbstractDataDAOFactoryService.getDefault().getAutoDAO().update(auto);
    }

    @Override
    public Collection<Auto> getAuta() throws BRentalException {
        // return AbstractDAOFactory.getDefault().getAutoDAO().getAll();
        return AbstractDataDAOFactoryService.getDefault().getAutoDAO().getAll();
        //return AbstractDAOFactoryService.getDefault().getAutoDAO().getAll();
    }

    @Override
    public void vytvorFakturu(ZamestnanecId id_zam, Date datum_vystaveni, Date datum_splatnosti) throws BRentalException {
         AbstractDataDAOFactoryService.getDefault().getFakturaDAO().create(id_zam, datum_vystaveni, datum_splatnosti);
    }

    @Override
    public void smazFakturu(FakturaId id) throws BRentalException {
        AbstractDataDAOFactoryService.getDefault().getFakturaDAO().delete(id);
    }

    @Override
    public void aktualizujFakturu(Faktura fak) throws BRentalException {
        AbstractDataDAOFactoryService.getDefault().getFakturaDAO().update(fak);
    }

    @Override
    public Collection<Faktura> getFaktury() throws BRentalException {
        return AbstractDAOFactoryService.getDefault().getFakturaDAO().getAll();
    }

    @Override
    public void vytvorLod(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha, String evid,
            int delka, int max_ponor, String model, int nostnost, int sirka, String typ, String vyrobce) throws BRentalException {
         AbstractDAOFactoryService.getDefault().getLodDAO().create(nazev, nakup_cena, datum_nakup, barva, pujc_cena, vaha, evid,
                delka, max_ponor, model, nostnost, sirka, typ, vyrobce);
    }

    @Override
    public void smazLod(VybaveniId id) throws BRentalException {
        AbstractDAOFactoryService.getDefault().getLodDAO().delete(id);
    }

    @Override
    public void aktualizujLod(Lod lod) throws BRentalException {
        AbstractDAOFactoryService.getDefault().getLodDAO().update(lod);
    }

    @Override
    public Collection<Vybaveni> getLode() throws BRentalException {
        return AbstractDAOFactoryService.getDefault().getLodDAO().getAll();
    }

    @Override
    public void vytvorZakaznika(String jmeno, String prijimeni, Adresa adresa, int cislo_op) throws BRentalException {
         AbstractDAOFactoryService.getDefault().getZakaznikDAO().create(jmeno, prijimeni, adresa, cislo_op);
    }

    @Override
    public void smazZakanika(ZakaznikId id) throws BRentalException {
        AbstractDAOFactoryService.getDefault().getZakaznikDAO().delete(id);
    }

    @Override
    public void aktualizujZakaznika(Zakaznik zak) throws BRentalException {
        AbstractDAOFactoryService.getDefault().getZakaznikDAO().update(zak);
    }

    @Override
    public Collection<Zakaznik> getZakazniky() throws BRentalException {
        return AbstractDAOFactoryService.getDefault().getZakaznikDAO().getAll();
    }

    @Override
    public void vytvorZamestnance(String jmeno, String prijimeni, String funkce, Adresa adresa, String login, String heslo) throws BRentalException {
         AbstractDAOFactoryService.getDefault().getZamestnanecDAO().create(jmeno, prijimeni, funkce, adresa, login, heslo);
    }

    @Override
    public void smazZamestnance(ZamestnanecId id) throws BRentalException {
        AbstractDAOFactoryService.getDefault().getZamestnanecDAO().delete(id);
    }

    @Override
    public void aktualizujZamestnance(Zamestnanec zam) throws BRentalException {
        AbstractDAOFactoryService.getDefault().getZamestnanecDAO().update(zam);
    }

    @Override
    public Collection<Zamestnanec> getZamestnance() throws BRentalException {
        return AbstractDAOFactoryService.getDefault().getZamestnanecDAO().getAll();
    }

    @Override
    public void vytvorVestu(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha, String evid, String typ, String velikost, String vyrobce) throws BRentalException {
         AbstractDAOFactoryService.getDefault().getVestaDAO().create(nazev, nakup_cena, datum_nakup, barva, pujc_cena, vaha, evid, typ, velikost, vyrobce);
    }

    @Override
    public void smazVestu(VybaveniId id) throws BRentalException {
        AbstractDAOFactoryService.getDefault().getVestaDAO().delete(id);
    }

    @Override
    public void aktualizujVestu(Vesta vest) throws BRentalException {
        AbstractDAOFactoryService.getDefault().getVestaDAO().update(vest);
    }

    @Override
    public Collection<Vybaveni> getVesty() throws BRentalException {
        return AbstractDAOFactoryService.getDefault().getVestaDAO().getAll();
    }

    /*  @Override
     public Vybaveni vytvorVybaveni(String nazev, int pocet, String velikost) throws BRentalException {
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }

     @Override
     public void smazVybaveni(VybaveniId id) throws BRentalException {
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }

     @Override
     public void aktualizujVybaveni(Vybaveni vyb) throws BRentalException {
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }

     @Override
     public Collection<Vybaveni> getVybaveni() throws BRentalException {
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }
     */
    @Override
    public void vytvorPadlo(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha, String evid, int delka, int sirka_listu, String typ) throws BRentalException {
         AbstractDAOFactoryService.getDefault().getPadloDAO().create(nazev, nakup_cena, datum_nakup, barva, pujc_cena, vaha, evid, delka, sirka_listu, typ);
    }

    @Override
    public void smazPadlo(VybaveniId id) throws BRentalException {
        AbstractDAOFactoryService.getDefault().getPadloDAO().delete(id);
    }

    @Override
    public void aktualizujPadlo(Padlo padlo) throws BRentalException {
        AbstractDAOFactoryService.getDefault().getPadloDAO().update(padlo);
    }

    @Override
    public Collection<Vybaveni> getPadla() throws BRentalException {
        return AbstractDAOFactoryService.getDefault().getPadloDAO().getAll();
    }

    @Override
    public void vytvorOther(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha, String evid, String poznamka) throws BRentalException {
         AbstractDAOFactoryService.getDefault().getOtherDAO().create(nazev, nakup_cena, datum_nakup, barva, pujc_cena, vaha, evid, poznamka);
    }

    @Override
    public void smazOther(VybaveniId id) throws BRentalException {
        AbstractDAOFactoryService.getDefault().getOtherDAO().delete(id);
    }

    @Override
    public void aktualizujOther(Other other) throws BRentalException {
        AbstractDAOFactoryService.getDefault().getOtherDAO().update(other);
    }

    @Override
    public Collection<Vybaveni> getOther() throws BRentalException {
        return AbstractDAOFactoryService.getDefault().getOtherDAO().getAll();
    }

    @Override
    public void vytvorRezervaci(ZakaznikId id_zak, ZamestnanecId id_zam, FakturaId id_fak, List<VybaveniId> vybaveni, Date ds, Date dk) throws BRentalException {
        AbstractDAOFactoryService.getDefault().getRezervaceDAO().vytvorRezervaci(id_zak, id_zam, id_fak, vybaveni, ds, dk);
    }

    @Override
    public void zrusRezervaci(RezervaceId id) throws BRentalException {
        AbstractDAOFactoryService.getDefault().getRezervaceDAO().zrusRezervaci(id);
    }

    @Override
    public void prijmiRezervaci(Rezervace rez) throws BRentalException {
        AbstractDAOFactoryService.getDefault().getRezervaceDAO().prijmiRezervaci(rez);
    }

    @Override
    public Collection<VybaveniId> getVybaveni(Rezervace rez) throws BRentalException {
        return AbstractDAOFactoryService.getDefault().getRezervaceDAO().getVybaveni(rez);
    }

    @Override
    public Collection<Rezervace> getRezervace() throws BRentalException {
        return AbstractDAOFactoryService.getDefault().getRezervaceDAO().getRezervace();
    }

    @Override
    public boolean isAvailable() {
        return true;
    }
}
