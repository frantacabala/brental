/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.gui.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import org.lib.brental.bussines.BrentalFacadeService;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.model.Zakaznik;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class ZakaznikModel extends AbstractTableModel implements Refreshable {

    List<Zakaznik> zakaznici = new ArrayList<>();

    public ZakaznikModel(Collection<Zakaznik> zak) {
        zakaznici = new ArrayList<>(zak);
    }

    public ZakaznikModel() {
        this(new ArrayList<Zakaznik>());
    }

    Collection<Zakaznik> getZakaznici(int[] rows) {
        ArrayList<Zakaznik> ar = new ArrayList<>();
        for (int row : rows) {
            ar.add(zakaznici.get(row));
        }
        return ar;

    }

    @Override
    public int getRowCount() {
        return zakaznici.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zakaznik r = zakaznici.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getId();
            case 1:
                return r.getJmeno();
            case 2:
                return r.getPrijimeni();
            case 3:
                return r.getAdresa().getUlice();
            case 4:
                return r.getAdresa().getMesto();
            case 5:
                return r.getAdresa().getPsc();
            case 6:
                return r.getCislo_op();

            default:
                assert false;
                return null;
        }
    }

    @Override
    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Id";
            case 1:
                return "Jméno";
            case 2:
                return "Přijímení";
            case 3:
                return "Ulice";
            case 4:
                return "Město";
            case 5:
                return "PSČ";
            case 6:
                return "Číslo OP";
            default:
                assert false;
                return null;
        }
    }

    @Override
    public void refresh() throws BRentalException {
        Collection<Zakaznik> rs = BrentalFacadeService.getDefault().getZakazniky();
        zakaznici = new ArrayList<>(rs);
        Collections.sort(zakaznici, new Comparator<Zakaznik>() {
            @Override
            public int compare(Zakaznik o1, Zakaznik o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        fireTableDataChanged();
    }
}
