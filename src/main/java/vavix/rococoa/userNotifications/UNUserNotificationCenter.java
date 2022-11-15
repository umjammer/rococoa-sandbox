package vavix.rococoa.userNotifications;


import org.rococoa.ID;
import org.rococoa.ObjCClass;
import org.rococoa.ObjCObject;
import org.rococoa.Rococoa;
import org.rococoa.cocoa.foundation.NSObject;


public abstract class UNUserNotificationCenter extends NSObject {

    private static final _Class CLASS = org.rococoa.Rococoa.createClass("UNUserNotificationCenter", _Class.class);

    public interface _Class extends ObjCClass {
        UNUserNotificationCenter defaultUserNotificationCenter();
    }

    public static UNUserNotificationCenter current() {
        return CLASS.defaultUserNotificationCenter();
    }

    /** UNUserNotificationCenterDelegate */
    public abstract void setDelegate(ID delegate);

    private ObjCObject delegateProxy = null;
    private UNUserNotificationCenterDelegate delegate = null;

    /** Set the delegate that will receive events when speech is generated.
     *  @param delegate the delegate to set, replacing any existing one
     */
    public synchronized void setDelegate(UNUserNotificationCenterDelegate delegate) {
        if ( delegate != null ) {
            this.delegate = delegate;
            delegateProxy = Rococoa.proxy(delegate);
            setDelegate(this.delegateProxy.id());
        }
    }

    public abstract ID delegate();
}