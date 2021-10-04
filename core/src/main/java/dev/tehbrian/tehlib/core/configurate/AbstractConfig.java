package dev.tehbrian.tehlib.core.configurate;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.configurate.ConfigurateException;

/**
 * Loads and holds values from a {@link ConfigurateWrapper}.
 *
 * @param <W> the wrapper type
 */
public abstract class AbstractConfig<W extends ConfigurateWrapper<?>> {

    protected final @NonNull W configurateWrapper;

    /**
     * @param configurateWrapper the wrapper
     */
    public AbstractConfig(final @NonNull W configurateWrapper) {
        this.configurateWrapper = configurateWrapper;
    }

    /**
     * Loads the values from the {@link #configurateWrapper} into memory.
     *
     * @throws ConfigurateException if something goes wrong
     */
    public abstract void load() throws ConfigurateException;

    /**
     * Gets the underlying configurate wrapper.
     *
     * @return the configurate wrapper
     */
    public W configurateWrapper() {
        return this.configurateWrapper;
    }

}
