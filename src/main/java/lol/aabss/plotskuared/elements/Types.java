package lol.aabss.plotskuared.elements;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.registrations.Classes;
import com.plotsquared.core.plot.Plot;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

public class Types {
    static{
        if (Bukkit.getServer().getPluginManager().getPlugin("PlotSquared") != null) {
            Classes.registerClass(new ClassInfo<>(Plot.class, "plot")
                    .user("plots?")
                    .name("Plot")
                    .description("Represents a PlotSquared plot.")
                    .since("1.9")
                    .parser(new Parser<Plot>() {

                        @Override
                        public @NotNull String toVariableNameString(Plot plot) {
                            return plot.getAlias();
                        }

                        @Override
                        public @NotNull String toString(Plot plot, int flags) {
                            return toVariableNameString(plot);
                        }
                    })
            );
        }
    }
}
