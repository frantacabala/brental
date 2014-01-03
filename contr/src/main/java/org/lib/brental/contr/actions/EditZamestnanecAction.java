/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.actions;

import java.awt.event.ActionEvent;
import org.lib.brental.contr.dialogs.EditZamestnanecDialog;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.model.Zamestnanec;

/**
 *
 * @author john
 */
public class EditZamestnanecAction extends AbstractBrentalAction{

    public EditZamestnanecAction() {
        super("Edituj zaměstnance", "Zaměstnanec");
        setEnabled(false);
    }

    private static class EditZamestnanecHolder{
        private static final CreateZamestnanecAction INSTANCE = new CreateZamestnanecAction();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
         Zamestnanec a = MainFrame.getInstance().getSelectedZamestnanec();
        if(a == null){
            MainFrame.getInstance().showError("Neni vybran zadny zamestnanec!");
        }else{
             new EditZamestnanecDialog(a);

        }
    }
    
     @Override
    public void setEnabled(){
        setEnabled(MainFrame.getInstance().getSelectedZamestnanec() != null);
    }
    
    
}
