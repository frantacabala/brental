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
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import org.lib.brental.bussines.BrentalFacadeService;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.gui.SetEnable;
import org.lib.brental.model.Zakaznik;
import org.lib.brental.utils.BRentalException;
import org.lib.brental.utils.BrentalAction;

/**
 *
 * @author john
 */
public class ZakaznikPanel extends JPanel {
    
    JTable tbl;
    ZakaznikModel zakm;
    JPanel filterPanel;
    JButton btn_create;
    JButton btn_edit;
    JButton btn_delete;
    //JComboBox<Auto> car_filter;
    JComboBox sort_filter;
    
   

    public ZakaznikPanel(Color color) {
        setOpaque(true);
        setBackground(color);
        init_ui();
    }
    
     public void init_ui(){
        
        filterPanel = new JPanel(new BorderLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        String[] sorts={"ID","SPZ","CENA","DATUM"};

        filterPanel.setBorder(new CompoundBorder(new TitledBorder("Navigace"), new EmptyBorder(4, 4, 4, 4)));
        /*btn_create = new JButton(new AbstractAction("Create") {

            @Override
            public void actionPerformed(ActionEvent e) {
                CreateAutoDialog cad = new CreateAutoDialog();
                //cad.okAction();
            }
        });*/
        //btn_create.setAction(new CreateAutoAction());
        btn_create= new JButton();
        btn_edit = new JButton();
        btn_delete = new JButton();
        sort_filter=new JComboBox(sorts);
//        car_filter = new JComboBox<Auto>(getAutaSPZ());
//        car_filter.setRenderer(new AutoRender());
//        car_filter.setBorder(new EmptyBorder(10, 10, 10, 10));
//        sort_filter.setBorder(new EmptyBorder(10, 10, 10, 10));

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
//        filterPane.add(new JLabel("SPZ:"), gbc);
//        gbc.gridx++;
//
//        filterPane.add(car_filter, gbc);
//        gbc.gridx ++;
        filterPane.add(new JLabel("Sort:"), gbc);
        gbc.gridx++;
        /*sort_filter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              MainFrame.getInstance().refresh();
            }
        });*/
        filterPane.add(sort_filter, gbc);
        filterPane.setBorder(new TitledBorder(new EmptyBorder(1,1, 1, 1),"Filtry"));

        filterPanel.add(buttonPane, BorderLayout.LINE_START);
        filterPanel.add(filterPane, BorderLayout.LINE_END);
        
        setLayout(new BorderLayout());
        add(filterPanel, BorderLayout.PAGE_START);
        JScrollPane scp;
        add(scp = new JScrollPane(tbl = new JTable(zakm = new ZakaznikModel())), BorderLayout.CENTER);
        MainFrame.addRefreshable(zakm);
        scp.setBorder(new CompoundBorder(new TitledBorder("Položky"), new EmptyBorder(4, 4, 4, 4)));
        ListSelectionModel sm = tbl.getSelectionModel();
        sm.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        sm.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                MainFrame.getInstance().actionsNotify();
            }

        });
    }
    class ZakRender extends BasicComboBoxRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value != null) {
                Zakaznik zak = (Zakaznik) value;
                setText(zak.getJmeno().toUpperCase());
            }
            if (index == -1) {
                Zakaznik zam = (Zakaznik) value;
                setText("" + zam.getJmeno());
            }
            return this;
        }
    }

    public DefaultComboBoxModel<Zakaznik> getAutaSPZ() {
        DefaultComboBoxModel<Zakaznik> model = new DefaultComboBoxModel<Zakaznik>();
        Collection<Zakaznik> z = null;
        try {
            z = BrentalFacadeService.getDefault().getZakazniky();
        } catch (BRentalException ex) {
            Logger.getLogger(AutoPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Zakaznik zak : z) {
            model.addElement(zak);
        }
        return model;


    }
    
    
     public void setCreateBtn(BrentalAction te){
       btn_create.setAction((Action) te);
      
    }
    
    public void setDeleteBtn(BrentalAction te){
       btn_delete.setAction((Action) te);
      
    }
    
    public void setEditBtn(BrentalAction te){
       btn_edit.setAction((Action) te);
      
    }
    
    Collection<Zakaznik> getSelectedZakaznici(){
        int[] rows = tbl.getSelectedRows();
        return zakm.getZakaznici(rows);
        
    }
    
    public Zakaznik getSelectedZakaznik(){
      int row = tbl.getSelectedRow();
        
        if(row == -1)
            return null;
        return new ArrayList<Zakaznik>(zakm.getZakaznici(new int[]{row})).get(0);
    }
             
}
