/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.proxy;

import java.awt.event.ActionEvent;
import org.lib.brental.connection.ConnectionService;
import org.lib.brental.contr.actions.AbstractBrentalAction;
import org.lib.brental.gui.MainFrame;

/**
 *
 * @author john
 */
public class DisconnectAction extends AbstractBrentalAction {
    
    public DisconnectAction(){
        super("Odpojit...","Pripojeni");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ConnectionService.getDefault().disconnect();
        MainFrame.getInstance().actionsNotify();
    }
    
    public void setEnabled(){
        setEnabled(ConnectionService.getDefault().isConnected());
    }
    
}
