package io.github.hoya.pixelmonlegend.economy

import io.github.hoya.pixelmonlegend.util.BaseService
import org.bukkit.plugin.java.JavaPlugin

class EconomyService : BaseService {

    override fun onEnable(plugin: JavaPlugin) {
        plugin.getCommand("economy").apply {
            val command = EconomyCommand()
            executor = command
            tabCompleter = command
        }
    }

    override fun onDisable(plugin: JavaPlugin) {
        
    }
}