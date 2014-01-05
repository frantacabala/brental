/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.proxy;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import org.lib.brental.connection.ConnectionService;
import org.lib.brental.contr.dialogs.AbstractBrentalDialog;
import org.lib.brental.contr.dialogs.ValidatedTF;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.protocol.Auta;
import org.lib.brental.protocol.BrentalCommand;
import org.lib.brental.utils.BRentalException;
import org.lib.brental.utils.GBCBuilder;

/**
 *
 * @author john
 */
public final class ConnectionDialog extends AbstractBrentalDialog{

    private ValidatedTF host;
    private ValidatedTF port;

    public ConnectionDialog() {
        super("Connection...");
        
        getContent().setLayout(new GridBagLayout());
        getContent().add(new JLabel("Host" + ": "),
                new GBCBuilder().build());
        getContent().add(host = new ValidatedTF(this, "localhost"),
                new GBCBuilder().setXRel().build());
        getContent().add(new JLabel("Port" + ": "),
                new GBCBuilder().setY(1).build());
        getContent().add(port = new ValidatedTF(this, Integer.toString(BrentalCommand.port)),
                new GBCBuilder().setY(1).setX(GridBagConstraints.RELATIVE).build());
        host.setText("localhost");
        port.setText("3456");
        validateDialog();
        pack();
        setVisible(true);
    }

   
    
    @Override
    public boolean validateDialog() {
        try {
            InetAddress.getByName(host.getText());
        } catch (UnknownHostException ex) {
            
            error(ex.toString());
            return false;
        }
        try {
            Integer.parseInt(port.getText());
        } catch (NumberFormatException ex) {
            error("Invalid port number");
            return false;
        }
        clearError();
        return true;
    }

    @Override
    public void okAction() {
      try {
            ConnectionService.getDefault().connect(InetAddress.getByName(host.getText()), Integer.parseInt(port.getText()));
            MainFrame.getInstance().refresh();
            this.dispose();
        } catch (BRentalException ex) {
            MainFrame.getInstance().showError((BRentalException) ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ConnectionDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}
