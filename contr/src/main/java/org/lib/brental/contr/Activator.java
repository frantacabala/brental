package org.lib.brental.contr;

import org.lib.brental.contr.actions.CreateAutoAction;
import org.lib.brental.gui.MainFrame;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
      //  MainFrame.getInstance().getMainPanel().getTabbedPane().getAutoPanel().setCreateBtn(new CreateAutoAction());
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    }

}
