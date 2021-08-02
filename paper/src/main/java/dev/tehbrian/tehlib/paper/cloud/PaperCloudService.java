package dev.tehbrian.tehlib.paper.cloud;

import cloud.commandframework.CommandManager;
import cloud.commandframework.paper.PaperCommandManager;
import dev.tehbrian.tehlib.core.cloud.AbstractCloudService;

/**
 * Manages a {@link CommandManager} instance.
 *
 * @param <S> the command sender type
 */
public class PaperCloudService<S> extends AbstractCloudService<S, PaperCommandManager<S>> {

    /**
     * Initializes {@link #commandManager}.
     */
    public void init() {

    }

}
