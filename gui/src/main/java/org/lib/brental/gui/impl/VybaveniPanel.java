 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.gui.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.gui.SetEnable;
import org.lib.brental.model.Vesta;
import org.lib.brental.model.Vybaveni;
import org.lib.brental.utils.BrentalAction;

/**
 *
 * @author john
 */
public class VybaveniPanel extends JPanel {

   
    JPanel filterPanel;
    JButton btn_create;
    JButton btn_edit;
    JButton btn_delete;
    JComboBox car_filter;
    JComboBox sort_filter;
    JComboBox choose_filter;
    
   
    VybaveniList listPanel;
    
    public VybaveniPanel(Color color) {
        init_ui();

    }

    public void init_ui() {
        
        String[] items = {"LODE", "PADLA", "VESTY", "DALSI"};
        choose_filter = new JComboBox(items);
        
        listPanel=new VybaveniList();
        JButton btn_show = new JButton("Ukaž");

        filterPanel = new JPanel(new BorderLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        String[] sorts = {"ID", "SPZ", "CENA", "DATUM"};
        

        filterPanel.setBorder(new CompoundBorder(new TitledBorder("Navigace"), new EmptyBorder(4, 4, 4, 4)));



        sort_filter = new JComboBox(sorts);
        choose_filter = new JComboBox(items);
        btn_create = new JButton();
        btn_edit = new JButton();
        btn_delete = new JButton();

        JPanel buttonPane = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0;

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

        filterPane.add(new JLabel("Vybavení:"), gbc);
        gbc.gridx++;
        filterPane.add(choose_filter, gbc);
        gbc.gridx++;
        filterPane.add(new JLabel("Seřaď:"), gbc);
        gbc.gridx++;
        filterPane.add(sort_filter, gbc);
        
        choose_filter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 listPanel.showActive(choose_filter.getSelectedItem().toString());
                 MainFrame.getInstance().getContentPane().revalidate();
                MainFrame.getInstance().getContentPane().repaint();
            }
        });
      
        filterPane.setBorder(new CompoundBorder(new TitledBorder("Filtry"), new EmptyBorder(1, 1, 1, 1)));

        filterPanel.add(filterPane, BorderLayout.LINE_END);
        filterPanel.add(buttonPane, BorderLayout.LINE_START);
        setLayout(new BorderLayout());
        add(filterPanel, BorderLayout.PAGE_START);

        
        add(listPanel, BorderLayout.CENTER);
    }

    

    public void setCreateBtn(BrentalAction te) {
        btn_create.setAction((Action) te);

    }

    public void setDeleteBtn(BrentalAction te) {
        btn_delete.setAction((Action) te);

    }

    public void setEditBtn(BrentalAction te) {
        btn_edit.setAction((Action) te);

    }

    Collection<Vybaveni> getSelectedVybavenis() {
        return listPanel.getSelectedVybavenis(choose_filter.getSelectedItem().toString());

    }

    public Vybaveni getSelectedVybaveni() {
        return listPanel.getSelectedVybaveni(choose_filter.getSelectedItem().toString());
    }
    
    public JComboBox getChooser(){
        return choose_filter;
    }
}
