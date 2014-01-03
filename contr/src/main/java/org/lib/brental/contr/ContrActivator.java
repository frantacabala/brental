package org.lib.brental.contr;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.lib.brental.contr.actions.CreateAutoAction;
import org.lib.brental.contr.actions.CreateRezervaceAction;
import org.lib.brental.contr.actions.CreateVybaveniAction;
import org.lib.brental.contr.actions.CreateZakaznikAction;
import org.lib.brental.contr.actions.CreateZamestnanecAction;
import org.lib.brental.contr.actions.DeleteAutoAction;
import org.lib.brental.contr.actions.DeleteRezervaceAction;
import org.lib.brental.contr.actions.DeleteVybaveniAction;
import org.lib.brental.contr.actions.DeleteZakaznikAction;
import org.lib.brental.contr.actions.DeleteZamestnanecAction;
import org.lib.brental.contr.actions.EditAutoAction;
import org.lib.brental.contr.actions.EditRezervaceAction;
import org.lib.brental.contr.actions.EditVybaveniAction;
import org.lib.brental.contr.actions.EditZakaznikAction;
import org.lib.brental.contr.actions.EditZamestnanecAction;
import org.lib.brental.contr.actions.RefreshAction;
import org.lib.brental.gui.MainFrame;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ContrActivator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
        Logger.getLogger(getClass().getName()).log(Level.INFO, getClass().getName());
        MainFrame.getInstance().getMainPanel().getTabbedPane().getAutoPanel().setCreateBtn(new CreateAutoAction());
        MainFrame.getInstance().getMainPanel().getTabbedPane().getAutoPanel().setDeleteBtn(new DeleteAutoAction());
        MainFrame.getInstance().getMainPanel().getTabbedPane().getAutoPanel().setEditBtn(new EditAutoAction());
        MainFrame.getInstance().addBrentalMenu(new CreateAutoAction());
        MainFrame.getInstance().addBrentalMenu(new DeleteAutoAction());
        MainFrame.getInstance().addBrentalMenu(new EditAutoAction());

        MainFrame.getInstance().getMainPanel().getTabbedPane().getZamPanel().setCreateBtn(new CreateZamestnanecAction());
        MainFrame.getInstance().getMainPanel().getTabbedPane().getZamPanel().setDeleteBtn(new DeleteZamestnanecAction());
        MainFrame.getInstance().getMainPanel().getTabbedPane().getZamPanel().setEditBtn(new EditZamestnanecAction());
        MainFrame.getInstance().addBrentalMenu(new CreateZamestnanecAction());
        MainFrame.getInstance().addBrentalMenu(new DeleteZamestnanecAction());
        MainFrame.getInstance().addBrentalMenu(new EditZamestnanecAction());

        
         MainFrame.getInstance().getMainPanel().getTabbedPane().getZakaznikPanel().setCreateBtn(new CreateZakaznikAction());
        MainFrame.getInstance().getMainPanel().getTabbedPane().getZakaznikPanel().setDeleteBtn(new DeleteZakaznikAction());
        MainFrame.getInstance().getMainPanel().getTabbedPane().getZakaznikPanel().setEditBtn(new EditZakaznikAction());
        MainFrame.getInstance().addBrentalMenu(new CreateZakaznikAction());
        MainFrame.getInstance().addBrentalMenu(new DeleteZakaznikAction());
        MainFrame.getInstance().addBrentalMenu(new EditZakaznikAction());
        
        MainFrame.getInstance().getMainPanel().getTabbedPane().getVybaveniPanel().setCreateBtn(new CreateVybaveniAction());
        MainFrame.getInstance().getMainPanel().getTabbedPane().getVybaveniPanel().setEditBtn(new EditVybaveniAction());
        MainFrame.getInstance().getMainPanel().getTabbedPane().getVybaveniPanel().setDeleteBtn(new DeleteVybaveniAction());
        MainFrame.getInstance().addBrentalMenu(new CreateVybaveniAction());
        MainFrame.getInstance().addBrentalMenu(new DeleteVybaveniAction());
        MainFrame.getInstance().addBrentalMenu(new EditVybaveniAction());
        
         MainFrame.getInstance().getMainPanel().getTabbedPane().getRezervacePanel().setCreateBtn(new CreateRezervaceAction());
        MainFrame.getInstance().getMainPanel().getTabbedPane().getRezervacePanel().setEditBtn(new EditRezervaceAction());
        MainFrame.getInstance().getMainPanel().getTabbedPane().getRezervacePanel().setDeleteBtn(new DeleteRezervaceAction());
        MainFrame.getInstance().addBrentalMenu(new CreateRezervaceAction());
        MainFrame.getInstance().addBrentalMenu(new DeleteVybaveniAction());
        MainFrame.getInstance().addBrentalMenu(new DeleteRezervaceAction());
        
        
        MainFrame.getInstance().addBrentalMenu(new RefreshAction());
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    }
}
