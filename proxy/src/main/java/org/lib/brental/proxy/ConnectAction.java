/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.proxy;

import java.awt.event.ActionEvent;
import org.lib.brental.connection.ConnectionService;
import org.lib.brental.contr.actions.AbstractBrentalAction;

/**
 *
 * @author john
 */
public class ConnectAction extends AbstractBrentalAction {

    public ConnectAction(){
        super("Pripojit...", "Pripojeni");
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        new ConnectionDialog();
    }
    
    @Override
    public void setEnabled(){
        setEnabled(!ConnectionService.getDefault().isConnected());
    }
    
}
