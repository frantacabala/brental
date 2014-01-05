/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.gui.impl;

import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import org.lib.brental.bussines.BrentalFacadeService;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.model.Lod;
import org.lib.brental.model.Vybaveni;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class LodModel extends AbstractTableModel implements Refreshable
{
     List<Vybaveni> list = new ArrayList<>();
 
     public LodModel(Collection<Vybaveni> c){
         list=new ArrayList<>(c);
     }
     
    public LodModel(){
        this(new ArrayList<Vybaveni>());
    }
    
    Collection<Vybaveni> getVybaveni(int [] rows){
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
        return 15;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Lod r = (Lod)list.get(rowIndex);
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
                return r.getDelka();
            case 8:
                return r.getMax_ponor();
            case 9:
                return r.getModel();
            case 10:
                return r.getNostnost();
            case 11:
                return r.getSirka();
            case 12:
                return r.getTyp();
            case 13:
                return r.getVyrobce();
            case 14:
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
                return "Délka";
            case 8:
                return "Ponor";
            case 9:
                return "Model";
            case 10:
                return "Nostnost";
            case 11:
                return "Šířka";
            case 12:
                return "Typ";
            case 13:
                return "Výrobce";
            case 14:
                return "Evidenční číslo";
            default:
                assert false;
                return null;
        }
    }
    
    @Override
    public void refresh() throws BRentalException {
        Collection<Vybaveni> rs = BrentalFacadeService.getDefault().getLode();
        list = new ArrayList<>(rs);
//        JOptionPane.showMessageDialog(null,list.get(0).getNazev());
//        Collections.sort(list, new Comparator<Lod>() {
//            @Override
//            public int compare(Lod o1, Lod o2) {
//                
//                return Collator.getInstance(new Locale("cz")).compare(o1.getNazev(),o2.getNazev());
//            }
//        });
        fireTableDataChanged();
    }
    
}
