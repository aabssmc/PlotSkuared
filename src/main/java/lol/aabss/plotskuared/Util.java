package lol.aabss.plotskuared;

import com.plotsquared.core.PlotAPI;
import com.plotsquared.core.player.PlotPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static lol.aabss.plotskuared.PlotSkuared.api;

public class Util {
    public static PlotPlayer<?> p2plot(Player p){
        return api.wrapPlayer(p.getUniqueId());
    }

    public static Player plot2p(PlotPlayer<?> p){
        return Bukkit.getPlayer(p.getUUID());
    }
}
