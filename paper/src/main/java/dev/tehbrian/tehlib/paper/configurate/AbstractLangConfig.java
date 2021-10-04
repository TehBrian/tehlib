package dev.tehbrian.tehlib.paper.configurate;

import dev.tehbrian.tehlib.core.configurate.AbstractConfig;
import dev.tehbrian.tehlib.core.configurate.AbstractRawConfig;
import dev.tehbrian.tehlib.core.configurate.ConfigurateWrapper;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.Template;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.configurate.NodePath;
import org.spongepowered.configurate.serialize.SerializationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
     * @param path the config path
     * @return the component
     * @throws IllegalArgumentException if there is no value found
     */
    public Component c(final NodePath path) throws IllegalArgumentException {
        return MiniMessage.miniMessage().parse(this.getAndVerifyString(path));
    }

    /**
     * Gets the value for {@code path} from {@link #configurateWrapper}
     * and parses it using {@link MiniMessage}.
     * <p>
     * For each entry in {@code replacements}, any substring in the parsed
     * {@code String} matching the key surrounded with angled brackets, that is
     * to say {@code <key>}, is replaced with the corresponding value.
     *
     * @param path         the config path
     * @param replacements the replacements
     * @return the component
     * @throws IllegalArgumentException if there is no value found
     */
    public Component c(final NodePath path, final Map<String, String> replacements) throws IllegalArgumentException {
        return MiniMessage.miniMessage().parse(this.getAndVerifyString(path), replacements);
    }

    /**
     * Gets the value for {@code path} from {@link #configurateWrapper}
     * and parses it using {@link MiniMessage}.
     *
     * @param path      the config path
     * @param templates the templates
     * @return the component
     * @throws IllegalArgumentException if there is no value found
     */
    public Component c(final NodePath path, final List<Template> templates) throws IllegalArgumentException {
        return MiniMessage.miniMessage().parse(this.getAndVerifyString(path), templates);
    }

    /**
     * Gets the value for {@code path} from {@link #configurateWrapper}
     * and parses it using {@link MiniMessage}.
     *
     * @param path      the config path
     * @param templates the templates
     * @return the component
     * @throws IllegalArgumentException if there is no value found
     */
    public Component c(final NodePath path, final Template... templates) throws IllegalArgumentException {
        return this.c(path, Arrays.asList(templates));
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
        final List<Component> components = new ArrayList<>();

        for (final String string : this.getAndVerifyStringList(path)) {
            components.add(MiniMessage.miniMessage().parse(string));
        }

        return components;
    }

    /**
     * Gets the values for {@code path} from {@link #configurateWrapper}
     * and parses them using {@link MiniMessage}.
     * <p>
     * For each entry in {@code replacements}, any substring in the list of parsed
     * {@code String}s matching the key surrounded with angled brackets, that is
     * to say {@code <key>}, is replaced with the corresponding value.
     *
     * @param path         the config path
     * @param replacements the replacements
     * @return the components
     * @throws IllegalArgumentException if there is no value found or if the value is not a list
     */
    public List<Component> cl(final NodePath path, final Map<String, String> replacements) throws IllegalArgumentException {
        final List<Component> components = new ArrayList<>();

        for (final String string : this.getAndVerifyStringList(path)) {
            components.add(MiniMessage.miniMessage().parse(string, replacements));
        }

        return components;
    }

    /**
     * Gets the values for {@code path} from {@link #configurateWrapper}
     * and parses them using {@link MiniMessage}.
     *
     * @param path      the config path
     * @param templates the templates
     * @return the components
     * @throws IllegalArgumentException if there is no value found or if the value is not a list
     */
    public List<Component> cl(final NodePath path, final List<Template> templates) throws IllegalArgumentException {
        final List<Component> components = new ArrayList<>();

        for (final String string : this.getAndVerifyStringList(path)) {
            components.add(MiniMessage.miniMessage().parse(string, templates));
        }

        return components;
    }

    /**
     * Gets the values for {@code path} from {@link #configurateWrapper}
     * and parses them using {@link MiniMessage}.
     *
     * @param path      the config path
     * @param templates the templates
     * @return the components
     * @throws IllegalArgumentException if there is no value found or if the value is not a list
     */
    public List<Component> cl(final NodePath path, final Template... templates) throws IllegalArgumentException {
        return this.cl(path, Arrays.asList(templates));
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
