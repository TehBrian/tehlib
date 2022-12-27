package dev.tehbrian.tehlib.paper.user;

import dev.tehbrian.tehlib.user.AbstractUserService;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Stores and retrieves user instances.
 *
 * @param <U> the user type
 */
public abstract class PaperUserService<U extends PaperUser> extends AbstractUserService<UUID, U> {

  /**
   * Gets the {@code User} associated with that {@code Player}'s {@code uuid}.
   *
   * @param player the player
   * @return the {@code User}
   */
  public U getUser(final Player player) {
    return this.getUser(player.getUniqueId());
  }

}
