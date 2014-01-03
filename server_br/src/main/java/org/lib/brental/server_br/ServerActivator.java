package org.lib.brental.server_br;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.lib.brental.server_br.impl.ServerThread;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class ServerActivator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
        Logger.getLogger(getClass().getName()).log(Level.INFO,getClass().getName());
        ServiceTracker st = new ServiceTracker(context,CreateClientTaskService.class,null);
        CreateClientTaskService.setSt(st);
        new ServerThread();
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    }

}
