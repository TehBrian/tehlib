package dev.tehbrian.tehlib.core.configurate;

import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.loader.ConfigurationLoader;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Wraps around a {@link ConfigurationLoader} and provides methods for loading,
 * saving, and getting the root node.
 *
 * @param <L> the loader type
 */
public class ConfigurateWrapper<L extends ConfigurationLoader<CommentedConfigurationNode>> {

    private final Logger logger;
    private final Path filePath;
    private final L loader;

    private CommentedConfigurationNode rootNode;

    /**
     * @param logger   the logger
     * @param filePath the file path for the config
     * @param loader   the loader
     */
    public ConfigurateWrapper(
            final @NonNull Logger logger,
            final @NonNull Path filePath,
            final @NonNull L loader
    ) {
        this.logger = logger;
        this.filePath = filePath;
        this.loader = loader;
    }

    /**
     * Gets the root node. Loads it if not already loaded.
     *
     * @return the root node
     */
    public @NonNull CommentedConfigurationNode get() {
        if (this.rootNode == null) {
            this.load();
        }
        return this.rootNode;
    }

    /**
     * Loads the root node from the file system.
     */
    public void load() {
        try {
            this.rootNode = this.loader.load();
        } catch (final IOException e) {
            this.logger.error("Unable to load the configuration file {}!", this.filePath.getName(-1));
            this.logger.error("Exception: ", e);
        }
    }

    /**
     * Saves the root node to the file system.
     */
    public void save() {
        try {
            this.loader.save(this.rootNode);
        } catch (final ConfigurateException e) {
            this.logger.error("Unable to save the configuration file {}!", this.filePath.getName(-1));
            this.logger.error("Exception: ", e);
        }
    }

    /**
     * Gets the file path that the loader will load from.
     *
     * @return the file path
     */
    public @NonNull Path filePath() {
        return this.filePath;
    }

}
