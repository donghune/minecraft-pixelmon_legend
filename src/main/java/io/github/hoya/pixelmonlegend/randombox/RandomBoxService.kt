package io.github.hoya.pixelmonlegend.randombox

import io.github.hoya.pixelmonlegend.util.BaseService
import org.bukkit.plugin.java.JavaPlugin

class RandomBoxService : BaseService {

    override fun onEnable(plugin: JavaPlugin) {
        plugin.getCommand("random-box").apply {
            val command = RandomBoxCommand()
            executor = command
            tabCompleter = command
        }
    }

    override fun onDisable(plugin: JavaPlugin) {
        TODO("Not yet implemented")
    }
}