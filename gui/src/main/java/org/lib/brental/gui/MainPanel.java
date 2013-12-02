/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author john
 */
public class MainPanel extends JPanel {
    JButton btn_ref;
    public MainPanel(){
        setLayout(new BorderLayout());
        
        JPanel icoPanel;
        icoPanel = new JPanel();
        icoPanel.add(btn_ref=new JButton("Refresh"));
        MainTabbedPane tabP= new MainTabbedPane();
        add(tabP,BorderLayout.CENTER);
        add(icoPanel, BorderLayout.NORTH);
    }
}
