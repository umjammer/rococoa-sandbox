package vavix.rococoa.quicklook;

public abstract class AbstractController implements Controller {

    /**
     * Does wait for main action to return before continuing the caller thread.
     *
     * @param runnable The action to execute
     */
    @Override
    public void invoke(final MainAction runnable) {
        this.invoke(runnable, false);
    }

    /**
     * main action to return before continuing the caller thread.
     *
     * @param runnable The action to execute
     */
    public abstract void invoke(final MainAction runnable, boolean wait);
}