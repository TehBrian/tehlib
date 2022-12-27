package dev.tehbrian.tehlib.user;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores and retrieves user instances.
 *
 * @param <I> the identifier type
 * @param <U> the user type
 */
public abstract class AbstractUserService<I, U extends AbstractUser<I>> {

  @SuppressWarnings("CanBeFinal") // some programs may need to change the user map
  protected Map<I, U> userMap = new HashMap<>();

  /**
   * Gets the {@code User} associated with that {@code uuid}.
   *
   * @param uuid the identifier
   * @return the {@code User}
   */
  public abstract U getUser(I uuid);

  /**
   * Gets a clone of the internal {@code User} map.
   *
   * @return a clone of the map
   */
  public Map<I, U> getUserMap() {
    return new HashMap<>(this.userMap);
  }

}
