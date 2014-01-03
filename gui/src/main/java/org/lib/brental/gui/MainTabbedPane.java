/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.gui;

import java.awt.Color;
import java.util.Random;
import javax.swing.JTabbedPane;
import org.lib.brental.gui.impl.*;
import org.lib.brental.model.*;

/**
 *
 * @author john
 */
public class MainTabbedPane extends JTabbedPane {

    ZakaznikPanel zakaznikPanel;
    ZamestnanecPanel zamestnanecPanel;
    VybaveniPanel vybaveniPanel;
    RezervacePanel rezervacePanel;
    FakturaPanel fakturaPanel;
    AutoPanel autoPanel;

    public MainTabbedPane() {
        Color color = Color.getHSBColor((float) 0 / getTabCount(), 2, 1);
        addTab("Auta", autoPanel = new AutoPanel(color));

        addTab("Zaměstnanci", zamestnanecPanel = new ZamestnanecPanel(color));

        addTab("Zákazníci", zakaznikPanel = new ZakaznikPanel(color));

        addTab("Vybavení", vybaveniPanel = new VybaveniPanel(color));

        addTab("Rezervace", rezervacePanel = new RezervacePanel(color));

        for (int i = 0; i < this.getTabCount(); i++) {
            color = getRandomColor();
            this.setBackgroundAt(i, color);

        }

    }

    public Color getRandomColor() {
        Random random = new Random();
        final float hue = (random.nextFloat());
        final float saturation = (random.nextInt(2000) + 1000) / 10000f;
        final float luminance = 0.9f;
        return Color.getHSBColor(hue, saturation, luminance);

    }

    public VybaveniPanel getVybaveniPanel() {
        return vybaveniPanel;
    }

    public ZakaznikPanel getZakaznikPanel() {
        return zakaznikPanel;
    }

    public AutoPanel getAutoPanel() {
        return autoPanel;
    }

    public RezervacePanel getRezervacePanel() {
        return rezervacePanel;
    }

    public ZamestnanecPanel getZamPanel() {
        return zamestnanecPanel;
    }
}
