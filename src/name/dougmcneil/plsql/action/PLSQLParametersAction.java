/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.dougmcneil.plsql.action;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import name.dougmcneil.plsql.PLSQLDriver;
import name.dougmcneil.plsql.ui.PLSQLParametersTopComponent;
import org.openide.awt.Actions;
import org.openide.cookies.EditorCookie;
import org.openide.util.ContextAwareAction;
import org.openide.util.Exceptions;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.Mutex;
import org.openide.util.NbBundle;
import org.openide.util.actions.Presenter;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import static org.openide.windows.WindowManager.getDefault;

/**
 * Invoke PLSQL Parameters window and hook into SQLExecution activity, allowing
 * parameters to be passed to PLSQLDriver.
 * 
 * @author doug
 */
@NbBundle.Messages({
    "CTL_PLSQLParametersAction=PLSQL Parameters", "LBL_Execution=execution"})
public class PLSQLParametersAction  extends AbstractAction
        implements ContextAwareAction, HelpCtx.Provider {
    
    private static final String ICON_BASE = "name/dougmcneil/plsql/resources/plsql.png";
    
    private static final String EXECUTING_PROP = "executing";

    // load driver when node requested
    private static final PLSQLDriver PLSQL_DRIVER =
        PLSQLDriver.getInstance();
    
    private static final WindowManager WM_D = getDefault();
    private static final Class PCL_c = PropertyChangeListener.class;

    
    public PLSQLParametersAction() {
    }
    
    protected String iconResource() {
        return ICON_BASE;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }


    @Override
    public Action createContextAwareInstance(Lookup lkp) {
        return new ContextAwareDelegate(this, lkp);
    }

    static class ContextAwareDelegate extends AbstractAction 
            implements Presenter.Toolbar, HelpCtx.Provider {
        
        private final PLSQLParametersAction _parent;
        private final Lookup.Result<Object> _result;
        // title and identity
        private final String _title;
        
        private PLSQLParametersTopComponent _window;
    
        
        public ContextAwareDelegate(PLSQLParametersAction action, Lookup lkp) {
            _parent = action;
            EditorCookie cookie = lkp.lookup(EditorCookie.class);
            _title = (String) cookie.getDocument().getProperty("title");
            if (getValue(Action.NAME) == null) {
                putValue(Action.NAME, "PLSQL Parameters");
            }
            String iconBase = _parent.iconResource();
            if (iconBase != null) {
                putValue("iconBase", iconBase);
            }
            _result = lkp.lookupResult(Object.class);
            _result.addLookupListener(new LookupListener() {
                public void resultChanged(LookupEvent ev) {
                    ContextAwareDelegate.this.resultChanged();
                }
            });
            resultChanged();
        }

        private synchronized void resultChanged() {

            Collection<? extends Object> all = _result.allInstances();
            for (Object o: all) {
                if (o.getClass().getName().endsWith("SQLExecutionImpl")) {
                    try {
                        Class<?>[] faces = o.getClass().getInterfaces();
                        for (Class klass: faces) {
                            if (klass.getName().endsWith("SQLExecution")) {
                                Method m = klass.getMethod("addPropertyChangeListener", PCL_c);
                                PropertyChangeListener listener = new PropertyChangeListener() {
                                    public void propertyChange(PropertyChangeEvent evt) {
                                        propertyChanged(evt.getPropertyName());
                                    }
                                };
                                m.invoke(o, listener);
                                break;
                            }
                        }
                    } catch (NoSuchMethodException ex) {
                        Exceptions.printStackTrace(ex);
                    } catch (SecurityException ex) {
                        Exceptions.printStackTrace(ex);
                    } catch (IllegalAccessException ex) {
                        Exceptions.printStackTrace(ex);
                    } catch (IllegalArgumentException ex) {
                        Exceptions.printStackTrace(ex);
                    } catch (InvocationTargetException ex) {
                        Exceptions.printStackTrace(ex);
                    }
                    break;
                }
            }
        }
        
         private void propertyChanged(String propertyName) {
            if (propertyName != null && propertyName.equals(EXECUTING_PROP)) {
                PLSQLDriver.getInstance().setIO(getOutputWindowTitle(_title));
            }
        }
         
       @Override
        public void actionPerformed(ActionEvent e) {
            if (_window == null) {
                TopComponent win = WM_D.findTopComponent("PLSQLParametersTopComponent");
                _window = (PLSQLParametersTopComponent) win;
                _window.applyConfiguration(_title);
                _window.open();
            } else {
                if (!_window.isOpened()) {
                    TopComponent win = WM_D.findTopComponent("PLSQLParametersTopComponent");
                    _window = (PLSQLParametersTopComponent) win;
                    _window.applyConfiguration(_title);
                    _window.open();
                }
            }
            _window.requestActive();

        }
        
        private String getOutputWindowTitle(String title) {
            String prefix = _title.substring(_title.lastIndexOf(File.separatorChar) + 1, _title.length());
            if (prefix.startsWith("SQL")) {
                prefix = prefix.substring(0, 5).trim();
            }
            return  prefix + " " + Bundle.LBL_Execution();
        }
        
        @Override
        public Component getToolbarPresenter() {
            JButton button = new JButton();
            Actions.connect(button, this);
            return button;
        }

        @Override
        public HelpCtx getHelpCtx() {
            return _parent.getHelpCtx();
        }
    }
}
