package dev.tehbrian.tehlib.configurate;

import org.spongepowered.configurate.CommentedConfigurationNode;

public interface RawConfig extends Config {

  /**
   * Gets the root node.
   *
   * @return the root node
   */
  CommentedConfigurationNode rootNode();

}
