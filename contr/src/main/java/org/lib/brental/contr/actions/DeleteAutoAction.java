/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.actions;

import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.lib.brental.bussines.BrentalFacadeService;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.model.Auto;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class DeleteAutoAction extends AbstractBrentalAction{

    public DeleteAutoAction() {
        super("Smazat auto", "Auto");
        //setEnabled(false);
    }

//    private static class DeleteAutoHolder{
//        
//    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Auto a = MainFrame.getInstance().getSelectedAuto();
        if(a == null){
            MainFrame.getInstance().showError("Neni vybrane zadne auto!");
        }else{
        int result;
        result = JOptionPane.showConfirmDialog(MainFrame.getInstance(),a + "?");
        if(result == JOptionPane.YES_OPTION){
            try {
                BrentalFacadeService.getDefault().smazAuto(a.getId());
                MainFrame.getInstance().refresh();
            } catch (BRentalException ex) {
                MainFrame.getInstance().showError(ex);
            }
        }
        }
    }
    
    @Override
    public void setEnabled(){
        
        setEnabled(BrentalFacadeService.getDefault().isAvailable() && MainFrame.getInstance().getSelectedAuto() != null);
    }
    
    
}
