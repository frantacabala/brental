/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.gui.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.lib.brental.model.Zakaznik;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class ZakaznikModel extends AbstractTableModel implements Refreshable {

    List<Zakaznik> zakaznici = new ArrayList<>();
    
    public ZakaznikModel(){
        
    }
    
    Collection<Zakaznik> getZakaznici(int [] rows){
        return null;
        
    } 
    
    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void refresh() throws BRentalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
