package org.lib.brental.application;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.lib.brental.gui.MainFrame;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(final BundleContext context) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
              MainFrame.getInstance().setContext(context);
              MainFrame.getInstance().setVisible(true);
              
            }
        });
        
        // TODO add activation code here
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    }

}
