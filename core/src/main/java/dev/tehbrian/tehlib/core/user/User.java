package dev.tehbrian.tehlib.core.user;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a user.
 *
 * @param <I> the identifier type
 */
public abstract class User<I> {

    /**
     * The unique identifier.
     */
    protected final @NonNull I id;

    /**
     * @param id the identifier
     */
    public User(final @NonNull I id) {
        this.id = id;
    }

    /**
     * Gets the unique identifier.
     *
     * @return the identifier
     */
    public @NonNull I id() {
        return id;
    }

}
