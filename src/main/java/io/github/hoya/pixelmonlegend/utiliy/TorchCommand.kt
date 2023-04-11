package io.github.hoya.pixelmonlegend.utiliy

import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class TorchCommand : TabExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {

        val player = sender as? Player?

        if (player == null) {
            sender.sendMessage("플레이어만 사용할 수 있습니다.")
            return false
        }

        player.inventory.addItem(ItemStack(Material.TORCH))
        player.sendMessage("토치가 지급되었습니다.")
        return false
    }

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<String>): List<String> {
        return emptyList()
    }
}