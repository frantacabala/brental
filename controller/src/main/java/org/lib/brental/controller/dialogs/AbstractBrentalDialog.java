/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.controller.dialogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.lib.brental.gui.MainFrame;

/**
 *
 * @author john
 */
public abstract class AbstractBrentalDialog extends JDialog implements Validator{
    JLabel errorLabel = new JLabel();
    Box buttonBox = new Box(BoxLayout.X_AXIS);
    JPanel content = new JPanel();

    public AbstractBrentalDialog(String title) {
        super(MainFrame.getInstance(), title, true);
        buttonBox.add(Box.createHorizontalGlue());
        buttonBox.add(new JButton(new AbstractAction("Cancel") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AbstractBrentalDialog.this.dispose();
            }
        }));
        buttonBox.add(new JButton(new AbstractAction("OK") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AbstractBrentalDialog.this.okAction();
                AbstractBrentalDialog.this.dispose();
            }
        }));
        add(errorLabel, BorderLayout.NORTH);
        add(content);
        add(buttonBox, BorderLayout.SOUTH);
        setLocation(MainFrame.getInstance().getLocation());
        
        
    }

    void error(String message) {
        errorLabel.setText(message);

    }

    void clearError() {
        errorLabel.setText("");
    }
    
    abstract void okAction();
    
}
