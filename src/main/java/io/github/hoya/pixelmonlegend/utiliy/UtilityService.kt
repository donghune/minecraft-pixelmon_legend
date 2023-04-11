package io.github.hoya.pixelmonlegend.utiliy

import io.github.hoya.pixelmonlegend.util.BaseService
import org.bukkit.plugin.java.JavaPlugin

class UtilityService : BaseService {

    override fun onEnable(plugin: JavaPlugin) {
        plugin.getCommand("give-all").apply {
            val command = GiveAllCommand()
            executor = command
            tabCompleter = command
        }
        plugin.getCommand("torch").apply {
            val command = TorchCommand()
            executor = command
            tabCompleter = command
        }
        plugin.getCommand("basic-item").apply {
            val command = BasicItemCommand()
            executor = command
            tabCompleter = command
        }
    }

    override fun onDisable(plugin: JavaPlugin) {
        
    }
}