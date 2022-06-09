package dev.tehbrian.tehlib.javacord.command.slash;

import java.util.List;

/**
 * Handles the creation and registration of slash commands.
 */
public class JavacordSlashCommandService {

    /**
     * Creates the slash commands.
     * <p>
     * <b>NOTE: This should only be used ONCE every so often, NOT on start-up!</b>
     *
     * @param slashCommands the slash commands
     */
    public void create(final List<JavacordSlashCommand> slashCommands) {
        for (final var command : slashCommands) {
            command.create();
        }
    }

    /**
     * Registers the slash commands.
     *
     * @param slashCommands the slash commands
     */
    public void register(final List<JavacordSlashCommand> slashCommands) {
        for (final var command : slashCommands) {
            command.register();
        }
    }

}
