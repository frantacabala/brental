/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.dialogs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import org.lib.brental.bussines.BrentalFacadeService;
import org.lib.brental.utils.BRentalException;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.model.Lod;
import org.lib.brental.model.Other;
import org.lib.brental.model.Padlo;
import org.lib.brental.model.Vesta;
import org.lib.brental.model.Vybaveni;

/**
 *
 * @author danecek
 */
public final class CreateVybaveniDialog extends AbstractBrentalDialog {

    ValidatedTF nazev;
    ValidatedTF cena_nak;
    ValidatedTF datum_nak;
    ValidatedTF barva;
    ValidatedTF cena_puj;
    ValidatedTF vaha;
    ValidatedTF evid;
    ValidatedTF delka;
    ValidatedTF sirka;
    ValidatedTF typ;
    ValidatedTF max_ponor;
    ValidatedTF model;
    ValidatedTF nostnost;
    ValidatedTF poznamka;
    ValidatedTF vel;
    ValidatedTF vyrob;
    Date date;
    Vybaveni vyb;
    JPanel addr;
    String item;

    public CreateVybaveniDialog(Vybaveni vyb) {
        super("Přidej vybavení"); // todo
        this.vyb = vyb;
        
        item = MainFrame.getInstance().getMainPanel().getTabbedPane().getVybaveniPanel().getChooser().getSelectedItem().toString();

        content.setBorder(new EmptyBorder(4, 4, 4, 4));
        nazev = new ValidatedTF(this, 10);
        cena_nak = new ValidatedTF(this, 10);
        cena_puj = new ValidatedTF(this, 10);
        datum_nak = new ValidatedTF(this, 10);
        barva = new ValidatedTF(this, 10);
        vaha = new ValidatedTF(this, 10);
        evid = new ValidatedTF(this, 10);
        


        delka = new ValidatedTF(this, 5);
        model = new ValidatedTF(this, 10);
        sirka = new ValidatedTF(this, 5);
        typ = new ValidatedTF(this, 10);
        vyrob = new ValidatedTF(this, 10);
        poznamka = new ValidatedTF(this, 10);
        max_ponor=new ValidatedTF(this, 10);
        vel = new ValidatedTF(this, 10);
        nostnost=new ValidatedTF(this, 10);


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weightx = 0;

        // spolecny panel - nalevo
        JPanel info = new JPanel(new GridBagLayout());


        info.add(new JLabel("Název: "), gbc);
        gbc.gridx++;
        info.add(nazev, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        info.add(new JLabel("Nákupní cena: "), gbc);
        gbc.gridx++;
        info.add(cena_nak, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        info.add(new JLabel("Datum nákupu: "), gbc);
        gbc.gridx++;
        info.add(datum_nak, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        info.add(new JLabel("Barva: "), gbc);
        gbc.gridx++;
        info.add(barva, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        info.add(new JLabel("Půjčovací cena: "), gbc);
        gbc.gridx++;
        info.add(cena_puj, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        info.add(new JLabel("Váha: "), gbc);
        gbc.gridx++;
        info.add(vaha, gbc);
        gbc.gridy++;
        info.add(new JLabel("Evidenční číslo: "), gbc);
        gbc.gridx++;
        info.add(evid, gbc);
        // spolecny panel
        addr = new JPanel(new GridBagLayout());
        if (item.equals("VESTY")) {
            JOptionPane.showMessageDialog(null, "Vesta");
            drawVesta(addr);
        } else {
            if (item.equals("LODE")) {
                JOptionPane.showMessageDialog(null, "Lod");
                drawLod(addr);
            } else {
                if (item.equals("DALSI")) {
                    JOptionPane.showMessageDialog(null, "Other");
                    drawOther(addr);
                } else {
                    JOptionPane.showMessageDialog(null, "Padlo");
                    drawPadlo(addr);
                }
            }
        }




        content.setLayout(new BorderLayout());
        content.setBorder(new CompoundBorder(new TitledBorder("Přidej vybavení"), new EmptyBorder(4, 4, 4, 4)));
        content.add(info, BorderLayout.LINE_START);
        content.add(addr, BorderLayout.LINE_END);

        validateDialog();
        pack();
        setVisible(true);
    }

    public void drawPadlo(JPanel addrs) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weightx = 0;

        addr.add(new JLabel("Délak pádla: "), gbc);
        gbc.gridx++;
        addr.add(delka, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        addr.add(new JLabel("Šířka listu: "), gbc);
        gbc.gridx++;
        addr.add(sirka, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        addr.add(new JLabel("Typ: "), gbc);
        gbc.gridx++;
        addr.add(typ, gbc);
    }

    @Override
    public boolean validateDialog() {
        if (nazev.getText().isEmpty()) {
            error("Prazdny titul");// todo
            return false;
        }
        clearError();
        return true;


    }

    @Override
    public void okAction() {
        try {
            try {
                date = new SimpleDateFormat("yyy-MM-dd", Locale.ENGLISH).parse(datum_nak.getText());
            } catch (ParseException ex) {
                MainFrame.getInstance().showError("Spatne datum");
                return;
            }

            if (item.equals("VESTY")) {

                BrentalFacadeService.getDefault().vytvorVestu(nazev.getText(),
                        Integer.parseInt(cena_nak.getText()), date, barva.getText(),
                        Integer.parseInt(cena_puj.getText()), Integer.parseInt(vaha.getText()),evid.getText(), typ.getText(), vel.getText(), vyrob.getText());
            } else {
                if (item.equals("LODE")) {

                    BrentalFacadeService.getDefault().vytvorLod(nazev.getText(),
                            Integer.parseInt(cena_nak.getText()), date, barva.getText(),
                            Integer.parseInt(cena_puj.getText()), Integer.parseInt(vaha.getText()),evid.getText(),Integer.parseInt(delka.getText()),
                            Integer.parseInt(max_ponor.getText()), model.getText(), Integer.parseInt(nostnost.getText()), Integer.parseInt(sirka.getText()), typ.getText(), vyrob.getText());
                } else {
                    if (item.equals("PADLA")) {

                        BrentalFacadeService.getDefault().vytvorPadlo(nazev.getText(),
                                Integer.parseInt(cena_nak.getText()), date, barva.getText(),
                                Integer.parseInt(cena_puj.getText()), Integer.parseInt(vaha.getText()),evid.getText(), Integer.parseInt(delka.getText()), Integer.parseInt(sirka.getText()), typ.getText());
                    } else {

                        BrentalFacadeService.getDefault().vytvorOther(nazev.getText(),
                                Integer.parseInt(cena_nak.getText()), date, barva.getText(),
                                Integer.parseInt(cena_puj.getText()), Integer.parseInt(vaha.getText()),evid.getText(), poznamka.getText());
                    }
                }
            }



            MainFrame.getInstance().refresh();
        } catch (BRentalException ex) {
            MainFrame.getInstance().showError(ex);
        }
        /* try {
         //   LibraryFacade.getDefault().createBook(title.getText());
         MainFrame.getInstance().refresh();
         } catch (BRentalException le) {
         MainFrame.getInstance().showError(le);
         }*/
    }

    private void drawVesta(JPanel addrs) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weightx = 0;

        gbc.gridx = 0;
        gbc.gridy++;
        addr.add(new JLabel("Typ: "), gbc);
        gbc.gridx++;
        addr.add(typ, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        addr.add(new JLabel("Velikost: "), gbc);
        gbc.gridx++;
        addr.add(vel, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        addr.add(new JLabel("Výrobce: "), gbc);
        gbc.gridx++;
        addr.add(vyrob, gbc);

    }

    private void drawLod(JPanel addrs) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weightx = 0;

        addr.add(new JLabel("Délka lodi: "), gbc);
        gbc.gridx++;
        addr.add(delka, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        addr.add(new JLabel("Max ponor: "), gbc);
        gbc.gridx++;
        addr.add(max_ponor, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        addr.add(new JLabel("Model: "), gbc);
        gbc.gridx++;
        addr.add(model, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        addr.add(new JLabel("Nostnost: "), gbc);
        gbc.gridx++;
        addr.add(nostnost, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        addr.add(new JLabel("Šířka: "), gbc);
        gbc.gridx++;
        addr.add(sirka, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        addr.add(new JLabel("Typ: "), gbc);
        gbc.gridx++;
        addr.add(typ, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        addr.add(new JLabel("Výrobce: "), gbc);
        gbc.gridx++;
        addr.add(vyrob, gbc);
    }

    private void drawOther(JPanel addrs) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weightx = 0;

        gbc.gridx = 0;
        gbc.gridy++;
        addr.add(new JLabel("Poznámka: "), gbc);
        gbc.gridx++;
        addr.add(poznamka, gbc);
    }
}
