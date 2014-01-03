/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.dialogs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.table.AbstractTableModel;
import org.lib.brental.bussines.BrentalFacadeService;
import org.lib.brental.utils.BRentalException;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.gui.impl.VybaveniList;
import org.lib.brental.model.Faktura;
import org.lib.brental.model.Vybaveni;
import org.lib.brental.model.VybaveniId;
import org.lib.brental.model.Zakaznik;
import org.lib.brental.model.Zamestnanec;

/**
 *
 * @author danecek
 */
public final class CreateRezervaceDialog extends AbstractBrentalDialog {

    ValidatedTF title;
    VybaveniList listVybaveni;
    ValidatedTF datum_s;
    ValidatedTF datum_k;
    JPanel edit;
    JPanel control; // contains listVybaveni + buttons
    JPanel buttons;
    JButton add;
    JComboBox chooser;
    JComboBox<Zakaznik> zak;
    JComboBox<Zamestnanec> zam;
    JComboBox<Faktura> fak;
    ArrayList<VybaveniId> items = new ArrayList<>();
    //JPanel content;
    
    public CreateRezervaceDialog getDefault(){
        return this;
    }
    

    public CreateRezervaceDialog() {
        super("Rezervace");
        datum_s=new ValidatedTF(this, 10);
        datum_k=new ValidatedTF(this, 10);
        
        zak = new JComboBox<Zakaznik>(getZakaznikP());
        zak.setRenderer(new ZakRender());
        
        zam = new JComboBox<Zamestnanec>(getZamL());
        zam.setRenderer(new ZamRender());
        
        fak = new JComboBox<Faktura>(getFaktura());
        fak.setRenderer(new FakRender());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weightx = 0;
        
        
        edit = new JPanel(new BorderLayout());
        control=new JPanel(new BorderLayout());
        buttons = new JPanel(new BorderLayout());
        listVybaveni = new VybaveniList();
        JPanel merge = new JPanel(new BorderLayout());
        
        String[] it = {"LODE", "PADLA", "VESTY", "DALSI"};
        chooser = new JComboBox(it);
        chooser.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                listVybaveni.showActive(chooser.getSelectedItem().toString());
                getDefault().getContentPane().revalidate();
                getDefault().getContentPane().repaint();
                
            }
        });
        add=new JButton("Přidej");
        add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addItems(listVybaveni.getSelectedVybavenis(chooser.getSelectedItem().toString()));
            }
        });
        
        JPanel addr = new JPanel(new GridBagLayout());
        addr.setBorder(new CompoundBorder(new TitledBorder("Osobni udaje"), new EmptyBorder(4, 4, 4, 4)));

        addr.add(new JLabel("Zakaznik: "), gbc);
        gbc.gridx++;
        addr.add(zak, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        addr.add(new JLabel("Zamestnanec: "), gbc);
        gbc.gridx++;
        addr.add(zam, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        addr.add(new JLabel("Faktura: "), gbc);
        gbc.gridx++;
        addr.add(fak, gbc);
        // addr panel -right

        // info panel -legt
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weightx = 0;
        JPanel info = new JPanel(new GridBagLayout());
        info.setBorder(new CompoundBorder(new TitledBorder("Datum"), new EmptyBorder(4, 4, 4, 4)));

        info.add(new JLabel("Datum začátku: "), gbc);
        gbc.gridx++;
        info.add(datum_s, gbc);
        datum_s.setText("yyyy-MM-dd");
        gbc.gridx = 0;
        gbc.gridy++;
        info.add(new JLabel("Datum konce: "), gbc);
        gbc.gridx++;
        info.add(datum_k, gbc);
        datum_k.setText("yyyy-MM-dd");
        
        edit.add(addr, BorderLayout.LINE_START);
        edit.add(info,BorderLayout.LINE_END);
        
        buttons.add(add,BorderLayout.LINE_START);
        buttons.add(chooser,BorderLayout.LINE_END);

        control.add(buttons, BorderLayout.PAGE_START);
        control.add(listVybaveni,BorderLayout.CENTER);
     
     
     
        merge.add(edit, BorderLayout.PAGE_START);
        merge.add(control,BorderLayout.CENTER);
        
        content.add(merge,BorderLayout.CENTER);
        //  validateDialog();
        pack();
        setVisible(true);

    }
    
    public void addItems(Collection<Vybaveni> list){
        
        for(Vybaveni listn:list){
            items.add(listn.getId());
        }
    }

    @Override
    public boolean validateDialog() {
        if (datum_s.getText().isEmpty()) {
            error("Prazdny titul");// todo
            return false;
        }
        clearError();
        return true;


    }
    
    class ZakRender extends BasicComboBoxRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value != null) {
                Zakaznik i = (Zakaznik) value;
                setText(i.getPrijimeni().toUpperCase());
            }
            if (index == -1) {
                Zakaznik i = (Zakaznik) value;
                setText("" + i.getPrijimeni());
            }
            return this;
        }
    }

    public DefaultComboBoxModel<Zakaznik> getZakaznikP() {
        DefaultComboBoxModel<Zakaznik> model = new DefaultComboBoxModel<Zakaznik>();
        Collection<Zakaznik> a = null;
        try {
            a = BrentalFacadeService.getDefault().getZakazniky();
        } catch (BRentalException ex) {
            Logger.getLogger(CreateRezervaceDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Zakaznik aut : a) {
            model.addElement(aut);
        }
        return model;

    }
    
    class ZamRender extends BasicComboBoxRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value != null) {
                Zamestnanec i = (Zamestnanec) value;
                setText(i.getLogin().toUpperCase());
            }
            if (index == -1) {
                Zamestnanec i = (Zamestnanec) value;
                setText("" + i.getLogin());
            }
            return this;
        }
    }

    public DefaultComboBoxModel<Zamestnanec> getZamL() {
        DefaultComboBoxModel<Zamestnanec> model = new DefaultComboBoxModel<Zamestnanec>();
        Collection<Zamestnanec> a = null;
        try {
            a = BrentalFacadeService.getDefault().getZamestnance();
        } catch (BRentalException ex) {
            Logger.getLogger(CreateRezervaceDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Zamestnanec aut : a) {
            model.addElement(aut);
        }
        return model;

    }
    
    class FakRender extends BasicComboBoxRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value != null) {
                Faktura i = (Faktura) value;
                setText(Integer.toString(i.getId().getId()));
            }
            if (index == -1) {
                Faktura i = (Faktura) value;
                if(i != null){
                    setText(""+Integer.toString(i.getId().getId()));
                }
                setText("none");
            }
            return this;
        }
    }

    public DefaultComboBoxModel<Faktura> getFaktura() {
        DefaultComboBoxModel<Faktura> model = new DefaultComboBoxModel<Faktura>();
        Collection<Faktura> a = null;
        try {
            a = BrentalFacadeService.getDefault().getFaktury();
        } catch (BRentalException ex) {
            Logger.getLogger(CreateRezervaceDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Faktura aut : a) {
            model.addElement(aut);
        }
        return model;

    }
    
    

    @Override
    public void okAction() {
        try {
            Date date = new SimpleDateFormat("yyy-MM-dd", Locale.ENGLISH).parse(datum_s.getText());
            Date date_tk=new SimpleDateFormat("yyy-MM-dd", Locale.ENGLISH).parse(datum_k.getText());
            
            Zakaznik z =(Zakaznik) zak.getSelectedItem();
            Zamestnanec za = (Zamestnanec) zam.getSelectedItem();
            Faktura f = (Faktura) fak.getSelectedItem();
            if(f==null){
               f=BrentalFacadeService.getDefault().vytvorFakturu(za.getId(), date, date_tk);
               
            }
            
            BrentalFacadeService.getDefault().vytvorRezervaci(z.getId(), za.getId(), f.getId(), items, date, date_tk);
            MainFrame.getInstance().refresh();
            
            /* try {
             //   LibraryFacade.getDefault().createBook(title.getText());
             MainFrame.getInstance().refresh();
             } catch (BRentalException le) {
             MainFrame.getInstance().showError(le);
             }*/
        } catch (BRentalException ex) {
            Logger.getLogger(CreateRezervaceDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CreateRezervaceDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
