package io.github.hoya.pixelmonlegend.utiliy

import io.github.hoya.pixelmonlegend.util.BaseService
import org.bukkit.plugin.java.JavaPlugin

class UtilityService : BaseService {

    override fun onEnable(plugin: JavaPlugin) {
        plugin.getCommand("utility").apply {
            val command = UtilityCommand()
            executor = command
            tabCompleter = command
        }
    }

    override fun onDisable(plugin: JavaPlugin) {
        TODO("Not yet implemented")
    }
}