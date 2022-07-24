package dev.tehbrian.tehlib.configurate;

import org.checkerframework.checker.nullness.qual.NonNull;

public interface DataConfig<D> {

  /**
   * Gets the data.
   *
   * @return the data
   */
  @NonNull D data();

}
