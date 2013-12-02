/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.gui;

import javax.swing.JTabbedPane;
import org.lib.brental.gui.impl.*;
import org.lib.brental.model.*;

/**
 *
 * @author john
 */
public class MainTabbedPane extends JTabbedPane {
   ZakaznikPanel zakaznikPanel;
   ZamestnanecPanel zamestnanecPanel;
   VybaveniPanel vybaveniPanel;
   RezervaceModel rezervacePanel;
   FakturaPanel fakturaPanel;
   AutoPanel autoPanel;
   
   public MainTabbedPane(){
       addTab("Auta", autoPanel = new AutoPanel());
   }
   
   Zamestnanec getSelectedZamestnanec(){
       return null;
       
   }
   
   Zakaznik getSelectedZakaznik(){
       return null;
       
   }
   
   Vybaveni getSelectedVybaveni(){
       return null;
       
   }
    
   Rezervace getSelectedRezervace(){
       return null;
       
   }
   
   Faktura getSelectedFaktura(){
       return null;
       
   }
   
   Auto getSelectedAuto(){
       return null;
       
   }
}
