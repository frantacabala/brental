/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.actions;

import java.awt.event.ActionEvent;
import org.lib.brental.bussines.BrentalFacadeService;
import org.lib.brental.contr.dialogs.EditAutoDialog;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.model.Auto;

/**
 *
 * @author john
 */
public class EditAutoAction extends AbstractBrentalAction{

    public EditAutoAction() {
        super("Edituj", "Auto");
        //setEnabled(false);
    }

    private static class EditAutoHolder{
        private static final CreateAutoAction INSTANCE = new CreateAutoAction();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Auto a = MainFrame.getInstance().getSelectedAuto();
        if(a == null){
            MainFrame.getInstance().showError("Neni vybrane zadne auto!");
        }else{
             new EditAutoDialog(a);

        }
    }
    
    @Override
    public void setEnabled(){
        setEnabled(BrentalFacadeService.getDefault().isAvailable() && MainFrame.getInstance().getSelectedAuto() != null);
    }
    
}
