package lol.aabss.plotskuared.events;

import com.plotsquared.core.events.PlayerAutoPlotEvent;
import com.plotsquared.core.events.PlayerClaimPlotEvent;
import com.plotsquared.core.events.Result;
import com.plotsquared.core.plot.Plot;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PlayerClaimPlotBukkit extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final Plot plot;
    private String schematic;
    private final PlayerClaimPlotEvent event;

    public PlayerClaimPlotBukkit(Player p, Plot plot, String schematic, PlayerClaimPlotEvent event) {
        this.player = p;
        this.plot = plot;
        this.schematic = schematic;
        this.event = event;
    }

    public Player getPlayer() {
        return player;
    }

    public Plot getPlot() {
        return plot;
    }

    public String getSchematic() {
        return schematic;
    }
    public void setSchematic(String schematic) {
        this.schematic = schematic;
        event.setSchematic(schematic);
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return event.getEventResult() == com.plotsquared.core.events.Result.DENY;
    }

    @Override
    public void setCancelled(boolean cancel) {
        event.setEventResult(cancel ? com.plotsquared.core.events.Result.DENY : com.plotsquared.core.events.Result.ACCEPT);
    }
}
