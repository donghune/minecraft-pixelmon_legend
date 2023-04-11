package io.github.hoya.pixelmonlegend.message

import io.github.hoya.pixelmonlegend.message.extension.getChatRegion
import io.github.hoya.pixelmonlegend.message.extension.isRegionChatMode
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

class ChatRegionListener : Listener {
    @EventHandler
    fun onAsyncPlayerChatEvent(event: AsyncPlayerChatEvent) {
        if (event.player.isOp) {
            return
        }

        event.isCancelled = true
        val chatRegion = event.player.getChatRegion()

        // 지역책을 활성화 시키지 않은 사람들 과 같은 지역의 사람들에게 보여줘야함
        Bukkit.getOnlinePlayers()
            .filter { player -> player.getChatRegion() == chatRegion || !player.isRegionChatMode }
            .forEach { player -> player.sendMessage(event.message) }
    }
}