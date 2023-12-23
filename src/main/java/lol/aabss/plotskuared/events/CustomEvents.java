package lol.aabss.plotskuared.events;

import com.google.common.eventbus.Subscribe;
import com.plotsquared.core.events.PlayerAutoPlotEvent;
import com.plotsquared.core.events.PlayerAutoPlotsChosenEvent;
import com.plotsquared.core.events.PlayerClaimPlotEvent;

import org.bukkit.Bukkit;

import static lol.aabss.plotskuared.PlotSkuared.api;
public class CustomEvents {

    public CustomEvents() {
        api.registerListener(this);
    }

    @Subscribe
    public void onPlayerAutoPlot(PlayerAutoPlotEvent e) {
        Bukkit.getServer().getPluginManager().callEvent(new PlayerAutoPlotBukkit(
                Bukkit.getPlayer(e.getPlayer().getUUID()), e.getPlot(), e)
        );
    }

    @Subscribe
    public void onPlayerAutoPlotsChosen(PlayerAutoPlotsChosenEvent e) {
        Bukkit.getServer().getPluginManager().callEvent(new PlayerAutoPlotsChosenBukkit(
                Bukkit.getPlayer(e.getPlotPlayer().getUUID()), e.getPlots(), e)
        );
    }

    @Subscribe
    public void onPlayerClaimPlot(PlayerClaimPlotEvent e) {
        Bukkit.getServer().getPluginManager().callEvent(new PlayerClaimPlotBukkit(
                Bukkit.getPlayer(e.getPlotPlayer().getUUID()), e.getPlot(), e.getSchematic(), e)
        );
    }

}
