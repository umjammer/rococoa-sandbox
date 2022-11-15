package vavix.rococoa.userNotifications;


import org.rococoa.ObjCClass;
import org.rococoa.cocoa.foundation.NSObject;


public abstract class UNNotificationResponse extends NSObject {

    @SuppressWarnings("hiding")
    private static final _Class CLASS = org.rococoa.Rococoa.createClass("UNNotificationResponse", _Class.class);

    public interface _Class extends ObjCClass {
        UNNotificationResponse alloc();
    }

    public abstract UNNotificationResponse init();

    public static UNNotificationResponse newInstance() {
        UNNotificationResponse response = CLASS.alloc();
        response.init();
        return response;
    }
}