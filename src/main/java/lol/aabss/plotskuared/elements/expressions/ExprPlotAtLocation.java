package lol.aabss.plotskuared.elements.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import com.plotsquared.core.plot.Plot;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class ExprPlotAtLocation extends SimpleExpression<Plot> {

    static{
        Skript.registerExpression(ExprPlotAtLocation.class, Plot.class, ExpressionType.SIMPLE,
                "[the] plot at %location%"
        );
    }

    private Expression<Location> loc;

    @Override
    protected @Nullable Plot[] get(@NotNull Event e) {
        int x = (int) loc.getSingle(e).getX();
        int y = (int) loc.getSingle(e).getY();
        int z = (int) loc.getSingle(e).getZ();
        World world = loc.getSingle(e).getWorld();
        return new Plot[]{Plot.getPlot(com.plotsquared.core.location.Location.at(world.getName(), x, y, z))};
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public @NotNull Class<? extends Plot> getReturnType() {
        return Plot.class;
    }

    @Override
    public @NotNull String toString(@Nullable Event e, boolean debug) {
        return "plot at location";
    }

    @Override
    public boolean init(Expression<?> @NotNull [] exprs, int matchedPattern, @NotNull Kleenean isDelayed, SkriptParser.@NotNull ParseResult parseResult) {
        loc = (Expression<Location>) exprs[0];
        return true;
    }
}
