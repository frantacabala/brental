/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.actions;

import java.awt.event.ActionEvent;
import org.lib.brental.contr.dialogs.CreateAutoDialog;

/**
 *
 * @author john
 */
public class CreateAutoAction extends AbstractBrentalAction{

    public CreateAutoAction() {
        super("Create", "File");
    }

    private static class CreateAutoHolder{
        private static final CreateAutoAction INSTANCE = new CreateAutoAction();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        new CreateAutoDialog();
    }
    
    
}
