/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.actions;

import java.awt.event.ActionEvent;
import org.lib.brental.bussines.BrentalFacadeService;
import org.lib.brental.gui.MainFrame;

/**
 *
 * @author john
 */
public class RefreshAction extends AbstractBrentalAction {
    
    public RefreshAction() {
        super("Refresh", "Pripojeni");
    }

    @Override
    public void setEnabled() {
        setEnabled(BrentalFacadeService.getDefault().isAvailable());
    }

    private static class CreateAutoHolder{
        private static final RefreshAction INSTANCE = new RefreshAction();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().refresh();
    }
    
}
