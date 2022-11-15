
package vavix.rococoa.quicklook;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


public class QuartzQuickLookTest {

    @Test
    public void testSelect() throws Exception {
        QuickLook q = new QuartzQuickLook();
        final List<Path> files = new ArrayList<>();
        files.add(Paths.get("f"));
        files.add(Paths.get("b"));
        q.select(files);
    }

    @Test
    @Disabled
    public void testSelect2() throws Exception {
        QuickLook q = new QuartzQuickLook();
        final List<Path> files = new ArrayList<>();
        files.add(Paths.get("f"));
        files.add(Paths.get("b"));
        q.select(files);
        q.open(); // TODO doesn't work
    }
}
