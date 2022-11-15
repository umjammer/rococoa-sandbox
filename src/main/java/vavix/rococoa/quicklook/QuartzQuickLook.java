package vavix.rococoa.quicklook;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.rococoa.ID;
import org.rococoa.cocoa.foundation.NSInteger;
import org.rococoa.cocoa.foundation.NSURL;

public final class QuartzQuickLook implements QuickLook {
    private static final Logger log = Logger.getLogger(QuartzQuickLook.class.getName());

    private final List<QLPreviewItem> previews
        = new ArrayList<QLPreviewItem>();

    @Override
    public void select(final List<Path> files) {
        log.fine(String.format("Select files for %s", files));
        previews.clear();
        for (final Path selected : files) {
            previews.add(new QLPreviewItem() {
                @Override
                public NSURL previewItemURL() {
                    return NSURL.fileURLWithPath(selected.toAbsolutePath().toString());
                }

                @Override
                public String previewItemTitle() {
                    return selected.getFileName().toString();
                }
            });
        }
    }

    private final QLPreviewPanelDataSource model = new QLPreviewPanelDataSource() {
        @Override
        public NSInteger numberOfPreviewItemsInPreviewPanel(QLPreviewPanel panel) {
            return new NSInteger(previews.size());
        }

        @Override
        public ID previewPanel_previewItemAtIndex(QLPreviewPanel panel, final int index) {
            return previews.get(index).id();
        }
    };

    @Override
    public boolean isOpen() {
        return QLPreviewPanel.sharedPreviewPanelExists()
            && QLPreviewPanel.sharedPreviewPanel().isVisible();
    }

    @Override
    public void open() {
        final QLPreviewPanel panel = QLPreviewPanel.sharedPreviewPanel();
        log.fine(String.format("Order front panel %s", panel));
        panel.makeKeyAndOrderFront(null);
        panel.setDataSource(model.id());
        log.fine(String.format("Reload data for panel %s", panel));
        panel.reloadData();
    }

    @Override
    public void close() {
        final QLPreviewPanel panel = QLPreviewPanel.sharedPreviewPanel();
        if(null != panel.currentController()) {
            log.fine(String.format("Order out panel %s", panel));
            panel.setDataSource(null);
            panel.orderOut(null);
        }
        log.fine("Clear previews");
        previews.clear();
    }
}