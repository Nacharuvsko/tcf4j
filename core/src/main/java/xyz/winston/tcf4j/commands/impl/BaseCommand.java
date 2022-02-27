package xyz.winston.tcf4j.commands.impl;

import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import xyz.winston.tcf4j.commands.AbstractCommand;
import xyz.winston.tcf4j.commands.data.CommandExecutionContext;

/**
 * @author winston
 */
public class BaseCommand extends AbstractCommand {

    protected final @NotNull TelegramLongPollingBot instance;

    public BaseCommand(final @NotNull TelegramLongPollingBot bot) {
        this.instance = bot;
    }

    @Override public void execute(final @NotNull CommandExecutionContext ctx) { }

}
