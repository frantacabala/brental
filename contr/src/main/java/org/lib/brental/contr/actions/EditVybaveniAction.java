/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.actions;

import java.awt.event.ActionEvent;
import org.lib.brental.contr.dialogs.EditVybaveniDialog;
import org.lib.brental.contr.dialogs.EditZakaznikDialog;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.model.Vybaveni;

/**
 *
 * @author john
 */
public class EditVybaveniAction extends AbstractBrentalAction{

    public EditVybaveniAction() {
        super("Edituj vybavení", "Vybavení");
    }

    private static class EditVybaveniHolder{
        public final static EditVybaveniAction INSTANCE = new EditVybaveniAction();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
         Vybaveni a = MainFrame.getInstance().getSelectedVybaveni();
        if(a == null){
            MainFrame.getInstance().showError("Není vybráno žádné vybavení!");
        }else{
             new EditVybaveniDialog(a);

        }
    }
    
    @Override
    public void setEnabled(){
        setEnabled(MainFrame.getInstance().getSelectedZakaznik()!= null);
    }
    
}
