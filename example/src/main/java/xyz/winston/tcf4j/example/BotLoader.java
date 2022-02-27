package xyz.winston.tcf4j.example;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * Loader class for {@link Bot}
 *
 * @author winston
 */
public final class BotLoader {

    /** Global API instance */
    private final @NotNull TelegramBotsApi api;

    @SneakyThrows(TelegramApiException.class)
    public BotLoader() {
        api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(new Bot());
    }

    public static void main(final String @NotNull [] arg) {
        new BotLoader();
    }

}
