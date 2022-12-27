package dev.tehbrian.tehlib.configurate;

import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.loader.ConfigurationLoader;

import java.nio.file.Path;

/**
 * Wraps around a {@link ConfigurationLoader} and provides methods for loading,
 * saving, and getting the root node.
 *
 * @param <L> the loader type
 */
public class ConfigurateWrapper<L extends ConfigurationLoader<CommentedConfigurationNode>> {

  private final Path filePath;
  private final @MonotonicNonNull L loader;

  private CommentedConfigurationNode rootNode;

  /**
   * @param filePath the file path for the config
   * @param loader   the loader
   */
  public ConfigurateWrapper(final Path filePath, final L loader) {
    this.filePath = filePath;
    this.loader = loader;
  }

  /**
   * Gets the root node. Will be null if {@link #load()} has not been called.
   *
   * @return the root node
   */
  public @Nullable CommentedConfigurationNode get() {
    return this.rootNode;
  }

  /**
   * Loads the root node from the file system.
   */
  public void load() throws ConfigurateException {
    this.rootNode = this.loader.load();
  }

  /**
   * Saves the root node to the file system.
   */
  public void save() throws ConfigurateException {
    this.loader.save(this.rootNode);
  }

  /**
   * Gets the file path that the loader will load from.
   *
   * @return the file path
   */
  public Path filePath() {
    return this.filePath;
  }

}
