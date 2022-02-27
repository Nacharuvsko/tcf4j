package xyz.winston.tcf4j.commands;

import org.jetbrains.annotations.NotNull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Command annotation
 *
 * @author winston
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {

    @NotNull String name();

    @NotNull String[] aliases() default { };

}
