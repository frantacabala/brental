/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.actions;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import org.lib.brental.bussines.BrentalFacadeService;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.model.Zamestnanec;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class DeleteZamestnanecAction extends AbstractBrentalAction {

    public DeleteZamestnanecAction() {
        super("Smazat zaměstnance", "Zaměstnanec");
        setEnabled(false);
    }

    private static class DeleteZamestnanecHolder {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Zamestnanec a = MainFrame.getInstance().getSelectedZamestnanec();
        if (a == null) {
            MainFrame.getInstance().showError("Není vybrán žádný zaměstnanec!");
        } else {
            int result;
            result = JOptionPane.showConfirmDialog(MainFrame.getInstance(), a + "?");
            if (result == JOptionPane.YES_OPTION) {
                try {
                    BrentalFacadeService.getDefault().smazZamestnance(a.getId());
                    MainFrame.getInstance().refresh();
                } catch (BRentalException ex) {
                    MainFrame.getInstance().showError(ex);
                }
            }
        }
    }

    @Override
    public void setEnabled(){
        setEnabled(MainFrame.getInstance().getSelectedZamestnanec() != null);
    }


}
