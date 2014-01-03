/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.actions;

import java.awt.event.ActionEvent;
import org.lib.brental.contr.dialogs.EditZakaznikDialog;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.model.Zakaznik;

/**
 *
 * @author john
 */
public class EditZakaznikAction extends AbstractBrentalAction{

    public EditZakaznikAction() {
        super("Edituj zákazníka", "Zákazník");
    }

    private static class EditZakaznikHolder{
         private static final CreateZakaznikAction INSTANCE = new CreateZakaznikAction();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Zakaznik a = MainFrame.getInstance().getSelectedZakaznik();
        if(a == null){
            MainFrame.getInstance().showError("Není vybrán žádný zákazník!");
        }else{
             new EditZakaznikDialog(a);

        }
    }
    
     @Override
    public void setEnabled(){
        setEnabled(MainFrame.getInstance().getSelectedZakaznik()!= null);
    }
    
}
