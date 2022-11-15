/*
 * Copyright (c) 2022 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavix.rococoa.quicklook;


/**
 * QuickLookUILibrary.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (umjammer)
 * @version 0.00 2022/03/07 umjammer initial version <br>
 */
public interface QuickLookUILibrary extends com.sun.jna.Library {
    public static QuickLookUILibrary instance = com.sun.jna.Native.load("QuickLook", QuickLookUILibrary.class);
}

/* */
