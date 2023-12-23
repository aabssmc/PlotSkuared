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

public class ExprAllPlayersInPlot extends SimpleExpression<Player> {

    static {
        Skript.registerExpression(ExprAllPlayersInPlot.class, Player.class, ExpressionType.COMBINED,
                all_syntax + "players in %plot%"
        );
    }

    private Expression<Plot> plot;

    @Override
    protected @Nullable Player[] get(@NotNull Event e) {
        return plot.getSingle(e).getPlayersInPlot().toArray(Player[]::new);
    }

    @Override
    public boolean isSingle() {
        return false;
    }

    @Override
    public @NotNull Class<? extends Player> getReturnType() {
        return Player.class;
    }

    @Override
    public @NotNull String toString(@Nullable Event e, boolean debug) {
        return "players in plot";
    }

    @Override
    public boolean init(Expression<?> @NotNull [] exprs, int matchedPattern, @NotNull Kleenean isDelayed, SkriptParser.@NotNull ParseResult parseResult) {
        plot = (Expression<Plot>) exprs[0];
        return true;
    }
}
