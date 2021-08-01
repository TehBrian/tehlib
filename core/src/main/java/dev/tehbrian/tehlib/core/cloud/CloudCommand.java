package dev.tehbrian.tehlib.core.cloud;

import cloud.commandframework.CommandManager;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * A command that can be registered.
 *
 * @param <S> the command sender type
 * @param <M> the command manager type
 */
public abstract class CloudCommand<S, M extends CommandManager<S>> {

    /**
     * Register the command.
     *
     * @param commandManager the command manager
     */
    public abstract void register(final @NonNull M commandManager);

}
