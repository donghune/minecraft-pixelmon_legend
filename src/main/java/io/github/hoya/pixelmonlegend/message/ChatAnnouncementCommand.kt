package io.github.hoya.pixelmonlegend.message

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor

class ChatAnnouncementCommand : TabExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        Bukkit.getOnlinePlayers().forEach { player ->
            player.sendMessage("")
            player.sendMessage("[공지] ${args.joinToString(" ")}")
            player.sendMessage("")
        }
        return true
    }

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<String>): List<String> {
        return emptyList()
    }
}