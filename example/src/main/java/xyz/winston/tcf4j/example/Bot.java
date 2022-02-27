package xyz.winston.tcf4j.example;

import lombok.Getter;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import xyz.winston.tcf4j.CommandLoader;
import xyz.winston.tcf4j.example.commands.ZaluparioCommand;

import org.jetbrains.annotations.NotNull;
import xyz.winston.tcf4j.example.utils.MessageUtils;

public final class Bot extends TelegramLongPollingBot {

    private final CommandLoader commandLoader;

    @Getter
    private final MessageUtils messageUtils;

    public Bot() {
        messageUtils = new MessageUtils(this);

        commandLoader = new CommandLoader(this, "/");
        commandLoader.registerCommand(new ZaluparioCommand(this));
    }

    @Override public String getBotUsername() {
        return "pkghV2_bot";
    }

    @Override public String getBotToken() {
        return "2090822009:AAEF6hoLO6sdrHW6CuMMIh1czaGC10R35z8";
        //
    }

    @Override public void onUpdateReceived(final @NotNull Update update) {
        commandLoader.onUpdate(update);
    }
}
