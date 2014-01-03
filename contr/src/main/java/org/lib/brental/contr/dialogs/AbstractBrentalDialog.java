/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.dialogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.utils.BRentalException;

/**
 *
 * @author john
 */
public abstract class AbstractBrentalDialog extends JDialog implements Validator{
    JLabel errorLabel = new JLabel();
    Box buttonBox = new Box(BoxLayout.X_AXIS);
    JPanel content = new JPanel(new BorderLayout());
     private Action okAction;

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
                try {
                    AbstractBrentalDialog.this.okAction();
                } catch (BRentalException ex) {
                    Logger.getLogger(AbstractBrentalDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
                AbstractBrentalDialog.this.dispose();
            }
        }));
        add(errorLabel, BorderLayout.NORTH);
        add(content);
        add(buttonBox, BorderLayout.SOUTH);
        setLocation(MainFrame.getInstance().getLocation());
        
        
    }

    public void error(String message) {
        errorLabel.setText(message);

    }

    public void clearError() {
        errorLabel.setText("");
    }
    
    public abstract void okAction() throws BRentalException;
    
    
    public JPanel getContent(){
        return content;
    }
    
}
