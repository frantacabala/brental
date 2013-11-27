/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.integration.impl;

import org.lib.brental.integration.AbstractDAOFactory;
import org.lib.brental.integration.AutoDAO;
import org.lib.brental.integration.FakturaDAO;
import org.lib.brental.integration.LodDAO;
import org.lib.brental.integration.RezervaceDAO;
import org.lib.brental.integration.VybaveniDAO;
import org.lib.brental.integration.ZakaznikDAO;
import org.lib.brental.integration.ZamestnanecDAO;

/**
 *
 * @author john
 */
public class DAOFactoryDefault extends AbstractDAOFactory {

    private AutoDAO autoDAO;
    private FakturaDAO fakturaDAO;
    private LodDAO lodDAO;
    private RezervaceDAO rezervaceDAO;
    private VybaveniDAO vybaveniDAO;
    private ZakaznikDAO zakaznikDAO;
    private ZamestnanecDAO zamestnanecDAO;

    @Override
    public AutoDAO getAutoDAO() {
        if (autoDAO == null) {
            autoDAO = new AutoDAOimpl();
        }
        return autoDAO;
    }

    @Override
    public FakturaDAO getFakturaDAO() {
        if (fakturaDAO == null) {
            fakturaDAO = new FakuturaDAOimpl();
        }
        return fakturaDAO;
    }

    @Override
    public LodDAO getLodDAO() {
        if (lodDAO == null) {
            lodDAO = new LodDAOimpl();
        }
        return lodDAO;
    }

    @Override
    public RezervaceDAO getRezervaceDAO() {
        if (rezervaceDAO == null) {
            rezervaceDAO = new RezervaceDAOimpl();
        }
        return rezervaceDAO;
    }

    @Override
    public VybaveniDAO getVybaveniDAO() {
        if (vybaveniDAO == null) {
            vybaveniDAO = new VybaveniDAOimpl();
        }
        return vybaveniDAO;
    }

    @Override
    public ZakaznikDAO getZakaznikDAO() {
        if (zakaznikDAO == null) {
            zakaznikDAO = new ZakaznikDAOimpl();
        }
        return zakaznikDAO;
    }

    @Override
    public ZamestnanecDAO getZamestnanecDAO() {
        if (zamestnanecDAO == null) {
            zamestnanecDAO = new ZamestnanecDAOimpl();
        }
        return zamestnanecDAO;
    }
}
