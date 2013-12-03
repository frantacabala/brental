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
import org.lib.brental.bussines.BrentalFacade;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.model.Auto;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class AutoModel extends AbstractTableModel implements Refreshable {

    List<Auto> auta = new ArrayList<>();
    
    public AutoModel(){
         try {
            refresh();
            MainFrame.addRefreshable(this);
        } catch (BRentalException ex) {
            Logger.getLogger(AutoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    Collection<Auto> getAuta(int [] rows){
        return null;
        
    } 
    
    @Override
    public int getRowCount() {
        return auta.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
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
                return r.getDatum_zakoupeni();
            default:
                assert false;
                return null;
        }}
    
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
            default:
                assert false;
                return null;
        }
     }
     
    @Override
    public void refresh() throws BRentalException {
    Collection<Auto> rs = BrentalFacade.getDefault().getAuta();
        auta = new ArrayList<>(rs);
        Collections.sort(auta, new Comparator<Auto>() {
            @Override
            public int compare(Auto t, Auto t1) {
                return t.getZnacka().compareTo(t1.getZnacka()); // Lepe Collator 
            }

        });
        fireTableDataChanged();}
    
    
}
