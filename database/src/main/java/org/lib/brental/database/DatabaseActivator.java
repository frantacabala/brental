package org.lib.brental.database;

import javax.swing.JOptionPane;
import org.lib.brental.database.impl.DataDAOFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class DatabaseActivator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
        //DataDAOFactory df =new DataDAOFactory();
       // DataDAOFactory.getDefault().getAutoDAO().getAll();
        //JOptionPane.showMessageDialog(null,"jojo");
//        df.setContext(context);
//        df.exit();
        
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    }

}
