/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.gui.impl;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.gui.SetEnable;
import org.lib.brental.model.Vybaveni;

/**
 *
 * @author john
 */
public class VybaveniList extends JPanel {

    JTable tblP;
    JTable tblV;
    JTable tblL;
    JTable tblO;
    PadloModel pm;
    VestaModel vm;
    LodModel lm;
    OtherModel om;
    JPanel filterPanel;
    JButton btn_create;
    JButton btn_edit;
    JButton btn_delete;
    JComboBox car_filter;
    JComboBox sort_filter;
    JComboBox choose_filter;
    JScrollPane scpL;
    JScrollPane scpV;
    JScrollPane scpO;
    JScrollPane scpP;
    JPanel tablePanel;

    public VybaveniList() {
        init_ui();

    }

    public void init_ui() {

        setLayout(new BorderLayout());
        tablePanel = new JPanel(new BorderLayout());
        JButton btn_pridej = new JButton("Přidej");
        btn_create = new JButton();
        btn_edit = new JButton();
        btn_delete = new JButton();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0;

////        filterPanel = new JPanel(new BorderLayout());
////        
////        String[] sorts = {"ID", "SPZ", "CENA", "DATUM"};
////        String[] items = {"LODE", "PADLA", "VESTY", "DALSI"};
////
////        filterPanel.setBorder(new CompoundBorder(new TitledBorder("Navigace"), new EmptyBorder(4, 4, 4, 4)));
////
////
////
////        sort_filter = new JComboBox(sorts);
////        choose_filter = new JComboBox(items);
////        
////
////        JPanel buttonPane = new JPanel(new GridBagLayout());
////        
////
////        buttonPane.add(btn_create, gbc);
////        gbc.gridx++;
////        buttonPane.add(btn_edit, gbc);
////        gbc.gridx++;
////        buttonPane.add(btn_delete, gbc);
////
////
////        gbc.gridx = 0;
////        gbc.gridy = 0;
////        gbc.anchor = GridBagConstraints.EAST;
////        gbc.fill = GridBagConstraints.NONE;
////        gbc.weightx = 0;
////        JPanel filterPane = new JPanel(new GridBagLayout());
////
////        filterPane.add(new JLabel("Vybavení:"), gbc);
////        gbc.gridx++;
////        filterPane.add(choose_filter, gbc);
////        gbc.gridx++;
////        filterPane.add(new JLabel("Seřaď:"), gbc);
////        gbc.gridx++;
////        filterPane.add(sort_filter, gbc);
////        
////        choose_filter.addActionListener(new ActionListener() {
////
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                 showActive(choose_filter.getSelectedItem().toString(), tablePanel);
////            }
////        });
////      
////        filterPane.setBorder(new CompoundBorder(new TitledBorder("Filtry"), new EmptyBorder(1, 1, 1, 1)));
////
////        filterPanel.add(filterPane, BorderLayout.LINE_END);
////        filterPanel.add(buttonPane, BorderLayout.LINE_START);
//        setLayout(new BorderLayout());
//        add(filterPanel, BorderLayout.PAGE_START);

        tblL = new JTable(lm = new LodModel());
        MainFrame.addRefreshable(lm);
        ListSelectionModel smL = tblL.getSelectionModel();
        smL.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        smL.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                MainFrame.getInstance().actionsNotify();
            }
        });
        tblO = new JTable(om = new OtherModel());
        MainFrame.addRefreshable(om);
        ListSelectionModel smO = tblO.getSelectionModel();
        smO.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        smO.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                MainFrame.getInstance().actionsNotify();
            }
        });

        tblP = new JTable(pm = new PadloModel());
        MainFrame.addRefreshable(pm);
        ListSelectionModel smP = tblP.getSelectionModel();
        smP.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        smP.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                MainFrame.getInstance().actionsNotify();
            }
        });

        tblV = new JTable(vm = new VestaModel());
        MainFrame.addRefreshable(vm);
        ListSelectionModel smV = tblV.getSelectionModel();
        smV.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        smV.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                MainFrame.getInstance().actionsNotify();
            }
        });

        scpV = new JScrollPane(tblV);
        scpV.setBorder(new CompoundBorder(new TitledBorder("Položky - vesty"), new EmptyBorder(4, 4, 4, 4)));
        scpL = new JScrollPane(tblL);
        scpL.setBorder(new CompoundBorder(new TitledBorder("Položky - lodě"), new EmptyBorder(4, 4, 4, 4)));
        scpO = new JScrollPane(tblO);
        scpO.setBorder(new CompoundBorder(new TitledBorder("Položky - ostatní"), new EmptyBorder(4, 4, 4, 4)));
        scpP = new JScrollPane(tblP);
        scpP.setBorder(new CompoundBorder(new TitledBorder("Položky - pádla"), new EmptyBorder(4, 4, 4, 4)));


        tablePanel.add(scpL, BorderLayout.CENTER);
        add(tablePanel, BorderLayout.CENTER);
    }

    public void showActive(String item) {


        switch (item) {
            case "LODE":
                tablePanel.removeAll();
                tablePanel.add(scpL, BorderLayout.CENTER);

                return;
            case "VESTY":
                tablePanel.removeAll();
                tablePanel.add(scpV, BorderLayout.CENTER);

                break;
            case "PADLA":
                tablePanel.removeAll();
                tablePanel.add(scpP, BorderLayout.CENTER);
                break;
            case "DALSI":
                tablePanel.removeAll();
                tablePanel.add(scpO, BorderLayout.CENTER);

                break;
            default:
                tablePanel.removeAll();
                tablePanel.add(scpL, BorderLayout.CENTER);

                break;


        }
    }

    public Collection<Vybaveni> getSelectedVybavenis(String item) {
        int[] rows;
        switch (item) {
            case "LODE":
                rows = tblL.getSelectedRows();
                return lm.getVybaveni(rows);
            case "DALSI":
                rows = tblO.getSelectedRows();
                return om.getVybaveni(rows);
            case "PADLA":
                rows = tblP.getSelectedRows();
                return pm.getVybaveni(rows);
            case "VESTY":
                rows = tblV.getSelectedRows();
                return vm.getVybaveni(rows);
        }
        return null;

    }

    public Vybaveni getSelectedVybaveni(String item) {
        int row;


        switch (item) {
            case "LODE":

                row = tblL.getSelectedRow();
                if (row == -1) {
                    return null;
                }
                return new ArrayList<Vybaveni>(lm.getVybaveni(new int[]{row})).get(0);
            case "DALSI":
                row = tblO.getSelectedRow();
                if (row == -1) {
                    return null;
                }
                return new ArrayList<Vybaveni>(om.getVybaveni(new int[]{row})).get(0);
            case "PADLA":
                row = tblP.getSelectedRow();
                if (row == -1) {
                    return null;
                }
                return new ArrayList<Vybaveni>(pm.getVybaveni(new int[]{row})).get(0);
            case "VESTY":

                row = tblV.getSelectedRow();
                if (row == -1) {
                    return null;
                }
                return new ArrayList<Vybaveni>(vm.getVybaveni(new int[]{row})).get(0);
        }
        return null;

    }
}
