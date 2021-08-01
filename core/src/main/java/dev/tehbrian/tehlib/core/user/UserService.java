package dev.tehbrian.tehlib.core.user;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores and retrieves {@link User} instances.
 *
 * @param <I> the identifier type
 * @param <U> the user type
 */
public abstract class UserService<I, U extends User<I>> {

    protected final @NonNull Map<@NonNull I, @NonNull U> userMap = new HashMap<>();

    /**
     * Gets the {@code User} associated with that {@code id}.
     *
     * @param id the identifier
     * @return the {@code User}
     */
    public abstract @NonNull U getUser(final @NonNull I id);

    /**
     * Gets a clone of the internal {@code User} map.
     *
     * @return a clone of the map
     */
    public @NonNull Map<@NonNull I, @NonNull U> getUserMap() {
        return new HashMap<>(this.userMap);
    }

}
