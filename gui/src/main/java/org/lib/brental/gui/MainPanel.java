/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author john
 */
public class MainPanel extends JPanel {

    JButton btn_ref;
    MainTabbedPane mainTabbedPane;

    public MainPanel() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10));

        mainTabbedPane = new MainTabbedPane();
        add(mainTabbedPane, BorderLayout.CENTER);

    }

    public MainTabbedPane getTabbedPane() {
        return mainTabbedPane;
    }
}
