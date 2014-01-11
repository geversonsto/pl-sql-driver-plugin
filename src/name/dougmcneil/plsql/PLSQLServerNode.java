/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.dougmcneil.plsql;

import javax.swing.Action;
import name.dougmcneil.plsql.action.PLSQLProperties;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.actions.SystemAction;

/**
 * Node in Services/Databases
 * @author doug
 */
public class PLSQLServerNode extends AbstractNode implements Comparable<Node> {
    
    private static final String DISPLAY_NAME = "PL/SQL Oracle Database Driver"; // NOI18N
    private static final String ICON_BASE = "name/dougmcneil/plsql/resources/plsql.png";
    private static final PLSQLServerNode INSTANCE = new PLSQLServerNode();
    private SystemAction[] actions = new SystemAction[]{
        SystemAction.get(PLSQLProperties.class)
    };
    public static PLSQLServerNode getInstance() {
        return INSTANCE;
    }

    private PLSQLServerNode() {
        super(Children.LEAF);
        this.setIconBaseWithExtension(ICON_BASE);
    }

    @Override
    public String getDisplayName() {
        return DISPLAY_NAME;
    }

    @Override
    public Action[] getActions(boolean context) {
        return actions;
    }

    @Override
    public boolean canCopy() {
        return false;
    }

    @Override
    public boolean canCut() {
        return false;
    }

    @Override
    public boolean canRename() {
        return false;
    }

    @Override
    public boolean canDestroy() {
        return true;
    }

    @Override
    public int compareTo(Node other) {
        
        return this.getDisplayName().compareTo(other.getDisplayName());
    }
}
