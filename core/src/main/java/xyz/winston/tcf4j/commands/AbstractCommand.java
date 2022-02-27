package xyz.winston.tcf4j.commands;

import org.jetbrains.annotations.Nullable;

/**
 * Abstract realisation of {@link ICommand} interface
 * @author winston
 */
public abstract class AbstractCommand implements ICommand {

    /**
     * Basic overridden method of getting command information thru returning {@link Command} annotation
     */
    @Override public @Nullable Command commandInfo() {
        if (!getClass().isAnnotationPresent(Command.class)) {
            return null;
        }
        return getClass().getAnnotation(Command.class);
    }
}
