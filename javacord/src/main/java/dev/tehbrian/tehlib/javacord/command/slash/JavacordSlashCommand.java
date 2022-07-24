package dev.tehbrian.tehlib.javacord.command.slash;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.javacord.api.DiscordApi;

/**
 * Contains methods for both creating and registering listeners for slash commands.
 */
public abstract class JavacordSlashCommand {

  protected final DiscordApi discordApi;

  /**
   * @param discordApi the discord api
   */
  public JavacordSlashCommand(final @NonNull DiscordApi discordApi) {
    this.discordApi = discordApi;
  }

  /**
   * Creates the slash command.
   *
   * <b>NOTE: This should only be used ONCE every so often, NOT on start-up!</b>
   */
  public abstract void create();

  /**
   * Registers the listeners for the slash command.
   */
  public abstract void register();

}
