/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.controller.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.lib.brental.gui.SetEnable;

/**
 *
 * @author john
 */
public abstract class AbstractBrentalAction extends AbstractAction implements SetEnable {

    private String menuName;

    public AbstractBrentalAction(String actionName, String menuName) {
        super(actionName);
        this.menuName = menuName;
    }
    
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setEnable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMenuName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
