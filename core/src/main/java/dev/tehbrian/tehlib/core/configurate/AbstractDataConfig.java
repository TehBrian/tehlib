package dev.tehbrian.tehlib.core.configurate;

import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.serialize.SerializationException;

import java.util.Objects;

public abstract class AbstractDataConfig<W extends ConfigurateWrapper<?>, D> extends AbstractConfig<W> implements DataConfig<D> {

    protected @Nullable D data;

    /**
     * @param logger             the logger
     * @param configurateWrapper the wrapper
     */
    public AbstractDataConfig(@NonNull final Logger logger, @NonNull final W configurateWrapper) {
        super(logger, configurateWrapper);
    }

    @Override
    public final void load() {
        this.configurateWrapper.load();
        final CommentedConfigurationNode rootNode = this.configurateWrapper.get();
        final String fileName = this.configurateWrapper.filePath().getFileName().toString();

        try {
            this.data = rootNode.get(this.getDataClass());
        } catch (final SerializationException e) {
            this.logger.warn("Exception caught during configuration deserialization for {}", fileName);
            this.logger.warn("Printing stack trace:", e);
            return;
        }

        if (this.data == null) {
            this.logger.warn("The deserialized configuration for {} was null.", fileName);
            return;
        }

        this.logger.info("Successfully loaded configuration file {}", fileName);
    }

    protected abstract Class<D> getDataClass();

    /**
     * Gets the data.
     *
     * @return the data
     */
    public @NonNull D data() {
        return Objects.requireNonNull(this.data, "Tried to get data but it was null");
    }

}
