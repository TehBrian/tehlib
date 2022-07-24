package dev.tehbrian.tehlib.paper.configurate;

import dev.tehbrian.tehlib.configurate.AbstractRawConfig;
import dev.tehbrian.tehlib.configurate.ConfigurateWrapper;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.configurate.NodePath;

/**
 * Retrieves {@code String}s from a {@link ConfigurateWrapper}
 * and parses them using {@link MiniMessage}.
 *
 * @param <W> the wrapper type
 */
public abstract class AbstractLangConfig<W extends ConfigurateWrapper<?>> extends AbstractRawConfig<W> {

  /**
   * @param configurateWrapper the wrapper
   */
  public AbstractLangConfig(
      final @NonNull W configurateWrapper
  ) {
    super(configurateWrapper);
  }

  /**
   * Gets the value for {@code path} from {@link #configurateWrapper}
   * and parses it using {@link MiniMessage}.
   *
   * @param path        the config path
   * @param tagResolver the tag resolver
   * @return the component
   * @throws NoSuchValueAtPathInConfigException if there is no value found at the specified path
   */
  public Component c(final NodePath path, final TagResolver tagResolver) throws NoSuchValueAtPathInConfigException {
    return MiniMessage.miniMessage().deserialize(this.getAndVerifyString(path), tagResolver);
  }

  /**
   * Gets the value for {@code path} from {@link #configurateWrapper}
   * and parses it using {@link MiniMessage}.
   *
   * @param path the config path
   * @return the component
   * @throws NoSuchValueAtPathInConfigException if there is no value found at the specified path
   */
  public Component c(final NodePath path) throws NoSuchValueAtPathInConfigException {
    return this.c(path, TagResolver.empty());
  }

  /**
   * Gets the value for {@code path} from {@link #configurateWrapper}
   * and verifies that it is not null.
   *
   * @param path the path
   * @return the verified string
   * @throws NoSuchValueAtPathInConfigException if there is no value found at the specified path
   */
  protected String getAndVerifyString(final NodePath path) throws NoSuchValueAtPathInConfigException {
    final String rawValue = this.rootNode().node(path).getString();

    if (rawValue == null) {
      throw new NoSuchValueAtPathInConfigException("Attempted to get value at path " + path + " in config "
          + configurateWrapper.filePath().getFileName() + " but found nothing.");
    }

    return rawValue;
  }

}
