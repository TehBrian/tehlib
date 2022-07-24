package dev.tehbrian.tehlib.javacord.command.cloud;

import cloud.commandframework.CommandManager;
import cloud.commandframework.javacord.JavacordCommandManager;
import cloud.commandframework.javacord.sender.JavacordCommandSender;
import dev.tehbrian.tehlib.cloud.AbstractCloudService;

/**
 * Manages a {@link CommandManager} instance.
 */
public abstract class JavacordCloudService
    extends AbstractCloudService<JavacordCommandSender, JavacordCommandManager<JavacordCommandSender>> {

}
