package dev.tehbrian.tehlib.paper;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.io.File;
import java.util.Objects;

/**
 * Useful utility methods for the main plugin class. Extend as you would
 * normally would {@code JavaPlugin}.
 */
public abstract class TehPlugin extends JavaPlugin {

    /**
     * Registers listeners to this plugin.
     *
     * @param listeners the listeners
     */
    public void registerListeners(final @NonNull Listener... listeners) {
        final PluginManager manager = this.getServer().getPluginManager();

        for (final Listener listener : listeners) {
            manager.registerEvents(listener, this);
        }
    }

    /**
     * Checks whether the resource already exists before calling
     * {@link #saveResource(String, boolean)}.
     *
     * @param resourcePath the resource path
     */
    public void saveResourceSilently(final @NonNull String resourcePath) {
        final File outFile = new File(this.getDataFolder(), resourcePath);

        if (!outFile.exists()) {
            this.saveResource(resourcePath, false);
        }
    }

    /**
     * Disables this plugin.
     */
    public void disableSelf() {
        this.setEnabled(false);
    }

    /**
     * Registers a command to this plugin.
     *
     * @param name      the command name
     * @param executor  the command executor
     * @param completer the tab completer
     */
    public void registerCommand(
            final @NonNull String name,
            final @NonNull CommandExecutor executor,
            final @NonNull TabCompleter completer
    ) {
        final @NonNull PluginCommand command = Objects.requireNonNull(this.getCommand(name));
        command.setExecutor(executor);
        command.setTabCompleter(completer);
    }

    /**
     * Registers a command to this plugin with {@link EmptyTabCompleter}
     * as the tab completer.
     *
     * @param name     the command name
     * @param executor the command executor
     */
    public void registerCommand(
            final @NonNull String name,
            final @NonNull CommandExecutor executor
    ) {
        this.registerCommand(name, executor, new EmptyTabCompleter());
    }

}
