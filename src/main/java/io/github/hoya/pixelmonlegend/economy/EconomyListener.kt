package io.github.hoya.pixelmonlegend.economy

import io.github.hoya.pixelmonlegend.economy.extension.getCheckData
import io.github.hoya.pixelmonlegend.economy.extension.withdraw
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent

class EconomyListener : Listener {
    @EventHandler
    fun onPlayerInteractEvent(event: PlayerInteractEvent) {
        val player = event.player
        val itemStack = player.inventory.itemInMainHand
        val checkData = itemStack.getCheckData() ?: return

        itemStack.amount -= 1
        player.withdraw(checkData.money)
        player.sendMessage("수표를 사용하여 ${checkData.money} 만큼 획득 하였습니다.")
    }
}