/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.actions;

import javax.swing.AbstractAction;
import org.lib.brental.gui.SetEnable;

/**
 *
 * @author john
 */
public abstract class AbstractBrentalAction extends AbstractAction implements SetEnable {

    private String name;

    public AbstractBrentalAction(String actionName, String buttonName) {
        super(actionName);
        this.name = buttonName;
    }
    
   
    /**
     *
     */
    @Override
    public void setEnable() {
     }

    public String getMenuName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
