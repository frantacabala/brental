/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.gui.impl;

import java.util.AbstractList;
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
import org.lib.brental.model.Zamestnanec;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class ZamestnanecModel extends AbstractTableModel implements Refreshable {

    List<Zamestnanec> zamestnanci = new ArrayList<>();

    
    public ZamestnanecModel(Collection<Zamestnanec> zam){
        zamestnanci=new ArrayList<>(zam);
    }
    public ZamestnanecModel() {
        this(new ArrayList<Zamestnanec>());
    }
    
    

    Collection<Zamestnanec> getZamestnanci(int[] rows) {
        ArrayList<Zamestnanec> zm = new ArrayList<>();
        for (int row : rows) {
            zm.add(zamestnanci.get(row));
        }
        return zm;
    }

    @Override
    public int getRowCount() {
        return zamestnanci.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zamestnanec r = zamestnanci.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getId();
            case 1:
                return r.getJmeno();
            case 2:
                return r.getPrijimeni();
            case 3:
                return r.getPracovni_pozice();
            case 4:
                return r.getAdresa().getUlice();
            case 5:
                return r.getAdresa().getMesto();
            case 6:
                return r.getAdresa().getPsc();
            case 7:
                return r.getLogin();

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
                return "Pracovní pozice";
            case 4:
                return "Ulice";
            case 5:
                return "Město";
            case 6:
                return "PSČ";
            case 7:
                return "Login name";
            default:
                assert false;
                return null;
        }
    }

    @Override
    public void refresh() throws BRentalException {
        Collection<Zamestnanec> rs = BrentalFacadeService.getDefault().getZamestnance();
        zamestnanci = new ArrayList<>(rs);
        Collections.sort(zamestnanci, new Comparator<Zamestnanec>() {
            @Override
            public int compare(Zamestnanec o1, Zamestnanec o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        fireTableDataChanged();
    }
}
