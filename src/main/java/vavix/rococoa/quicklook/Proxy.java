package vavix.rococoa.quicklook;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.rococoa.Foundation;
import org.rococoa.ID;
import org.rococoa.Rococoa;
import org.rococoa.cocoa.foundation.NSNotificationCenter;
import org.rococoa.cocoa.foundation.NSObject;
import org.rococoa.cocoa.foundation.NSThread;


public class Proxy {
    private static final Logger log = Logger.getLogger(Proxy.class.getName());

    /**
     * You need to keep a reference to the returned value for as long as it is
     * active. When it is GCd, it will release the Objective-C proxy.
     */
    private NSObject proxy;

    private ID id;

    private final Object target;

    public Proxy() {
        // Callback to self
        this.target = this;
    }

    public Proxy(final Object target) {
        this.target = target;
    }

    public NSObject proxy() {
        return this.proxy(NSObject.class);
    }

    protected NSObject proxy(Class<? extends NSObject> type) {
        if(null == proxy) {
            proxy = Rococoa.proxy(target, type);
        }
        return proxy;
    }

    public ID id() {
        return this.id(NSObject.class);
    }

    protected ID id(Class<? extends NSObject> type) {
        if(null == id) {
            id = this.proxy(type).id();
        }
        return id;
    }

    public void invalidate() {
        if(id != null) {
            NSNotificationCenter.defaultCenter().removeObserver(id);
        }
    }

    public void invoke(final Runnable runnable, final Object lock, final boolean wait) {
        if(NSThread.isMainThread()) {
            log.fine(String.format("Already on main thread. Invoke %s directly.", runnable));
            runnable.run();
            return;
        }
        synchronized(lock) {
            log.entering(getClass().getName(), String.format("Invoke runnable %s on main thread", runnable));
            try {
                //Defer to main thread
                Foundation.runOnMainThread(runnable, wait);
            }
            catch(Exception e) {
                log.log(Level.SEVERE, String.format("Exception %s running task on main thread", e.getMessage()), e);
            }
        }
    }
}