package dev.tehbrian.tehlib.core.user;

import java.util.HashMap;
import java.util.Map;

/**
 * @param <I> the identifier type
 */
public abstract class OozerService<I, O extends Oozer<I>> {

    private final Map<I, O> oozerMap = new HashMap<>();

    /**
     * Gets the {@code Oozer} tied to that {@code id}. Creates a new
     * {@code Oozer} if an {@code Oozer}.
     *
     * @param id the identifier
     * @return the {@code Oozer}
     */
    public abstract O getOozer(final I id);

    /**
     * Gets a clone of the internal {@code Oozer} map.
     *
     * @return a clone of the map
     */
    public Map<I, O> getOozerMap() {
        return new HashMap<>(this.oozerMap);
    }

}
