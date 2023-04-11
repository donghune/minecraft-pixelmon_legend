package io.github.hoya.pixelmonlegend.utiliy

import io.github.hoya.pixelmonlegend.utiliy.entity.basicItemConfig
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor
import org.bukkit.entity.Player

class BasicItemCommand : TabExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {

        val player = sender as? Player?

        if (player == null) {
            sender.sendMessage("플레이어만 사용할 수 있습니다.")
            return false
        }

        if (basicItemConfig.isReceivePlayer(player.uniqueId)) {
            player.sendMessage("이미 지급받았습니다.")
            return false
        }

        player.inventory.addItem(*basicItemConfig.items.toTypedArray())
        player.sendMessage("아이템이 지급되었습니다.")
        return false
    }

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<String>): List<String> {
        return emptyList()
    }
}