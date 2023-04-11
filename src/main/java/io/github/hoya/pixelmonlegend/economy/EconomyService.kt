package io.github.hoya.pixelmonlegend.economy

import io.github.hoya.pixelmonlegend.util.BaseService
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class EconomyService : BaseService {

    override fun onEnable(plugin: JavaPlugin) {
        plugin.getCommand("economy").apply {
            val command = EconomyCommand()
            executor = command
            tabCompleter = command
        }

        Bukkit.getPluginManager().registerEvents(EconomyListener(), plugin)
    }

    override fun onDisable(plugin: JavaPlugin) {

    }
}