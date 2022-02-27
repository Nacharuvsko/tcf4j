package xyz.winston.tcf4j.commands;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.winston.tcf4j.commands.data.CommandExecutionContext;

/**
 * Shared interface of command class
 * @author winston
 */
public interface ICommand {

    /** Called on command execution */
    void execute(final @NotNull CommandExecutionContext ctx);

    /** Returns command information annotation */
    @Nullable Command commandInfo();

}
