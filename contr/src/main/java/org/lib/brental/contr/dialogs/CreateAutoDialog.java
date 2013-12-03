/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.dialogs;

import java.awt.GridLayout;
import java.util.Date;
import javax.swing.JLabel;
import org.lib.brental.bussines.BrentalFacade;
import org.lib.brental.utils.BRentalException;
import org.lib.brental.gui.MainFrame;

/**
 *
 * @author danecek
 */
public final class CreateAutoDialog extends AbstractBrentalDialog {

    ValidatedTF title;

    public CreateAutoDialog() {
        super("Create Book"); // todo
        title = new ValidatedTF(this);
        content.setLayout(new GridLayout(0, 2));
        content.add(new JLabel("Title:"));
        content.add(title);
        validateDialog();
        pack();
        setVisible(true);
    }

    @Override
    public boolean validateDialog() {
        if (title.getText().isEmpty()) {
            error("Prazdny titul");// todo
            return false;
        }
        clearError();
        return true;


    }

    @Override
    public void okAction() {
       /* try {
         //   LibraryFacade.getDefault().createBook(title.getText());
              MainFrame.getInstance().refresh();
        } catch (BRentalException le) {
              MainFrame.getInstance().showError(le);
        }*/
        try{
            BrentalFacade.getDefault().vytvorAuto("sdsadasd", 235, 2015515, new Date());
            MainFrame.getInstance().refresh();
        }catch (BRentalException ex){
            MainFrame.getInstance().showError(ex);
        }
    }
}
