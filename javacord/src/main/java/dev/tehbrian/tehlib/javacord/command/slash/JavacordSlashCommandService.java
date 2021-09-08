package dev.tehbrian.tehlib.javacord.command.slash;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Handles the creation and registration of slash commands.
 */
public class JavacordSlashCommandService {

    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Creates the slash commands.
     * <p>
     * <b>NOTE: This should only be used ONCE every so often, NOT on start-up!</b>
     *
     * @param slashCommands the slash commands
     */
    public void create(final List<JavacordSlashCommand> slashCommands) {
        for (final var command : slashCommands) {
            LOGGER.info("Creating Slash Command: " + command.getClass().getSimpleName());
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
            LOGGER.info("Registering Slash Command: " + command.getClass().getSimpleName());
            command.register();
        }
    }

}
