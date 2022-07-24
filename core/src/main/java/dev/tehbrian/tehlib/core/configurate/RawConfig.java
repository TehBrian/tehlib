package dev.tehbrian.tehlib.core.configurate;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.configurate.CommentedConfigurationNode;

public interface RawConfig {

  /**
   * Gets the root node.
   *
   * @return the root node
   */
  @NonNull CommentedConfigurationNode rootNode();

}
