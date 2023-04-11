package io.github.hoya.pixelmonlegend.utiliy

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor
import org.bukkit.entity.Player

class GiveAllCommand : TabExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {

        val player = sender as? Player?

        if (player == null) {
            sender.sendMessage("플레이어만 사용할 수 있습니다.")
            return false
        }

        if (!player.isOp) {
            player.sendMessage("권한이 없습니다.")
            return false
        }

        val itemStack = player.inventory.itemInMainHand

        if (itemStack == null || itemStack.type == Material.AIR) {
            player.sendMessage("손에 아이템을 들고 사용해주세요.")
            return false
        }

        Bukkit.getOnlinePlayers().forEach {
            it.inventory.addItem(itemStack)
            it.sendMessage("아이템이 지급되었습니다.")
        }
        player.sendMessage("모든 플레이어에게 손에 든 아이템을 지급하였습니다.")
        return false
    }

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<String>): List<String> {
        return emptyList()
    }
}