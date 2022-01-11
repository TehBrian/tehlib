package dev.tehbrian.tehlib.paper.configurate;

import dev.tehbrian.tehlib.core.configurate.AbstractRawConfig;
import dev.tehbrian.tehlib.core.configurate.ConfigurateWrapper;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.placeholder.PlaceholderResolver;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.configurate.NodePath;

/**
 * Retrieves {@code String}s from a {@link ConfigurateWrapper}
 * and parses them using {@link MiniMessage}.
 *
 * @param <W> the wrapper type
 */
public abstract class AbstractLangConfig<W extends ConfigurateWrapper<?>> extends AbstractRawConfig<W> {

    private final Logger logger;

    /**
     * @param configurateWrapper the wrapper
     * @param logger             the logger
     */
    public AbstractLangConfig(
            final @NonNull W configurateWrapper,
            final @NonNull Logger logger
    ) {
        super(configurateWrapper);
        this.logger = logger;
    }

    /**
     * Gets the value for {@code path} from {@link #configurateWrapper}
     * and parses it using {@link MiniMessage}.
     *
     * @param path             the config path
     * @param placeholderResolver the placeholder resolver
     * @return the component
     * @throws IllegalArgumentException if there is no value found
     */
    public Component c(final NodePath path, final PlaceholderResolver placeholderResolver) throws IllegalArgumentException {
        return MiniMessage.miniMessage().deserialize(this.getAndVerifyString(path), placeholderResolver);
    }

    /**
     * Gets the value for {@code path} from {@link #configurateWrapper}
     * and parses it using {@link MiniMessage}.
     *
     * @param path the config path
     * @return the component
     * @throws IllegalArgumentException if there is no value found
     */
    public Component c(final NodePath path) throws IllegalArgumentException {
        return this.c(path, PlaceholderResolver.empty());
    }

    /**
     * Gets the value for {@code path} from {@link #configurateWrapper}
     * and verifies that it is not null.
     *
     * @param path the path
     * @return the verified string
     * @throws IllegalArgumentException if there is no value found
     */
    protected String getAndVerifyString(final NodePath path) throws IllegalArgumentException {
        final String rawValue = this.rootNode().node(path).getString();

        if (rawValue == null) {
            this.logger.error("Attempted to get value from non-existent config path {}", path);
            throw new IllegalArgumentException("No value found in the config for that given path.");
        }

        return rawValue;
    }

}
