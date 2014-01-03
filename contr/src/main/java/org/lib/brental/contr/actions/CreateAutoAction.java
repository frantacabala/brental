/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.actions;

import java.awt.event.ActionEvent;
import org.lib.brental.bussines.BrentalFacadeService;
import org.lib.brental.contr.dialogs.CreateAutoDialog;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.gui.SetEnable;

/**
 *
 * @author john
 */
public class CreateAutoAction extends AbstractBrentalAction{

    public CreateAutoAction() {
        super("Přídej auto", "Auto");
    }

    @Override
    public void setEnabled() {
        setEnabled(BrentalFacadeService.getDefault().isAvailable());
    }

    private static class CreateAutoHolder{
        private static final CreateAutoAction INSTANCE = new CreateAutoAction();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        new CreateAutoDialog();
    }
    
    
    
    
    
    
    
}
