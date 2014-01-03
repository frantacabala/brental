 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.gui.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.gui.SetEnable;
import org.lib.brental.model.Rezervace;
import org.lib.brental.utils.BrentalAction;

/**
 *
 * @author john
 */
public class RezervacePanel extends JPanel {
    
    JTable tbl;
    RezervaceModel rm;
    JPanel filterPanel;
    JButton btn_create;
    JButton btn_edit;
    JButton btn_delete;
    //JComboBox<Auto> car_filter;
    JComboBox sort_filter;
    JButton btn_search;
    JTextField tf_search;
    
    
    public RezervacePanel(Color color){
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
        tf_search = new JTextField(10);
        
        tf_search.setBorder(new EmptyBorder(2, 5,2, 2));
        btn_search=new JButton("Hledej");
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
        
        filterPane.add(new JLabel("Sort:"), gbc);
        gbc.gridx++;
        /*sort_filter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              MainFrame.getInstance().refresh();
            }
        });*/
        filterPane.add(sort_filter, gbc);
        gbc.gridx++;
        filterPane.add(tf_search, gbc);
        gbc.gridx++;
        filterPane.add(btn_search, gbc);
        
        filterPane.setBorder(new TitledBorder(new EmptyBorder(1,1, 1, 1),"Filtry"));

        filterPanel.add(buttonPane, BorderLayout.LINE_START);
        filterPanel.add(filterPane, BorderLayout.LINE_END);
        
        setLayout(new BorderLayout());
        add(filterPanel, BorderLayout.PAGE_START);
        JScrollPane scp;
        add(scp = new JScrollPane(tbl = new JTable(rm = new RezervaceModel())), BorderLayout.CENTER);
        MainFrame.addRefreshable(rm);
        scp.setBorder(new CompoundBorder(new TitledBorder("Rezervace"), new EmptyBorder(4, 4, 4, 4)));
        ListSelectionModel sm = tbl.getSelectionModel();
        sm.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        sm.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                MainFrame.getInstance().actionsNotify();
            }
        });
    }
    
    Collection<Rezervace> getSelectedRezervaces(){
        return null;
        
    }
    
    public Rezervace getSelectedRezervace(){
         int row = tbl.getSelectedRow();
        
        if(row == -1)
            return null;
        return new ArrayList<Rezervace>(rm.getRezervaces(new int[]{row})).get(0);
        
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
             
}
