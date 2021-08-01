package dev.tehbrian.tehlib.paper.user;

import dev.tehbrian.tehlib.core.user.User;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

/**
 * Represents a user.
 */
public abstract class PaperUser extends User<UUID> {

    /**
     * @param uuid the uuid
     */
    public PaperUser(final @NonNull UUID uuid) {
        super(uuid);
    }

}
