package dev.tehbrian.tehlib.javacord.user;

import dev.tehbrian.tehlib.core.user.AbstractUser;

/**
 * Represents a user.
 */
public class JavacordUser extends AbstractUser<Long> {

    /**
     * @param discordId the discord id
     */
    public JavacordUser(final Long discordId) {
        super(discordId);
    }

}
