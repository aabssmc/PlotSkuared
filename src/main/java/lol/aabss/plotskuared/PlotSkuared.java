package lol.aabss.plotskuared;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import com.plotsquared.core.PlotAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.plotsquared.core.events.PlayerAutoPlotEvent;

import java.io.IOException;

public final class PlotSkuared extends JavaPlugin {

    public static PlotAPI api;
    public static String all_syntax;

    @Override
    public void onEnable() {
        api = new PlotAPI();
        all_syntax = "[(all [[of] the]|the)] ";
        PluginManager e = Bukkit.getPluginManager();
        try {
            if (e.getPlugin("PlotSquared") != null && e.getPlugin("Skript") != null){
                SkriptAddon addon = Skript.registerAddon(this)
                        .loadClasses("lol.aabss.plotskuared", "elements");
                Bukkit.getLogger().info("PlotSkuared loaded successfully!");
            }
            else{
                Bukkit.getLogger().severe("PlotSquared and/or Skript is not installed! Please install them.");
                e.disablePlugin(this);
            }

        } catch (IOException e3) {
            throw new RuntimeException(e3);
        }
    }
}
