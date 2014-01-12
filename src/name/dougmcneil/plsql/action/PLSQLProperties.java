/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.dougmcneil.plsql.action;

import name.dougmcneil.plsql.ui.PLSQLPropertiesPanel;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.actions.CallableSystemAction;

/**
 * Invoke PLSQL Properties.
 * @author doug
 */
public class PLSQLProperties extends CallableSystemAction {
    
    public PLSQLProperties() {
        putValue("noIconInMenu", false);
    }

    @Override
    public void performAction() {
        PLSQLPropertiesPanel.showPLSQLProperties();
    }

    @Override
    public String getName() {
        return NbBundle.getMessage(PLSQLProperties.class, "LBL_PropertiesAction");
    }

    @Override
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }
    
    @Override
    protected boolean asynchronous() {
        return false;
    }
}
