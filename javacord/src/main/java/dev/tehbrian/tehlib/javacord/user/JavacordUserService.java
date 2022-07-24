package dev.tehbrian.tehlib.javacord.user;

import dev.tehbrian.tehlib.core.user.AbstractUserService;

/**
 * Stores and retrieves user instances.
 *
 * @param <U> the user type
 */
public abstract class JavacordUserService<U extends JavacordUser> extends AbstractUserService<Long, U> {

  /**
   * Gets the {@code User} associated with that {@code User}'s id.
   *
   * @param user the discord user
   * @return the {@code User}
   */
  public U getUser(final org.javacord.api.entity.user.User user) {
    return this.getUser(user.getId());
  }

}
