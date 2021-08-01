package dev.tehbrian.tehlib.paper.cloud;

import cloud.commandframework.CommandManager;
import cloud.commandframework.paper.PaperCommandManager;
import dev.tehbrian.tehlib.core.cloud.CloudService;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Manages a {@link CommandManager} instance.
 *
 * @param <S> the command sender type
 */
public class PaperCloudService<S> extends CloudService<S, PaperCommandManager<S>> {

    /**
     * Initializes {@link #commandManager}.
     */
    public void init() {

    }

}
