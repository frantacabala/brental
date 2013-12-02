package org.lib.brental.gui;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
        MainFrame.getInstance().setContext(context);
        MainFrame.getInstance().setVisible(true);
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    }

}
