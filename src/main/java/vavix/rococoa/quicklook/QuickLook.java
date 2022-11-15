package vavix.rococoa.quicklook;

import java.nio.file.Path;
import java.util.List;

public interface QuickLook {

    /**
     * Does not open QuickLook panel but only changes the selection.
     *
     * @param files Display these files in QuickLook panel
     */
    void select(List<Path> files);

    /**
     * @return QuickLook panel is visible
     */
    boolean isOpen();

    /**
     * Open QuickLook panel
     */
    void open();

    /**
     * Close QuickLook panel if any
     */
    void close();
}