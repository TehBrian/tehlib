package dev.tehbrian.tehlib.core.configurate;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.ConfigurateException;

import java.util.Objects;

public abstract class AbstractDataConfig<W extends ConfigurateWrapper<?>, D> extends AbstractConfig<W> implements DataConfig<D> {

    protected @Nullable D data;

    /**
     * @param configurateWrapper the wrapper
     */
    public AbstractDataConfig(@NonNull final W configurateWrapper) {
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
        // will not be null as we called #load()
        final @NonNull CommentedConfigurationNode rootNode = Objects.requireNonNull(this.configurateWrapper.get());
        this.data = Objects.requireNonNull(rootNode.get(this.getDataClass()), "Deserialized data is null");
    }

    protected abstract Class<D> getDataClass();

    /**
     * Gets the data.
     *
     * @return the data
     */
    public @NonNull D data() {
        return Objects.requireNonNull(this.data, "Data is null");
    }

}
