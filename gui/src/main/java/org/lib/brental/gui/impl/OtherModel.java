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
import javax.swing.table.AbstractTableModel;
import org.lib.brental.bussines.BrentalFacadeService;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.model.Other;
import org.lib.brental.model.Vybaveni;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class OtherModel extends AbstractTableModel implements Refreshable {

    List<Vybaveni> list = new ArrayList<>();

     public OtherModel(Collection<Vybaveni> c){
         list=new ArrayList<>(c);
     }
     
    public OtherModel(){
        this(new ArrayList<Vybaveni>());
    }

    Collection<Vybaveni> getVybaveni(int[] rows) {
        ArrayList<Vybaveni> ar = new ArrayList<>();
        for (int row : rows) {
            ar.add(list.get(row));
        }
        return ar;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Other r = (Other) list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getId().getId();
            case 1:
                return r.getNazev();
            case 2:
                return r.getNakup_cena();
            case 3:
                return new SimpleDateFormat("yyyy-MM-dd").format(r.getDatum_nakup());
            case 4:
                return r.getBarva();
            case 5:
                return r.getPujc_cena();
            case 6:
                return r.getVaha();
            case 7:
                return r.getPoznamka();
            case 8:
                return r.getEvid();
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
                return "Název";
            case 2:
                return "Nákupní cena";         
            case 3:
                return "Datum nákupu";
            case 4:
                return "Barva";
            case 5:
                return "Cena zapůjčení/den";
            case 6:
                return "Váha";
            case 7:
                return "Poznámka";
            case 8:
                return "Evidenční číslo";
            
            default:
                assert false;
                return null;
        }
    }

    @Override
    public void refresh() throws BRentalException {
       Collection<Vybaveni> rs = BrentalFacadeService.getDefault().getOther();
        list = new ArrayList<>(rs);
        
        Collections.sort(list, new Comparator<Vybaveni>() {
            @Override
            public int compare(Vybaveni o1, Vybaveni o2) {
                
                return o1.getId().compareTo(o2.getId());
            }
        });
        fireTableDataChanged();
    }
}
