package io.github.hoya.pixelmonlegend.message

import io.github.hoya.pixelmonlegend.util.BaseService
import org.bukkit.plugin.java.JavaPlugin

class MessageService : BaseService {

    override fun onEnable(plugin: JavaPlugin) {
        plugin.getCommand("message").apply {
            val command = MessageCommand()
            executor = command
            tabCompleter = command
        }
    }

    override fun onDisable(plugin: JavaPlugin) {
        TODO("Not yet implemented")
    }
}