package vavix.rococoa.quicklook;

public interface Controller {

    /**
     * Run on main thread. Caller thread is blocked until the selector on the main thread is called.
     *
     * @param runnable The action to execute
     * @see #invoke(ch.cyberduck.core.threading.MainAction, boolean)
     */
    void invoke(MainAction runnable);
}