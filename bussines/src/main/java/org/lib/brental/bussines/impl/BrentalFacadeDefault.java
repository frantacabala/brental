/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.bussines.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.lib.brental.bussines.BrentalFacade;
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
import org.lib.brental.integration.AbstractDAOFactory;
import org.lib.brental.model.Other;
import org.lib.brental.model.Padlo;
import org.lib.brental.model.Vesta;

/**
 *
 * @author john
 */
public class BrentalFacadeDefault extends BrentalFacade {

    @Override
    public Auto vytvorAuto(String spz, int kapacita, int cena_zakoupeni, Date datum_zakoupeni) throws BRentalException {
        return AbstractDAOFactory.getDefault().getAutoDAO().create(spz, kapacita, cena_zakoupeni, datum_zakoupeni);
    }

    @Override
    public void smazAuto(AutoId id) throws BRentalException {
        AbstractDAOFactory.getDefault().getAutoDAO().delete(id);
    }

    @Override
    public void aktualizujAuto(Auto auto) throws BRentalException {
        AbstractDAOFactory.getDefault().getAutoDAO().update(auto);
    }

    @Override
    public Collection<Auto> getAuta() throws BRentalException {
        return AbstractDAOFactory.getDefault().getAutoDAO().getAll();
    }

    @Override
    public Faktura vytvorFakturu(RezervaceId id, ZamestnanecId id_zam, Date datum_vystaveni, Date datum_splatnosti) throws BRentalException {
        return AbstractDAOFactory.getDefault().getFakturaDAO().create(id, id_zam, datum_vystaveni, datum_splatnosti);
    }

    @Override
    public void smazFakturu(FakturaId id) throws BRentalException {
        AbstractDAOFactory.getDefault().getFakturaDAO().delete(id);
    }

    @Override
    public void aktualizujFakturu(Faktura fak) throws BRentalException {
        AbstractDAOFactory.getDefault().getFakturaDAO().update(fak);
    }

    @Override
    public Collection<Faktura> getFaktury() throws BRentalException {
        return AbstractDAOFactory.getDefault().getFakturaDAO().getAll();
    }

    @Override
    public Lod vytvorLod(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha,
            int delka, int max_ponor, String model, int nostnost, int sirka, String typ, String vyrobce) throws BRentalException {
        return AbstractDAOFactory.getDefault().getLodDAO().create(nazev, nakup_cena, datum_nakup, barva, pujc_cena, vaha,
                delka, max_ponor, model, nostnost, sirka, typ, vyrobce);
    }

    @Override
    public void smazLod(VybaveniId id) throws BRentalException {
        AbstractDAOFactory.getDefault().getLodDAO().delete(id);
    }

    @Override
    public void aktualizujLod(Lod lod) throws BRentalException {
        AbstractDAOFactory.getDefault().getLodDAO().update(lod);
    }

    @Override
    public Collection<Lod> getLode() throws BRentalException {
        return AbstractDAOFactory.getDefault().getLodDAO().getAll();
    }

    @Override
    public Zakaznik vytvorZakaznika(String jmeno, String prijimeni, Adresa adresa, int cislo_op) throws BRentalException {
        return AbstractDAOFactory.getDefault().getZakaznikDAO().create(jmeno, prijimeni, adresa, cislo_op);
    }

    @Override
    public void smazZakanika(ZakaznikId id) throws BRentalException {
        AbstractDAOFactory.getDefault().getZakaznikDAO().delete(id);
    }

    @Override
    public void aktualizujZakaznika(Zakaznik zak) throws BRentalException {
        AbstractDAOFactory.getDefault().getZakaznikDAO().update(zak);
    }

    @Override
    public Collection<Zakaznik> getZakazniky() throws BRentalException {
        return AbstractDAOFactory.getDefault().getZakaznikDAO().getAll();
    }

    @Override
    public Zamestnanec vytvorZamestnance(String jmeno, String prijimeni, String login, String heslo, Adresa adresa, String funkce) throws BRentalException {
        return AbstractDAOFactory.getDefault().getZamestnanecDAO().create(jmeno, prijimeni, login, heslo, adresa, funkce);
    }

