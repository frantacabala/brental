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
import org.lib.brental.model.LodId;
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

/**
 *
 * @author john
 */
public class BrentalFacadeDefault extends BrentalFacade {

    @Override
    public Auto vytvorAuto(String spz, int kapacita) throws BRentalException {
        return AbstractDAOFactory.getDefault().getAutoDAO().create(spz, kapacita);
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
    public Faktura vytvorFakturu(RezervaceId id) throws BRentalException {
        return AbstractDAOFactory.getDefault().getFakturaDAO().create(id);
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
    public Lod vytvorLod(String typ, int kapacita) throws BRentalException {
        return AbstractDAOFactory.getDefault().getLodDAO().create(typ, kapacita);
    }

    @Override
    public void smazLod(LodId id) throws BRentalException {
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
    public void vytvorRezervaci(ZakaznikId id, List<VybaveniId> vybaveni, List<LodId> lode, Date s, Date k) throws BRentalException {
        AbstractDAOFactory.getDefault().getRezervaceDAO().vytvorRezervaci(id, vybaveni, lode, s, k);
    }

    @Override
    public void zrusRezervaci(ZakaznikId id) throws BRentalException {
        AbstractDAOFactory.getDefault().getRezervaceDAO().zrusRezervaci(id);
    }

    @Override
    public Collection<Rezervace> getRezervace() throws BRentalException {
        return AbstractDAOFactory.getDefault().getRezervaceDAO().getRezervace();
    }

    @Override
    public Vybaveni vytvorVybaveni(String nazev, int pocet, String velikost) throws BRentalException {
        return AbstractDAOFactory.getDefault().getVybaveniDAO().create(nazev, pocet, velikost);
    }

    @Override
    public void smazVybaveni(VybaveniId id) throws BRentalException {
        AbstractDAOFactory.getDefault().getVybaveniDAO().delete(id);
    }

    @Override
    public void aktualizujVybaveni(Vybaveni vyb) throws BRentalException {
        AbstractDAOFactory.getDefault().getVybaveniDAO().update(vyb);
    }

    @Override
    public Collection<Vybaveni> getVybaveni() throws BRentalException {
        return AbstractDAOFactory.getDefault().getVybaveniDAO().getAll();
    }

    @Override
    public Zakaznik vytvorZakaznika(String jmeno, Adresa adresa) throws BRentalException {
        return AbstractDAOFactory.getDefault().getZakaznikDAO().create(jmeno, adresa);
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
    public Zamestnanec vytvorZamestnance(String jmeno, Adresa adresa, String funkce) throws BRentalException {
        return AbstractDAOFactory.getDefault().getZamestnanecDAO().create(jmeno, adresa, funkce);
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
}
