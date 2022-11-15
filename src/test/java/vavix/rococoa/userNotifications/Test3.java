/*
 * Copyright (c) 2021 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavix.rococoa.userNotifications;

import com.sun.jna.Callback;
import vavi.util.Debug;


/**
 * NSNotification
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (umjammer)
 * @version 0.00 2021/10/30 umjammer initial version <br>
 */
public class Test3 {

    public static void main(String[] args) throws Exception {
        UNUserNotificationCenter notificationCenter = UNUserNotificationCenter.current();
        notificationCenter.setDelegate(new UNUserNotificationCenterDelegate() {
            @Override
            public void userNotificationCenter_didReceiveNotificationResponse_withCompletionHandler(UNUserNotificationCenter center,
                                                                                                    UNNotificationResponse response,
                                                                                                    Callback completionHandler) {
Debug.println("userNotificationCenter_didReceiveNotificationResponse_withCompletionHandler");
            }

            @Override
            public void userNotificationCenter_willPresentNotificatione_withCompletionHandler(UNUserNotificationCenter center,
                                                                                              UNNotification notification,
                                                                                              Callback completionHandler) {
Debug.println("userNotificationCenter_willPresentNotificatione_withCompletionHandler");
            }
        });

        UNNotification notification = UNNotification.newInstance();

Debug.println("done");
    }
}

/* */
