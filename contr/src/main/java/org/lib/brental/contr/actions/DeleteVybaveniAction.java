/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.actions;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import org.lib.brental.bussines.BrentalFacadeService;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.model.Lod;
import org.lib.brental.model.Padlo;
import org.lib.brental.model.Vesta;
import org.lib.brental.model.Vybaveni;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public class DeleteVybaveniAction extends AbstractBrentalAction {

    public DeleteVybaveniAction() {
        super("Smaž vybavení", "Vybavení");
    }

    private static class DeleteVybaveniHolder {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Vybaveni a = MainFrame.getInstance().getSelectedVybaveni();
        if (a == null) {
            MainFrame.getInstance().showError("Není vybrán žádný zaměstnanec!");
        } else {
            int result;
            result = JOptionPane.showConfirmDialog(MainFrame.getInstance(), a + "?");
            if (result == JOptionPane.YES_OPTION) {
                try {
                    if (a instanceof Vesta) {
                        BrentalFacadeService.getDefault().smazVestu(a.getId());
                        MainFrame.getInstance().refresh();
                    } else {
                        if (a instanceof Lod) {
                            BrentalFacadeService.getDefault().smazLod(a.getId());
                            MainFrame.getInstance().refresh();
                        } else {
                            if (a instanceof Padlo) {
                                BrentalFacadeService.getDefault().smazPadlo(a.getId());
                                MainFrame.getInstance().refresh();
                            }else{
                                BrentalFacadeService.getDefault().smazOther(a.getId());
                                MainFrame.getInstance().refresh();
                            }
                        }
                    }
                } catch (BRentalException ex) {
                    MainFrame.getInstance().showError(ex);
                }
            }
        }
    }
}
