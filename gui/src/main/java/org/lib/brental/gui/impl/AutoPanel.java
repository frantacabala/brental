 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.gui.impl;

import java.awt.BorderLayout;
import java.util.Collection;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.model.Auto;

/**
 *
 * @author john
 */
public class AutoPanel extends JPanel {
    
    JTable tbl;
    AutoModel am;
    
    public AutoPanel(){
        setLayout(new BorderLayout());
        add(new JScrollPane(tbl = new JTable(am = new AutoModel())));
        ListSelectionModel sm = tbl.getSelectionModel();
        sm.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        sm.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                MainFrame.getInstance().actionsNotif();
            }
        });
        //add(new JTextArea());
        
    }
    
    Collection<Auto> getSelectedAuta(){
        return null;
        
    }
    
    public Auto getSelectedAuto(){
        return null;
        
    }
             
}
