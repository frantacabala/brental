package org.lib.brental.connection;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class ConnectionActivator implements BundleActivator {

    ServiceTracker serviceTracker;

    @Override
    public void start(BundleContext context) throws Exception {
        Logger.getLogger(getClass().getName()).log(Level.INFO, getClass().getName());
        serviceTracker = new ServiceTracker(context, ConnectionService.class, null);
        serviceTracker.open();
        Logger.getLogger("jojojojojoj sem to dojde");
        ConnectionService.setSt(serviceTracker);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        if (ConnectionService.getDefault().isConnected()) {
            ConnectionService.getDefault().disconnect();
        }
    }
}
