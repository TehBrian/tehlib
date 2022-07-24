package dev.tehbrian.tehlib.paper.user;

import dev.tehbrian.tehlib.core.user.AbstractUserService;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

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
  public @NonNull U getUser(final @NonNull Player player) {
    return this.getUser(player.getUniqueId());
  }

}
