package dev.tehbrian.tehlib.cloud;

import cloud.commandframework.CommandManager;

/**
 * A command that can be registered.
 *
 * @param <S> the command sender type
 * @param <M> the command manager type
 */
public abstract class AbstractCloudCommand<S, M extends CommandManager<S>> {

  /**
   * Register the command.
   *
   * @param commandManager the command manager
   */
  public abstract void register(M commandManager);

}
