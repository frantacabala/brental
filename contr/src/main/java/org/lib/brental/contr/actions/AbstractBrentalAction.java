/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.contr.actions;

import javax.swing.AbstractAction;
import org.lib.brental.gui.SetEnable;
import org.lib.brental.utils.BrentalAction;

/**
 *
 * @author john
 */
public abstract class AbstractBrentalAction extends AbstractAction implements BrentalAction {

    private String name;

    public AbstractBrentalAction(String actionName, String buttonName) {
        super(actionName);
        this.name = buttonName;
    }

    /**
     *
     */
    @Override
    public void setEnabled() {
    }

    @Override
    public String getMenuName() {
        return name;
    }
}
