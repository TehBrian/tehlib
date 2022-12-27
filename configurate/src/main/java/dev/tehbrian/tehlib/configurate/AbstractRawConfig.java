package dev.tehbrian.tehlib.configurate;

import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.ConfigurateException;

import java.util.Objects;

public abstract class AbstractRawConfig<W extends ConfigurateWrapper<?>>
    extends AbstractConfig<W> implements RawConfig {

  /**
   * @param configurateWrapper the wrapper
   */
  public AbstractRawConfig(final W configurateWrapper) {
    super(configurateWrapper);
  }

  /**
   * Loads the values from the {@link #configurateWrapper} into memory.
   *
   * @throws ConfigurateException if something goes wrong
   */
  @Override
  public void load() throws ConfigurateException {
    this.configurateWrapper.load();
  }

  /**
   * Gets the root node.
   *
   * @return the root node
   */
  public CommentedConfigurationNode rootNode() {
    return Objects.requireNonNull(this.configurateWrapper.get(), "Root node is null");
  }

}
