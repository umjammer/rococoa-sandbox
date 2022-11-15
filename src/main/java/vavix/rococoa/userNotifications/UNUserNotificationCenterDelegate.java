/*
 * Copyright (c) 2021 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavix.rococoa.userNotifications;

import com.sun.jna.Callback;


public interface UNUserNotificationCenterDelegate {
    void userNotificationCenter_didReceiveNotificationResponse_withCompletionHandler(UNUserNotificationCenter center,
            UNNotificationResponse response, Callback completionHandler);
    void userNotificationCenter_willPresentNotificatione_withCompletionHandler(UNUserNotificationCenter center,
            UNNotification notification, Callback completionHandler);
}

/* */
