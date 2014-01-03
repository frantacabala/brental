package org.lib.brental.application;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.lib.brental.bussines.BrentalFacadeService;
import org.lib.brental.gui.MainFrame;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class AppActivator implements BundleActivator {

    private boolean started = false;

    @Override
    public void start(final BundleContext context) throws Exception {
        if (started == false) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    MainFrame.getInstance().setContext(context);
                    MainFrame.getInstance().setVisible(true);
                    MainFrame.getInstance().actionsNotify();
                    if (BrentalFacadeService.getDefault().isAvailable()) {
                        JOptionPane.showMessageDialog(null, "honov");
                        MainFrame.getInstance().refresh();
                    } else {
                        JOptionPane.showMessageDialog(null, "neni hovno");
                    }

                }
            });
            started = true;
        }



        // TODO add activation code here
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    }
}
