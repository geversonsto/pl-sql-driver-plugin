/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.dougmcneil.plsql;

import java.util.ArrayList;
import java.util.List;
import org.netbeans.api.db.explorer.node.NodeProvider;
import org.netbeans.api.db.explorer.node.NodeProviderFactory;
import org.openide.nodes.Node;
import org.openide.util.Lookup;

/**
 * Node providing access to properties.
 * @author doug
 */
public class PLSQLNodeProvider extends NodeProvider {
    
    // load driver when node requested
    private static final PLSQLDriver PLSQL_DRIVER =
        PLSQLDriver.getInstance();
    
    public PLSQLNodeProvider(Lookup lookup) {
        super(lookup);
    }

    public static NodeProviderFactory getFactory() {
        return FactoryHolder.FACTORY;
    }
    
    @Override
    protected void initialize() {
        List<Node> newList = new ArrayList<Node>();
        newList.add(PLSQLServerNode.getInstance());
        setNodes(newList);
    }
    
    private static class FactoryHolder {

        static final NodeProviderFactory FACTORY = new NodeProviderFactory() {

            @Override
            public PLSQLNodeProvider createInstance(final Lookup lookup) {
                PLSQLNodeProvider provider = new PLSQLNodeProvider(lookup);

                return provider;
            }
        };
    }
}
