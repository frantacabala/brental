package org.lib.brental.mainlauncher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.felix.framework.Felix;
import org.apache.felix.framework.util.FelixConstants;
import org.apache.felix.main.AutoProcessor;
import org.apache.felix.main.Main;
import org.lib.brental.application.AppActivator;
import org.lib.brental.contr.ContrActivator;
import org.lib.brental.gui.GuiActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

/**
 * Hello world!
 *
 */
public class App {

    //private AppActivator m_activator = null;
    private static Felix m_felix = null;

    public static void main(String[] args) throws BundleException {
        AppActivator app=new AppActivator();
        GuiActivator gui=new GuiActivator();
        ContrActivator contr = new ContrActivator();
        
        Map config = new HashMap();
        // Create host activator;
        
        List list = new ArrayList();
        list.add(app);
        list.add(contr);
        list.add(gui);
        
        config.put(FelixConstants.SYSTEMBUNDLE_ACTIVATORS_PROP, list);

        try
        {
            // Now create an instance of the framework with
            // our configuration properties.
            m_felix = new Felix(config);
            // Now start Felix instance.
            BundleContext context = m_felix.getBundleContext();
            
            contr.start(context);
            app.start(context);
            //gui.start(context);
            
            
            //m_felix.start();
            
        }
        catch (Exception ex)
        {
            System.err.println("Could not create framework: " + ex);
            ex.printStackTrace();
        }
        // (1) Check for command line arguments and verify usage.
       
                
       
    }
    
    
    
    
}