    @Override
    public void smazZamestnance(ZamestnanecId id) throws BRentalException {
        AbstractDAOFactory.getDefault().getZamestnanecDAO().delete(id);
    }

    @Override
    public void aktualizujZamestnance(Zamestnanec zam) throws BRentalException {
        AbstractDAOFactory.getDefault().getZamestnanecDAO().update(zam);
    }

    @Override
    public Collection<Zamestnanec> getZamestnance() throws BRentalException {
        return AbstractDAOFactory.getDefault().getZamestnanecDAO().getAll();
    }

    @Override
    public Vesta vytvorVestu(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha, String typ, String velikost, String vyrobce) throws BRentalException {
        return AbstractDAOFactory.getDefault().getVestaDAO().create(nazev, nakup_cena, datum_nakup, barva, pujc_cena, vaha, typ, velikost, vyrobce);
    }

    @Override
    public void smazVestu(VybaveniId id) throws BRentalException {
        AbstractDAOFactory.getDefault().getVestaDAO().delete(id);
    }

    @Override
    public void aktualizujVestu(Vesta vest) throws BRentalException {
        AbstractDAOFactory.getDefault().getVestaDAO().update(vest);
    }

    @Override
    public Collection<Vesta> getVesty() throws BRentalException {
        return AbstractDAOFactory.getDefault().getVestaDAO().getAll();
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
    public Padlo vytvorPadlo(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha, int delka, int sirka_listu, String typ) throws BRentalException {
        return AbstractDAOFactory.getDefault().getPadloDAO().create(nazev, nakup_cena, datum_nakup, barva, pujc_cena, vaha, delka, sirka_listu, typ);
    }

    @Override
    public void smazPadlo(VybaveniId id) throws BRentalException {
        AbstractDAOFactory.getDefault().getPadloDAO().delete(id);
    }

    @Override
    public void aktualizujPadlo(Padlo padlo) throws BRentalException {
        AbstractDAOFactory.getDefault().getPadloDAO().update(padlo);
    }

    @Override
    public Collection<Padlo> getPadla() throws BRentalException {
        return AbstractDAOFactory.getDefault().getPadloDAO().getAll();
    }

    @Override
    public Other vytvorOther(String nazev, int nakup_cena, Date datum_nakup, String barva, int pujc_cena, int vaha, String poznamka) throws BRentalException {
        return AbstractDAOFactory.getDefault().getOtherDAO().create(nazev, nakup_cena, datum_nakup, barva, pujc_cena, vaha, poznamka);
    }

    @Override
    public void smazOther(VybaveniId id) throws BRentalException {
        AbstractDAOFactory.getDefault().getOtherDAO().delete(id);
    }

    @Override
    public void aktualizujOther(Other other) throws BRentalException {
        AbstractDAOFactory.getDefault().getOtherDAO().update(other);
    }

    @Override
    public Collection<Other> getOther() throws BRentalException {
        return AbstractDAOFactory.getDefault().getOtherDAO().getAll();
    }

    @Override
    public void vytvorRezervaci(ZakaznikId id_zak, ZamestnanecId id_zam, FakturaId id_fak, List<VybaveniId> vybaveni, Date ds, Date dk) throws BRentalException {
        AbstractDAOFactory.getDefault().getRezervaceDAO().vytvorRezervaci(id_zak, id_zam, id_fak, vybaveni, ds, dk);
    }

    @Override
    public void zrusRezervaci(RezervaceId id) throws BRentalException {
        AbstractDAOFactory.getDefault().getRezervaceDAO().zrusRezervaci(id);
    }

    @Override
    public void prijmiRezervaci(Rezervace rez) throws BRentalException {
        AbstractDAOFactory.getDefault().getRezervaceDAO().prijmiRezervaci(rez);
    }

    @Override
    public Collection<VybaveniId> getVybaveni(Rezervace rez) throws BRentalException {
        return AbstractDAOFactory.getDefault().getRezervaceDAO().getVybaveni(rez);
    }

    @Override
    public Collection<Rezervace> getRezervace() throws BRentalException {
        return AbstractDAOFactory.getDefault().getRezervaceDAO().getRezervace();
    }
}
