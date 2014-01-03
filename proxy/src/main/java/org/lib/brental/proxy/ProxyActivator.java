package org.lib.brental.proxy;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.lib.brental.bussines.BrentalFacadeService;
import org.lib.brental.gui.MainFrame;
import org.lib.brental.proxy.impl.BrentalFacadeProxy;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ProxyActivator implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {
        Logger.getLogger(getClass().getName()).log(Level.INFO, getClass().getName());
        MainFrame.getInstance().addBrentalMenu(new ConnectAction());
        MainFrame.getInstance().addBrentalMenu(new DisconnectAction());
        context.registerService(BrentalFacadeService.class.getName(),
                new BrentalFacadeProxy(), null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    }
}
