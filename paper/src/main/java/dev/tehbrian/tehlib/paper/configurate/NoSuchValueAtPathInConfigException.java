package dev.tehbrian.tehlib.paper.configurate;

import java.io.Serial;

/**
 * Thrown to indicate that no value was found at the given path.
 */
public class NoSuchValueAtPathInConfigException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = -7199781355817557125L;

  /**
   * @param message the detail message
   */
  public NoSuchValueAtPathInConfigException(
      final String message
  ) {
    super(message);
  }

}
