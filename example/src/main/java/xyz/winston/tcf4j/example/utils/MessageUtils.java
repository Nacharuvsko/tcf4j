package xyz.winston.tcf4j.example.utils;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

/**
 * Once-instantiable class for some basic stuff :)
 *
 * @author winston
 */
@RequiredArgsConstructor
public class MessageUtils {

    /** The reason, why it should be instantiated once in main class */
    private final TelegramLongPollingBot instance;

    /**
     * Sends a plain text message
     *
     * @param chatId        Chat ID
     * @param message       Plain-text message
     */
    public void sendMessage(
            final @NotNull String chatId,
            final @NotNull String message
    ) {
        val apiMethod = new SendMessage();
        apiMethod.setText(message);
        apiMethod.setChatId(chatId);

        try {
            instance.execute(apiMethod);
        } catch (final @NotNull Exception $) {
            $.printStackTrace();
        }
    }
}
