 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.gui.impl;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.model.Auto;
import org.lib.brental.bussines.BrentalFacade;
import org.lib.brental.contr.actions.CreateAutoAction;
import org.lib.brental.contr.dialogs.CreateAutoDialog;


import org.lib.brental.gui.SetEnable;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class AutoPanel extends JPanel {

    JTable tbl;
    AutoModel am;
    JPanel filterPanel;
    JButton btn_create;
    JButton btn_edit;
    JButton btn_delete;
    JComboBox<Auto> car_filter;

    public AutoPanel() {

        init_ui();
        

    }

    public void init_ui(){
        
        filterPanel = new JPanel(new BorderLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        filterPanel.setBorder(new CompoundBorder(new TitledBorder("Navigace"), new EmptyBorder(4, 4, 4, 4)));
        btn_create = new JButton(new AbstractAction("Create") {

            @Override
            public void actionPerformed(ActionEvent e) {
                CreateAutoDialog cad = new CreateAutoDialog();
                //cad.okAction();
            }
        });
        //btn_create.setAction(new CreateAutoAction());
        
        btn_edit = new JButton("Edit");
        btn_delete = new JButton("Delete");
        car_filter = new JComboBox<Auto>(getAutaSPZ());
        car_filter.setRenderer(new AutoRender());
        car_filter.setBorder(new EmptyBorder(10, 10, 10, 10));


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0;
        JPanel buttonPane = new JPanel(new GridBagLayout());
        buttonPane.add(btn_create, gbc);
        gbc.gridx++;
        buttonPane.add(btn_edit, gbc);
        gbc.gridx++;
        buttonPane.add(btn_delete, gbc);


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        JPanel filterPane = new JPanel(new GridBagLayout());
        filterPane.setBorder(null);
        filterPane.add(new JLabel("SPZ:"), gbc);
        gbc.gridx++;

        filterPane.add(car_filter, gbc);
        filterPane.setBorder(new TitledBorder(new EmptyBorder(1,1, 1, 1),"Filtry"));

        filterPanel.add(buttonPane, BorderLayout.LINE_START);
        filterPanel.add(filterPane, BorderLayout.LINE_END);
        
        setLayout(new BorderLayout());
        add(filterPanel, BorderLayout.PAGE_START);
        JScrollPane scp;
        add(scp = new JScrollPane(tbl = new JTable(am = new AutoModel())), BorderLayout.CENTER);
        scp.setBorder(new CompoundBorder(new TitledBorder("Položky"), new EmptyBorder(4, 4, 4, 4)));
        ListSelectionModel sm = tbl.getSelectionModel();
        sm.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        sm.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                MainFrame.getInstance().actionsNotif();
            }
        });
    }
    class AutoRender extends BasicComboBoxRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value != null) {
                Auto auto = (Auto) value;
                setText(auto.getZnacka().toUpperCase());
            }
            if (index == -1) {
                Auto auto = (Auto) value;
                setText("" + auto.getZnacka());
            }
            return this;
        }
    }

    public DefaultComboBoxModel<Auto> getAutaSPZ() {
        DefaultComboBoxModel<Auto> model = new DefaultComboBoxModel<Auto>();
        Collection<Auto> a = null;
        try {
            a = BrentalFacade.getDefault().getAuta();
        } catch (BRentalException ex) {
            Logger.getLogger(AutoPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Auto aut : a) {
            model.addElement(aut);
        }
        return model;


    }

    Collection<Auto> getSelectedAuta() {
        return null;

    }

    public Auto getSelectedAuto() {
        return null;

    }
    
    public void setCreateBtn(SetEnable te){
       btn_create.setAction((Action) te);
    }
}
