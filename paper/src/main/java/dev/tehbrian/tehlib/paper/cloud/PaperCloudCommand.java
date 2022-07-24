package dev.tehbrian.tehlib.paper.cloud;

import cloud.commandframework.paper.PaperCommandManager;
import dev.tehbrian.tehlib.cloud.AbstractCloudCommand;

/**
 * A command that can be registered.
 *
 * @param <S> the command sender type
 */
public abstract class PaperCloudCommand<S> extends AbstractCloudCommand<S, PaperCommandManager<S>> {

}
