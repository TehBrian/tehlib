package dev.tehbrian.tehlib.core.configurate;

import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.configurate.CommentedConfigurationNode;

import java.util.Objects;

public abstract class AbstractRawConfig<W extends ConfigurateWrapper<?>> extends AbstractConfig<W> implements RawConfig {

    /**
     * @param logger             the logger
     * @param configurateWrapper the wrapper
     */
    public AbstractRawConfig(@NonNull final Logger logger, @NonNull final W configurateWrapper) {
        super(logger, configurateWrapper);
    }

    /**
     * Loads the values from the {@link #configurateWrapper} into memory.
     */
    @Override
    public void load() {
        this.configurateWrapper.load();

        this.logger.info("Successfully loaded configuration file {}", this.configurateWrapper.filePath().getFileName().toString());
    }

    /**
     * Gets the root node.
     *
     * @return the root node
     */
    public @NonNull CommentedConfigurationNode rootNode() {
        return Objects.requireNonNull(this.configurateWrapper.get(), "Tried to get root node but it was null");
    }

}
