/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.actions;

import java.awt.event.ActionEvent;
import org.lib.brental.contr.dialogs.CreateZakaznikDialog;

/**
 *
 * @author john
 */
public class CreateZakaznikAction extends AbstractBrentalAction{

    public CreateZakaznikAction() {
        super("Přidej zákazníka", "Zákazník");
    }

    private static class CreateZakaznikHolder{
         private static final CreateZakaznikAction INSTANCE = new CreateZakaznikAction();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        new CreateZakaznikDialog();
    }
    
    
}
