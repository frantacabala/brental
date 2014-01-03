/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.actions;

import java.awt.event.ActionEvent;
import org.lib.brental.contr.dialogs.CreateZamestnanecDialog;

/**
 *
 * @author john
 */
public class CreateZamestnanecAction extends AbstractBrentalAction{

    public CreateZamestnanecAction() {
        super("Přidej zaměstnance", "Zaměstnanec");
    }

    private static class CreateZamestnanecHolder{
        private static final CreateZamestnanecAction INSTANCE = new CreateZamestnanecAction();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        new CreateZamestnanecDialog();
    }
    
    
}
