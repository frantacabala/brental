/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.gui.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import org.lib.brental.bussines.BrentalFacadeService;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.model.Auto;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class AutoModel extends AbstractTableModel implements Refreshable {

    List<Auto> auta = new ArrayList<>();

    public AutoModel(Collection<Auto> auta) {
        this.auta = new ArrayList<>(auta);
    }

    public AutoModel() {
        this(new ArrayList<Auto>());
    }

    Collection<Auto> getAuta(int[] rows) {
        ArrayList<Auto> ar = new ArrayList<>();
        for (int row : rows) {
            ar.add(auta.get(row));
        }
        return ar;

    }

    @Override
    public int getRowCount() {
        return auta.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Auto r = auta.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getId();
            case 1:
                return r.getZnacka();
            case 2:
                return r.getKapacita();
            case 3:
                return r.getCena_zakoupeni();
            case 4:
                return new SimpleDateFormat("yyyy-MM-dd").format(r.getDatum_zakoupeni());
            case 5:
                return new SimpleDateFormat("yyyy-MM-dd").format(r.getDatum_tk());
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
                return "SPZ";
            case 2:
                return "Kapacita";
            case 3:
                return "Cena nakupu";
            case 4:
                return "Datum Nakupu";
            case 5:
                return "Platnost TK";

            default:
                assert false;
                return null;
        }
    }

    public void refreshSort(String sort) throws BRentalException {
        Collection<Auto> rs = BrentalFacadeService.getDefault().getAuta();
        auta = new ArrayList<>(rs);


        switch (sort) {
            case "ID":
                JOptionPane.showMessageDialog(null, sort);
                Collections.sort(auta, new Comparator<Auto>() {
                    @Override
                    public int compare(Auto t, Auto t1) {
                        return Integer.toString(t.getId().getId()).compareTo(Integer.toString(t1.getId().getId())); // Lepe Collator 

                    }
                });
                break;
            case "SPZ":
                JOptionPane.showMessageDialog(null, sort);
                Collections.sort(auta, new Comparator<Auto>() {
                    @Override
                    public int compare(Auto t, Auto t1) {
                        return t.getZnacka().compareTo(t1.getZnacka()); // Lepe Collator 
                    }
                });
                break;
            case "CENA":
                Collections.sort(auta, new Comparator<Auto>() {
                    @Override
                    public int compare(Auto t, Auto t1) {
                        return Integer.toString(t.getCena_zakoupeni()).compareTo(Integer.toString(t1.getCena_zakoupeni())); // Lepe Collator 
                    }
                });
                break;
            case "DATUM":
                Collections.sort(auta, new Comparator<Auto>() {
                    @Override
                    public int compare(Auto t, Auto t1) {
                        return t.getDatum_zakoupeni().compareTo(t1.getDatum_zakoupeni()); // Lepe Collator 
                    }
                });
                break;
            default:
                Collections.sort(auta, new Comparator<Auto>() {
                    @Override
                    public int compare(Auto t, Auto t1) {
                        return Integer.toString(t.getId().getId()).compareTo(Integer.toString(t1.getId().getId())); // Lepe Collator 

                    }
                });
                break;

        }
        fireTableDataChanged();
    }

    @Override
    public void refresh() throws BRentalException {
        Collection<Auto> rs = BrentalFacadeService.getDefault().getAuta();
        //Collection 

        auta = new ArrayList<>(rs);
        String sort = "SPZ";


        switch (sort) {
            case "ID":
                Collections.sort(auta, new Comparator<Auto>() {
                    @Override
                    public int compare(Auto t, Auto t1) {
                        return Integer.toString(t.getId().getId()).compareTo(Integer.toString(t1.getId().getId())); // Lepe Collator 

                    }
                });
                break;
            case "SPZ":
                Collections.sort(auta, new Comparator<Auto>() {
                    @Override
                    public int compare(Auto t, Auto t1) {
                        return t.getZnacka().compareTo(t1.getZnacka()); // Lepe Collator 
                    }
                });
                break;
            case "CENA":
                Collections.sort(auta, new Comparator<Auto>() {
                    @Override
                    public int compare(Auto t, Auto t1) {
                        return Integer.toString(t.getCena_zakoupeni()).compareTo(Integer.toString(t1.getCena_zakoupeni())); // Lepe Collator 
                    }
                });
                break;
            case "DATUM":
                Collections.sort(auta, new Comparator<Auto>() {
                    @Override
                    public int compare(Auto t, Auto t1) {
                        return t.getDatum_zakoupeni().compareTo(t1.getDatum_zakoupeni()); // Lepe Collator 
                    }
                });
                break;
            default:
                Collections.sort(auta, new Comparator<Auto>() {
                    @Override
                    public int compare(Auto t, Auto t1) {
                        return Integer.toString(t.getId().getId()).compareTo(Integer.toString(t1.getId().getId())); // Lepe Collator 

                    }
                });
                break;

        }
        fireTableDataChanged();
    }
}
