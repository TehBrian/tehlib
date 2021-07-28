package dev.tehbrian.tehlib.core.user;

/**
 * @param <I> the identifier type
 */
public abstract class Oozer<I> {

    /**
     * The unique identifier tied to this {@code Oozer}.
     */
    protected final I id;

    /**
     * @param id the identifier
     */
    public Oozer(final I id) {
        this.id = id;
    }

    /**
     * Gets the unique identifier tied to this {@code Oozer}.
     *
     * @return the identifier
     */
    public I id() {
        return id;
    }

}
