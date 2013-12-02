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
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import org.lib.brental.gui.impl.Refreshable;
import org.lib.brental.model.Auto;
import org.lib.brental.model.Faktura;
import org.lib.brental.model.Rezervace;
import org.lib.brental.model.Vybaveni;
import org.lib.brental.model.Zakaznik;
import org.lib.brental.model.Zamestnanec;
import org.lib.brental.utils.BRentalException;
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
    Collection<SetEnable> tec = new ArrayList<>();
    private BundleContext context;
    private MainPanel mainPanel;
    private JMenuBar menuBar;

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
            Logger.getLogger(MainFrame.class.getName()).log(Level.INFO, null, ex);
        }
    }
    
    public MainFrame(){
        //super(Messages.BRental.getM());
        super("Brental");
        setJMenuBar(menuBar = new JMenuBar());
        
        add(mainPanel = new MainPanel());
        
        addWindowListener(new WindowAdapter() {
        
            @Override
            public void windowClosing(WindowEvent we){
                exit();
            }
        });
    
        setBounds(300, 300, 1024, 768);
        setVisible(true);
    }
    
    public void showError(BRentalException ex){
        showError(ex.toString());
    }
    
    public void showError(String msg){
        JOptionPane.showMessageDialog(this, msg);
    }
    
    public void refresh(){
        for(Refreshable  r : rf){
            try{
                r.refresh();
            }catch(BRentalException ex){
                showError(ex);
            }
        }
    }
    
    public static void addRefreshable(Refreshable r){
        rf.add(r);
    }
    
    public void setContext(BundleContext context){
        this.context = context;
    }
    
    
    public Zamestnanec getSelectedZamestnanec(){
       return null;
       
   }
   
   public Zakaznik getSelectedZakaznik(){
       return null;
       
   }
   
   public Vybaveni getSelectedVybaveni(){
       return null;
       
   }
    
   public Rezervace getSelectedRezervace(){
       return null;
       
   }
   
   public Faktura getSelectedFaktura(){
       return null;
       
   }
   
   public Auto getSelectedAuto(){
       return null;
       
   }

    public void actionsNotif() {
   for (SetEnable te : tec) {
            te.setEnable();
        } }
    
    
    
}
