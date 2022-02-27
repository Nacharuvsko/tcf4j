package xyz.winston.tcf4j.processor;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.objects.Update;
import xyz.winston.tcf4j.CommandLoader;
import xyz.winston.tcf4j.commands.data.CommandExecutionContext;

/**
 * Here, all the commands are being processed
 * @author winston
 */
@RequiredArgsConstructor
public final class UpdateCommandProcessor {

    /** CommandLoader instance */
    private final CommandLoader commandLoader;

    /**
     * Basically, just processing update
     */
    public void processUpdate(final @NotNull Update update) {

        if (!update.hasMessage()) return;
        if (update.getEditedMessage() != null) return; // $$$ SUPERIOR CHECKS BY WINSTON1337 AKA TOMSKIY.xyz $$$

        val message = update.getMessage().getText();

        var comps = message.split(" ");

        if (!message.startsWith(commandLoader.getPrefix())) return;

        comps[0] = comps[0].replaceFirst(commandLoader.getPrefix(), "");

        for (val $ : commandLoader.getLoadedCommands()) {
            val commandInfo = $.commandInfo();

            if (commandInfo == null) continue; // if some irregular shit happens

            if (!(ArrayUtils.contains(commandInfo.aliases(), comps[0]))
                    && !(commandInfo.name().equalsIgnoreCase(comps[0]))) continue;

            val usedAlias = comps[0];
            comps = ArrayUtils.remove(comps, 0); // removing used alias
            val args = comps;

            $.execute(new CommandExecutionContext(
                    update,
                    usedAlias,
                    args,
                    update.getMessage().getFrom()
            ));
        }
    }
}
