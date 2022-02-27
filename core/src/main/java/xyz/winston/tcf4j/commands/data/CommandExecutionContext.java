package xyz.winston.tcf4j.commands.data;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

/**
 * Data-class with some information about executed command
 *
 * @author winston
 */
@Getter
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
public final class CommandExecutionContext {

    /** Telegram {@link Update update} data */
    protected Update update;

    /** Which alias user issued */
    protected String usedAlias;

    /** Command arguments */
    protected String[] args;

    /** Issued user */
    protected User user;

}
