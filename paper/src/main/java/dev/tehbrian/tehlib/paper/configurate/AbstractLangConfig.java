package dev.tehbrian.tehlib.paper.configurate;

import dev.tehbrian.tehlib.core.configurate.AbstractRawConfig;
import dev.tehbrian.tehlib.core.configurate.ConfigurateWrapper;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.template.TemplateResolver;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.configurate.NodePath;
import org.spongepowered.configurate.serialize.SerializationException;

import java.util.ArrayList;
import java.util.List;

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
     * @param templateResolver the template resolver
     * @return the component
     * @throws IllegalArgumentException if there is no value found
     */
    public Component c(final NodePath path, final TemplateResolver templateResolver) throws IllegalArgumentException {
        return MiniMessage.miniMessage().deserialize(this.getAndVerifyString(path), templateResolver);
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
        return this.c(path, TemplateResolver.empty());
    }

    /**
     * Gets the values for {@code path} from {@link #configurateWrapper}
     * and parses them using {@link MiniMessage}.
     *
     * @param path             the config path
     * @param templateResolver the template resolver
     * @return the components
     * @throws IllegalArgumentException if there is no value found or if the value is not a list
     */
    public List<Component> cl(final NodePath path, final TemplateResolver templateResolver) throws IllegalArgumentException {
        final List<Component> components = new ArrayList<>();

        for (final String string : this.getAndVerifyStringList(path)) {
            components.add(MiniMessage.miniMessage().deserialize(string, templateResolver));
        }

        return components;
    }

    /**
     * Gets the values for {@code path} from {@link #configurateWrapper}
     * and parses them using {@link MiniMessage}.
     *
     * @param path the config path
     * @return the components
     * @throws IllegalArgumentException if there is no value found or if the value is not a list
     */
    public List<Component> cl(final NodePath path) throws IllegalArgumentException {
        return this.cl(path, TemplateResolver.empty());
    }

    /**
     * Gets the value for {@code path} from {@link #configurateWrapper}
     * and verifies that it is not null.
     *
     * @param path the path
     * @return the verified string
     * @throws IllegalArgumentException if there is no value found
     */
    private String getAndVerifyString(final NodePath path) throws IllegalArgumentException {
        final String rawValue = this.rootNode().node(path).getString();

        if (rawValue == null) {
            this.logger.error("Attempted to get value from non-existent config path {}", path);
            throw new IllegalArgumentException("No value found in the config for that given path.");
        }

        return rawValue;
    }

    /**
     * Gets the value for {@code path} from {@link #configurateWrapper}
     * and verifies it is not null.
     *
     * @param path the path
     * @return the verified string list
     * @throws IllegalArgumentException if there is no value found or if the value is not a list
     */
    private List<String> getAndVerifyStringList(final NodePath path) throws IllegalArgumentException {
        final List<String> rawValues;
        try {
            rawValues = this.rootNode().node(path).getList(String.class);
        } catch (final SerializationException e) {
            this.logger.error("Attempted to get list of values from non-list config path {}", path);
            throw new IllegalArgumentException("The given path is not a list.");
        }

        if (rawValues == null || rawValues.isEmpty()) {
            this.logger.error("Attempted to get list of values from non-existent config path {}", path);
            throw new IllegalArgumentException("No values found in the config for that given path.");
        }

        return rawValues;
    }

}
