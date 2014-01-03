/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.actions;

import java.awt.event.ActionEvent;
import org.lib.brental.contr.dialogs.CreateRezervaceDialog;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.model.Rezervace;

/**
 *
 * @author john
 */
public class CreateRezervaceAction extends AbstractBrentalAction{

    public CreateRezervaceAction() {
        super("Vytvoř rezervaci", "Rezervace");
    }

    private static class CreateRezervaceHolder{
        private static final CreateRezervaceAction INSTANCE = new CreateRezervaceAction();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Rezervace rez = MainFrame.getInstance().getSelectedRezervace();
        
        new CreateRezervaceDialog();
    }
    
    
}
