package dev.tehbrian.tehlib.paper.cloud;

import cloud.commandframework.CommandManager;
import cloud.commandframework.paper.PaperCommandManager;
import dev.tehbrian.tehlib.cloud.AbstractCloudService;

/**
 * Manages a {@link CommandManager} instance.
 *
 * @param <S> the command sender type
 */
public abstract class PaperCloudService<S> extends AbstractCloudService<S, PaperCommandManager<S>> {

}
