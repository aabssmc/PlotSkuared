package lol.aabss.plotskuared.events;

import com.plotsquared.core.events.PlayerAutoPlotEvent;
import com.plotsquared.core.events.PlayerAutoPlotsChosenEvent;
import com.plotsquared.core.events.Result;
import com.plotsquared.core.plot.Plot;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PlayerAutoPlotsChosenBukkit extends Event {

    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final List<Plot> plot;
    private final PlayerAutoPlotsChosenEvent event;

    public PlayerAutoPlotsChosenBukkit(Player p, List<Plot> plot, PlayerAutoPlotsChosenEvent event) {
        this.player = p;
        this.plot = plot;
        this.event = event;
    }

    public Player getPlayer() {
        return player;
    }

    public List<Plot> getPlot() {
        return plot;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

}
