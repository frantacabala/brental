package org.lib.brental.gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class GuiActivator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
               Logger.getLogger(getClass().getName()).log(Level.INFO, getClass().getName());

    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    }

}
