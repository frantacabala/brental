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
import org.lib.brental.integration.AbstractDAOFactoryService;
import org.lib.brental.model.Rezervace;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class RezervaceModel extends AbstractTableModel implements Refreshable {

    List<Rezervace> rezervace = new ArrayList<>();
    
   public RezervaceModel(Collection<Rezervace> c){
         rezervace=new ArrayList<>(c);
     }
     
    public RezervaceModel(){
        this(new ArrayList<Rezervace>());
    }
    
    Collection<Rezervace> getRezervaces(int [] rows){
        ArrayList<Rezervace> r = new ArrayList<>();
        for(int row:rows){
            r.add(rezervace.get(row));
        }
        return r;
        
    } 
    
    @Override
    public int getRowCount() {
       return rezervace.size();
    }

    @Override
    public int getColumnCount() {
       return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Rezervace r = rezervace.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return r.getId();
                case 1:
                    return AbstractDAOFactoryService.getDefault().getZamestnanecDAO().find(r.getId_zam()).getLogin();
                case 2:
                    return AbstractDAOFactoryService.getDefault().getZakaznikDAO().find(r.getId_zak()).getPrijimeni();
                case 3:
                    return r.getStav();
                case 4:
                    return new SimpleDateFormat("yyyy-MM-dd").format(r.getDatum_start());
                case 5:
                    return new SimpleDateFormat("yyyy-MM-dd").format(r.getDatum_konec());
                
                default:
                    assert false;
                    return null;
            }
        } catch (BRentalException ex) {
            Logger.getLogger(RezervaceModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     @Override
    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Id";
            case 1:
                return "Zaměstnanec";
            case 2:
                return "Zákazník";
            case 3:
                return "Stav rezervace";
            case 4:
                return "Začátek rezervace";
            case 5:
                return "Konec rezervace";
            case 6:
                return "PSČ";
           
            default:
                assert false;
                return null;
        }
    }

    @Override
    public void refresh() throws BRentalException {
       Collection<Rezervace> rs = BrentalFacadeService.getDefault().getRezervace();
        rezervace = new ArrayList<>(rs);
        Collections.sort(rezervace, new Comparator<Rezervace>() {
            @Override
            public int compare(Rezervace o1, Rezervace o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        fireTableDataChanged();
    }
    
    
}
