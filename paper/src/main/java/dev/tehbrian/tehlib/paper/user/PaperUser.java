package dev.tehbrian.tehlib.paper.user;

import dev.tehbrian.tehlib.core.user.AbstractUser;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

/**
 * Represents a user.
 */
public abstract class PaperUser extends AbstractUser<UUID> {

  /**
   * @param uuid the uuid
   */
  public PaperUser(final @NonNull UUID uuid) {
    super(uuid);
  }

}
