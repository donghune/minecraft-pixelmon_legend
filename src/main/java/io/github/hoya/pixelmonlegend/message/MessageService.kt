package io.github.hoya.pixelmonlegend.message

import io.github.hoya.pixelmonlegend.message.scheduler.AnnouncementScheduler
import io.github.hoya.pixelmonlegend.util.BaseService
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class MessageService : BaseService {

    override fun onEnable(plugin: JavaPlugin) {
        plugin.getCommand("chat-announcement").apply {
            val command = ChatAnnouncementCommand()
            executor = command
            tabCompleter = command
        }

        Bukkit.getPluginManager().registerEvents(ChatRegionListener(), plugin)
        AnnouncementScheduler().start()
    }

    override fun onDisable(plugin: JavaPlugin) {

    }
}