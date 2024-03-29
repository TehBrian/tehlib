package dev.tehbrian.tehlib.configurate;

import org.spongepowered.configurate.ConfigurateException;

/**
 * Loads and holds values from a {@link ConfigurateWrapper}.
 */
public interface Config {

  /**
   * Loads the values into memory.
   *
   * @throws ConfigurateException if something goes wrong
   */
  void load() throws ConfigurateException;

  /**
   * Gets the underlying configurate wrapper.
   *
   * @return the configurate wrapper
   */
  ConfigurateWrapper<?> configurateWrapper();

}
