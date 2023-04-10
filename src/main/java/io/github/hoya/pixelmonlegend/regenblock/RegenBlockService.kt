package io.github.hoya.pixelmonlegend.regenblock

import io.github.hoya.pixelmonlegend.util.BaseService
import org.bukkit.plugin.java.JavaPlugin

class RegenBlockService : BaseService {

    override fun onEnable(plugin: JavaPlugin) {
        plugin.getCommand("regen-block").apply {
            val command = RegenBlockCommand()
            executor = command
            tabCompleter = command
        }
    }

    override fun onDisable(plugin: JavaPlugin) {
        TODO("Not yet implemented")
    }
}