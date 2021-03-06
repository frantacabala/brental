/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.dialogs;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import org.lib.brental.bussines.BrentalFacadeService;
import org.lib.brental.utils.BRentalException;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.model.Adresa;

/**
 *
 * @author danecek
 */
public final class CreateZamestnanecDialog extends AbstractBrentalDialog {

    ValidatedTF jmeno;
    ValidatedTF prijimeni;
    ValidatedTF funkce;
    ValidatedTF ulice;
    ValidatedTF mesto;
    ValidatedTF psc;
    ValidatedTF login;
    ValidatedTF heslo;
    ValidatedTF heslo1;

    public CreateZamestnanecDialog() {
        super("Vytvoř auto"); // todo
        content.setBorder(new EmptyBorder(4, 4, 4, 4));
        jmeno = new ValidatedTF(this, 10);
        prijimeni = new ValidatedTF(this, 10);
        funkce = new ValidatedTF(this, 10);
        ulice = new ValidatedTF(this, 10);
        mesto = new ValidatedTF(this, 10);
        psc = new ValidatedTF(this, 5);
        login = new ValidatedTF(this, 10);
        heslo1 = new ValidatedTF(this, 10);
        heslo = new ValidatedTF(this, 10);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weightx = 0;

        // addr panel - rgiht
        JPanel addr = new JPanel(new GridBagLayout());
        addr.setBorder(new CompoundBorder(new TitledBorder("Adresa"), new EmptyBorder(4, 4, 4, 4)));

        addr.add(new JLabel("Ulice: "), gbc);
        gbc.gridx++;
        addr.add(ulice,gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        addr.add(new JLabel("Mesto: "), gbc);
        gbc.gridx++;
        addr.add(mesto,gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        addr.add(new JLabel("PSC: "),gbc);
        gbc.gridx++;
        addr.add(psc,gbc);
        // addr panel -right

        // info panel -legt
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weightx = 0;
        JPanel info = new JPanel(new GridBagLayout());
        info.setBorder(new CompoundBorder(new TitledBorder("Osobni udaje"), new EmptyBorder(4, 4, 4, 4)));

        info.add(new JLabel("Jmeno: "), gbc);
        gbc.gridx++;
        info.add(jmeno,gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        info.add(new JLabel("Prijimeni: "), gbc);
        gbc.gridx++;
        info.add(prijimeni,gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        info.add(new JLabel("Funkce: "),gbc);
        gbc.gridx++;
        info.add(funkce,gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        info.add(new JLabel("Login: "),gbc);
        gbc.gridx++;
        info.add(login,gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        info.add(new JLabel("Heslo: "),gbc);
        gbc.gridx++;
        info.add(heslo,gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        info.add(new JLabel("Potvrzeni hesla: "),gbc);
        gbc.gridx++;
        info.add(heslo1,gbc);
        // info panel - left

        content.setLayout(new BorderLayout());
        content.add(info, BorderLayout.LINE_START);
        content.add(addr, BorderLayout.LINE_END);

        validateDialog();
        pack();
        setVisible(true);
    }

    @Override
    public boolean validateDialog() {
        if (jmeno.getText().isEmpty()) {
            error("Prazdny titul");// todo
            return false;
        }
        clearError();
        return true;


    }

    @Override
    public void okAction() {
        try {
            /* try {
             //   LibraryFacade.getDefault().createBook(title.getText());
             MainFrame.getInstance().refresh();
             } catch (BRentalException le) {
             MainFrame.getInstance().showError(le);
             }*/
            BrentalFacadeService.getDefault().vytvorZamestnance(jmeno.getText(), prijimeni.getText(),funkce.getText(), new Adresa(ulice.getText(), mesto.getText(), Integer.parseInt(psc.getText())),login.getText(),heslo.getText() );
            MainFrame.getInstance().refresh();
        } catch (BRentalException ex) {
            Logger.getLogger(CreateZamestnanecDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
