package vavix.rococoa.userNotifications;


import org.rococoa.ObjCClass;
import org.rococoa.cocoa.foundation.NSObject;


public abstract class UNNotification extends NSObject {

    private static final _Class CLASS = org.rococoa.Rococoa.createClass("UNNotification", _Class.class);

    public interface _Class extends ObjCClass {
        UNNotification alloc();
    }

    public abstract UNNotification init();

    public static UNNotification newInstance() {
        UNNotification notification = CLASS.alloc();
        notification.init();
        return notification;
    }
}