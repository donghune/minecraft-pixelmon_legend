package io.github.hoya.pixelmonlegend.economy

import io.github.hoya.pixelmonlegend.economy.entity.economyConfig
import io.github.hoya.pixelmonlegend.economy.extension.deposit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor
import org.bukkit.entity.Player

class EconomyCommand : TabExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        val player = sender as? Player

        if (player == null) {
            sender.sendMessage("플레이어만 사용 가능한 명령어입니다.")
            return false
        }

        if (args.isEmpty()) {
            sender.sendMessage("Usage: /economy <price> [amount]")
            return false
        }

        val price = args[0].toIntOrNull()

        if (price == null || price <= 0) {
            sender.sendMessage("Usage: /economy <price> [amount]")
            return false
        }

        val amount = args[1].toIntOrNull() ?: 1

        val checkItem = economyConfig.createCheck(price, amount)

        player.deposit(price)
        player.inventory.addItem(checkItem)
        player.sendMessage("수표를 발행하였습니다.")

        return false
    }

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<String>): List<String> {
        return emptyList()
    }
}