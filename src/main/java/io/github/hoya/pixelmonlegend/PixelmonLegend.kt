package io.github.hoya.pixelmonlegend

import org.bukkit.plugin.java.JavaPlugin
import java.util.logging.Level

class PixelmonLegend : JavaPlugin() {
    override fun onEnable() {
        logger.log(Level.INFO, "On Enable!")
    }

    override fun onDisable() {
        logger.log(Level.INFO, "On Disable!")
    }
}