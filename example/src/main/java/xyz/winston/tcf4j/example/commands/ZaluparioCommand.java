package xyz.winston.tcf4j.example.commands;

import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import xyz.winston.tcf4j.commands.Command;
import xyz.winston.tcf4j.commands.data.CommandExecutionContext;
import xyz.winston.tcf4j.commands.impl.BaseCommand;
import xyz.winston.tcf4j.example.Bot;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Test command
 *
 * @author winston
 */
@Command(
        name = "zalupario",
        aliases = {"z1", "z2"}
)
public class ZaluparioCommand extends BaseCommand {

    /** Instance of bot */
    private final @NotNull Bot bot;

    public ZaluparioCommand(final @NotNull Bot bot) {
        super(bot);
        this.bot = bot;
    }

    @SneakyThrows
    @Override public void execute(final @NotNull CommandExecutionContext ctx) {
        val args = ctx.getArgs();
        val user = ctx.getUser();

        bot.getMessageUtils().sendMessage(
                ctx.getUpdate().getMessage().getChatId().toString(),
                "Hello, " + user.getFirstName() + "\n" +
                        "Arguments: " + String.join(", ", args) + "\n" +
                        "Used alias: " + ctx.getUsedAlias()
        );
    }
}
