package vavix.rococoa.quicklook;

import org.rococoa.cocoa.foundation.NSURL;

public abstract class QLPreviewItem extends ProxyController {

    public abstract NSURL previewItemURL();

    /*!
    * @abstract The item's title this will be used as apparent item title.
    * @discussion The title replaces the default item display name. This property is optional.
    */
    public abstract String previewItemTitle();
}