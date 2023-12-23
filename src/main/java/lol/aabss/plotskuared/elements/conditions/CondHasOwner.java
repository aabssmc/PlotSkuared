package lol.aabss.plotskuared.elements.conditions;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import com.plotsquared.core.plot.Plot;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class CondHasOwner extends Condition {

    static {
        Skript.registerCondition(CondHasOwner.class,
                "%plot% has [a[n]] owner",
                "%plot% does( not|n't) have [a[n]] owner"
        );
    }

    boolean is;
    Expression<Plot> plot;


    @Override
    public boolean check(@NotNull Event e) {
        if (is){
            return plot.getSingle(e).hasOwner();
        }
        return !plot.getSingle(e).hasOwner();
    }

    @Override
    public @NotNull String toString(@Nullable Event e, boolean debug) {
        return "player has owner";
    }

    @Override
    public boolean init(Expression<?> @NotNull [] exprs, int matchedPattern, @NotNull Kleenean isDelayed, SkriptParser.@NotNull ParseResult parseResult) {
        plot = (Expression<Plot>) exprs[0];
        is = matchedPattern == 0;
        return true;
    }
}
