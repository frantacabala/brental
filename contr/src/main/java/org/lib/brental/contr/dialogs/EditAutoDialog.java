/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.dialogs;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import org.lib.brental.bussines.BrentalFacadeService;
import org.lib.brental.utils.BRentalException;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.model.Auto;

/**
 *
 * @author danecek
 */
public final class EditAutoDialog extends AbstractBrentalDialog {

    ValidatedTF spz;
    ValidatedTF kapacita;
    ValidatedTF cena;
    ValidatedTF datum;
    ValidatedTF datum_tk;
    JLabel SPZ;
    JLabel KAPACITA;
    JLabel CENA;
    JLabel DATUM;
    Date date;
    Date date_tk;
    
    Auto a;
    public EditAutoDialog(Auto a) {
        super("Vytvoř auto"); // todo

        spz = new ValidatedTF(this, 10);
        kapacita = new ValidatedTF(this, 3);
        cena = new ValidatedTF(this, 4);
        datum = new ValidatedTF(this, 10);
        datum_tk = new ValidatedTF(this,10);

        spz.setSize(20, 5);

         this.a=a;
        content.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0;

        content.add(new JLabel("SPZ: "), gbc);
        gbc.gridx++;
        content.add(spz);
        spz.setText(a.getZnacka());
        gbc.gridx++;
        content.add(new JLabel("cena: "), gbc);
        gbc.gridx++;
        content.add(cena);
        cena.setText(Integer.toString(a.getCena_zakoupeni()));

        gbc.gridx++;
        content.add(new JLabel("kapacita: "), gbc);
        kapacita.setText(Integer.toString(a.getKapacita()));
        gbc.gridx++;
        content.add(kapacita);

        gbc.gridx++;
        content.add(new JLabel("datum nakupu: "), gbc);
        gbc.gridx++;
       
        content.add(datum);
        datum.setText(new SimpleDateFormat("yyyy-MM-dd").format(a.getDatum_zakoupeni()));
        
        
        gbc.gridx++;
        content.add(new JLabel("datum TK: "), gbc);
        gbc.gridx++;
      
        content.add(datum_tk);
        datum_tk.setText(new SimpleDateFormat("yyyy-MM-dd").format(a.getDatum_tk()));

        validateDialog();



        pack();
        setVisible(true);
    }
    
    @Override
    public boolean validateDialog() {
        if (spz.getText().isEmpty()) {
            error("Prazdna SPZ");// todo
            return false;
        }else{
            if(spz.getText().length() >=8 )
            {
                spz.setText(spz.getText().substring(0, 7));
            }
        }
        if (cena.getText().isEmpty()) {
            error("Prazdna cena");// todo
            return false;
        }
        if (kapacita.getText().isEmpty()) {
            error("Prazdna kapacita");// todo
            return false;
        }
        if (datum.getText().isEmpty()) {
            error("Prazdne datum");// todo

            return false;
        }
        clearError();
        return true;


    }

    @Override
    public void okAction() {
        try {
           
             try {
                date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(datum.getText());
                date_tk = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(datum_tk.getText());
            } catch (ParseException ex) {
                MainFrame.getInstance().showError("Spatne datum");
                datum.setText("dd-mm-rrrr");
                return;
            }
            
            BrentalFacadeService.getDefault().aktualizujAuto(new Auto(a.getId(),spz.getText(), Integer.parseInt(kapacita.getText()), Integer.parseInt(cena.getText()), date,date_tk));
            MainFrame.getInstance().refresh();
        } catch (BRentalException ex) {
            MainFrame.getInstance().showError(ex);
        }
    }
}
