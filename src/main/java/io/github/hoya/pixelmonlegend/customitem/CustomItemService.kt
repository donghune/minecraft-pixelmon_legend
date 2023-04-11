package io.github.hoya.pixelmonlegend.customitem

import io.github.hoya.pixelmonlegend.util.BaseService
import org.bukkit.plugin.java.JavaPlugin

class CustomItemService : BaseService {

    override fun onEnable(plugin: JavaPlugin) {
        plugin.getCommand("custom-item").apply {
            val command = CustomItemCommand()
            executor = command
            tabCompleter = command
        }
    }

    override fun onDisable(plugin: JavaPlugin) {
        
    }
}