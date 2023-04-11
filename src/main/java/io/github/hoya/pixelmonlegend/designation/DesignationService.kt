package io.github.hoya.pixelmonlegend.designation

import io.github.hoya.pixelmonlegend.util.BaseService
import org.bukkit.plugin.java.JavaPlugin

class DesignationService : BaseService {

    override fun onEnable(plugin: JavaPlugin) {
        plugin.getCommand("designation").apply {
            val command = DesignationCommand()
            executor = command
            tabCompleter = command
        }
    }

    override fun onDisable(plugin: JavaPlugin) {
        
    }
}