/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.actions;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import org.lib.brental.contr.dialogs.CreateVybaveniDialog;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.model.Lod;
import org.lib.brental.model.Other;
import org.lib.brental.model.Padlo;
import org.lib.brental.model.Vesta;
import org.lib.brental.model.Vybaveni;

/**
 *
 * @author john
 */
public class CreateVybaveniAction extends AbstractBrentalAction{

    public CreateVybaveniAction() {
        super("Přidej vybavení", "Vybavení");
    }

    private static class CreateVybaveniHolder{
        private static final CreateVybaveniAction INSTANCE = new CreateVybaveniAction();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Vybaveni vyb = MainFrame.getInstance().getSelectedVybaveni();
        
        
        
        
        new CreateVybaveniDialog(vyb);
    }
    
    
}
