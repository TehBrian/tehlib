package dev.tehbrian.tehlib.core.user;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a user.
 *
 * @param <I> the identifier type
 */
public abstract class AbstractUser<I> {

  /**
   * The unique identifier.
   */
  protected final @NonNull I uuid;

  /**
   * @param uuid the identifier
   */
  public AbstractUser(final @NonNull I uuid) {
    this.uuid = uuid;
  }

  /**
   * Gets the unique identifier.
   *
   * @return the identifier
   */
  public @NonNull I uuid() {
    return this.uuid;
  }

}
