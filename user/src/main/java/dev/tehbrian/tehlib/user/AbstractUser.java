package dev.tehbrian.tehlib.user;

/**
 * Represents a user.
 *
 * @param <I> the identifier type
 */
public abstract class AbstractUser<I> {

  /**
   * The unique identifier.
   */
  protected final I uuid;

  /**
   * @param uuid the identifier
   */
  public AbstractUser(final I uuid) {
    this.uuid = uuid;
  }

  /**
   * Gets the unique identifier.
   *
   * @return the identifier
   */
  public I uuid() {
    return this.uuid;
  }

}
