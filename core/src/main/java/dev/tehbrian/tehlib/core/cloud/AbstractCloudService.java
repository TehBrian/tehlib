package dev.tehbrian.tehlib.core.cloud;

import cloud.commandframework.CommandManager;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Manages a {@link CommandManager} instance.
 *
 * @param <S> the command sender type
 * @param <M> the command manager type
 */
public abstract class AbstractCloudService<S, M extends CommandManager<S>> {

    /**
     * The internal {@link CommandManager}.
     */
    protected @Nullable M commandManager;

    /**
     * Initializes {@link #commandManager}.
     */
    public abstract void init();

    /**
     * Gets the internal {@code CommandManager}.
     *
     * @return the command manager
     */
    public @Nullable M get() {
        return this.commandManager;
    }

}
