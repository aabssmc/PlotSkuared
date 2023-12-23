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

public class CondIsOwner extends Condition {

    static {
        Skript.registerCondition(CondIsOwner.class,
                "%player% (is|are) owner of %plot%",
                "%plot%'s owner (is|are) %player%",
                "%player% (is|are)( not|n't) owner of %plot%",
                "%plot%'s owner (is|are)( not|n't) %player%"
        );
    }

    boolean is;
    Expression<Plot> plot;
    Expression<Player> p;


    @Override
    public boolean check(@NotNull Event e) {
        if (is){
            return plot.getSingle(e).isOwnerAbs(p.getSingle(e).getUniqueId());
        }
        return !plot.getSingle(e).isOwnerAbs(p.getSingle(e).getUniqueId());
    }

    @Override
    public @NotNull String toString(@Nullable Event e, boolean debug) {
        return "player is owner";
    }

    @Override
    public boolean init(Expression<?> @NotNull [] exprs, int matchedPattern, @NotNull Kleenean isDelayed, SkriptParser.@NotNull ParseResult parseResult) {
        if (matchedPattern == 0){
            is = true;
            p = (Expression<Player>) exprs[0];
            plot = (Expression<Plot>) exprs[1];
        }
        else if (matchedPattern == 1){
            is = true;
            p = (Expression<Player>) exprs[1];
            plot = (Expression<Plot>) exprs[0];
        }
        else if (matchedPattern == 2){
            is = false;
            p = (Expression<Player>) exprs[0];
            plot = (Expression<Plot>) exprs[1];
        }
        else if (matchedPattern == 3){
            is = false;
            p = (Expression<Player>) exprs[1];
            plot = (Expression<Plot>) exprs[0];
        }
        return true;
    }
}
