/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.actions;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import org.lib.brental.bussines.BrentalFacadeService;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.model.Zakaznik;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class DeleteZakaznikAction extends AbstractBrentalAction{

    public DeleteZakaznikAction() {
        super("Smaž zákazníka", "Zákazník");
    }

    private static class DeleteZakaznikHolder{
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Zakaznik a = MainFrame.getInstance().getSelectedZakaznik();
        if (a == null) {
            MainFrame.getInstance().showError("Není vybrán žádný zákazník!");
        } else {
            int result;
            result = JOptionPane.showConfirmDialog(MainFrame.getInstance(), a + "?");
            if (result == JOptionPane.YES_OPTION) {
                try {
                    BrentalFacadeService.getDefault().smazZakanika(a.getId());
                    MainFrame.getInstance().refresh();
                } catch (BRentalException ex) {
                    MainFrame.getInstance().showError(ex);
                }
            }
        }
    }
    
    
     @Override
    public void setEnabled(){
        setEnabled(MainFrame.getInstance().getSelectedZakaznik() != null);
    }
    
}
