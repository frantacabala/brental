/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.lib.brental.gui.impl.Refreshable;
import org.lib.brental.model.Auto;
import org.lib.brental.model.Faktura;
import org.lib.brental.model.Rezervace;
import org.lib.brental.model.Vybaveni;
import org.lib.brental.model.Zakaznik;
import org.lib.brental.model.Zamestnanec;
import org.lib.brental.utils.BRentalException;
import org.lib.brental.utils.BrentalAction;
import org.lib.brental.utils.Messages;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.launch.Framework;

/**
 *
 * @author john
 */
public class MainFrame extends JFrame {

    private static MainFrame instance;
    static Collection<Refreshable> rf = new ArrayList<>();
    Collection<BrentalAction> tec = new ArrayList<>();
    private BundleContext context;
    private MainPanel mainPanel;
    private JMenuBar menuBar;
    public Boolean isLoaded;

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }

    public void exit() {
        try {
            Bundle bnd = context.getBundle(0);
            Framework fw = (Framework) bnd;
            fw.stop();
            fw.waitForStop(0);
        } catch (BundleException | InterruptedException ex) {
            System.exit(-1);
            Logger.getLogger(MainFrame.class.getName()).log(Level.INFO, null, ex);
        }
        
    }

    public MainFrame() {
        //super(Messages.BRental.getM());
        super("Brental");
        isLoaded = false;
        setJMenuBar(menuBar = new JMenuBar());

        add(mainPanel = new MainPanel());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                //System.exit(-1);
                exit();
            }
        });

        setBounds(300, 300, 1024, 768);
        
        isLoaded = true;

    }
    
    

    public void showError(BRentalException ex) {
        showError(ex.toString());
    }

    public void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    public void refresh() {
        for (Refreshable r : rf) {
            try {
                r.refresh();
            } catch (BRentalException ex) {
                showError(ex);
            }
        }
        actionsNotify();
    }

    public static void addRefreshable(Refreshable r) {
        rf.add(r);
    }

    public void setContext(BundleContext context) {
        this.context = context;
    }

    public Zamestnanec getSelectedZamestnanec() {
        return mainPanel.getTabbedPane().getZamPanel().getSelectedZamestnanec();
    }

    public Zakaznik getSelectedZakaznik() {
        return mainPanel.getTabbedPane().getZakaznikPanel().getSelectedZakaznik();

    }
    
    public Vybaveni getSelectedVybaveni(){
     return mainPanel.getTabbedPane().getVybaveniPanel().getSelectedVybaveni();
    }
    
     public Rezervace getSelectedRezervace(){
     return mainPanel.getTabbedPane().getRezervacePanel().getSelectedRezervace();
       
     }
    /*
    
     public Faktura getSelectedFaktura(){
     return mainPanel.getTabbedPane().getSelectedFaktura();
       
     }
     */

    public Auto getSelectedAuto() {
        return mainPanel.getTabbedPane().getAutoPanel().getSelectedAuto();

    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void actionsNotify() {
        for (BrentalAction te : tec) {
            te.setEnabled();
        }
    }

    public void addBrentalMenu(BrentalAction te) {
        tec.add(te);
        JMenu mn;
        JMenuBar mnb = getJMenuBar();

        for (int i = 0; i < mnb.getMenuCount(); i++) {
            mn = mnb.getMenu(i);
            if (mn.getText().equals(te.getMenuName())) {
                mn.add((Action) te);
                return;
            }

        }
        mn = new JMenu(te.getMenuName());
        mn.add((Action) te);
        mnb.add(mn);
    }
}
