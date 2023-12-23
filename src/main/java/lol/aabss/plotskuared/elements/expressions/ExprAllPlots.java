package lol.aabss.plotskuared.elements.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import com.plotsquared.core.plot.Plot;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

import static lol.aabss.plotskuared.PlotSkuared.all_syntax;
import static lol.aabss.plotskuared.PlotSkuared.api;
import static lol.aabss.plotskuared.Util.p2plot;

public class ExprAllPlots extends SimpleExpression<Plot> {

    static{
        Skript.registerExpression(ExprAllPlots.class, Plot.class, ExpressionType.SIMPLE,
                all_syntax + "plots [owned by %-player%]",
                all_syntax + "%player%'s plots"
        );
    }

    private Expression<Player> p;

    @Override
    protected @Nullable Plot[] get(@NotNull Event e) {
        if (p != null){
            return api.getPlayerPlots(p2plot(p.getSingle(e))).toArray(Plot[]::new);
        }
        return api.getAllPlots().toArray(Plot[]::new);
    }

    @Override
    public boolean isSingle() {
        return false;
    }

    @Override
    public @NotNull Class<? extends Plot> getReturnType() {
        return Plot.class;
    }

    @Override
    public @NotNull String toString(@Nullable Event e, boolean debug) {
        return "all plots";
    }

    @Override
    public boolean init(Expression<?> @NotNull [] exprs, int matchedPattern, @NotNull Kleenean isDelayed, SkriptParser.@NotNull ParseResult parseResult) {
        p = (Expression<Player>) exprs[0];
        return true;
    }
}
