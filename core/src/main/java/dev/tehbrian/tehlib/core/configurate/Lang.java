package dev.tehbrian.tehlib.core.configurate;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.configurate.NodePath;
import org.spongepowered.configurate.serialize.SerializationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Retrieves {@code String}s from a {@link ConfigurateWrapper}
 * and parses them using {@link MiniMessage}.
 *
 * @param <W> the wrapper type
 */
public abstract class Lang<W extends ConfigurateWrapper<?>> extends AbstractConfig<W> {

    /**
     * @param logger             the logger
     * @param configurateWrapper the wrapper
     */
    public Lang(
            final @NonNull Logger logger,
            final @NonNull W configurateWrapper
    ) {
        super(logger, configurateWrapper);
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
        return MiniMessage.get().parse(this.getAndVerifyString(path), replacements);
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
        return MiniMessage.get().parse(this.getAndVerifyString(path));
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
            components.add(MiniMessage.get().parse(string));
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
            components.add(MiniMessage.get().parse(string, replacements));
        }

        return components;
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
        final String rawValue = this.configurateWrapper.get().node(path).getString();

        if (rawValue == null) {
            this.logger.error("Attempted to get value from non-existent config path {}!", path);
            throw new IllegalArgumentException("No value found in the config for that given path.");
        }

        return rawValue;
    }

    /**
     * Gets the values for {@code path} from {@link #configurateWrapper}
     * and verifies that they are not null.
     *
     * @param path the path
     * @return the verified string
     * @throws IllegalArgumentException if there is no value found or if the value is not a list
     */
    private List<String> getAndVerifyStringList(final NodePath path) throws IllegalArgumentException {
        final List<String> rawValues;
        try {
            rawValues = this.configurateWrapper.get().node(path).getList(String.class);
        } catch (final SerializationException e) {
            this.logger.error("Attempted to get list of values from non-list config path {}!", path);
            throw new IllegalArgumentException("The given path is not a list.");
        }

        if (rawValues == null || rawValues.isEmpty()) {
            this.logger.error("Attempted to get list of values from non-existent config path {}!", path);
            throw new IllegalArgumentException("No values found in the config for that given path.");
        }

        return rawValues;
    }

    @Override
    public void load() {
        this.configurateWrapper.load();

        this.logger.info("Successfully loaded all values for {}!", this.configurateWrapper.filePath().getFileName());
    }

}
