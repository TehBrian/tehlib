package dev.tehbrian.tehlib.core.configurate;

import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Loads and holds values from a {@link ConfigurateWrapper}.
 *
 * @param <W> the wrapper type
 */
public abstract class AbstractConfig<W extends ConfigurateWrapper<?>> {

    protected final @NonNull Logger logger;
    protected final @NonNull W configurateWrapper;

    /**
     * @param logger             the logger
     * @param configurateWrapper the wrapper
     */
    public AbstractConfig(final @NonNull Logger logger, final @NonNull W configurateWrapper) {
        this.logger = logger;
        this.configurateWrapper = configurateWrapper;
    }

    /**
     * Loads the values from the {@link #configurateWrapper} into memory.
     */
    public abstract void load();

}
