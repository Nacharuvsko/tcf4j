package xyz.winston.tcf4j;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import xyz.winston.tcf4j.commands.ICommand;
import xyz.winston.tcf4j.processor.UpdateCommandProcessor;

import java.util.Collection;
import java.util.HashSet;

/**
 * Main class of library.
 * Has to be instantiated in order to register commands.
 * @author winston
 */
public final class CommandLoader {

    /** Instance of active telegram bot */
    @Getter
    private final @NotNull LongPollingBot botInstance;

    /** Command execution prefix */
    @Getter
    private final @NotNull String prefix;

    /** Collection of loaded commands, that will be processed on invocation */
    @Getter
    private final @NotNull Collection<@NotNull ICommand> loadedCommands = new HashSet<>();

    /** Processor of incoming update callbacks */
    @Getter
    private final UpdateCommandProcessor commandProcessor;

    /** Main CommandLoader constructor */
    public CommandLoader(
            final @NotNull LongPollingBot telegramBot,
            final @NotNull String prefix
    ) {
        this.botInstance = telegramBot;
        this.prefix = prefix;
        this.commandProcessor = new UpdateCommandProcessor(this);
    }

    /**
     * This method should be invoked in {@link LongPollingBot#onUpdateReceived(Update)} method
     *
     * @param update        received update
     */
    public void onUpdate(final @NotNull Update update) {
        commandProcessor.processUpdate(update);
    }

    /**
     * Register a command
     *
     * @param command       command instance
     */
    public void registerCommand(final @NotNull ICommand command) {
        if (loadedCommands.contains(command)) throw new IllegalArgumentException("This command is already registered");
        loadedCommands.add(command);
    }
}
