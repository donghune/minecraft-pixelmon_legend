package io.github.hoya.pixelmonlegend.message.extension

import io.github.hoya.pixelmonlegend.message.entity.ChatRegion
import io.github.hoya.pixelmonlegend.message.entity.ChatRegionManager
import org.bukkit.entity.Player
import java.util.*
import kotlin.math.max
import kotlin.math.min

fun Player.getChatRegion(): ChatRegion? = ChatRegionManager.getList().find {
    val minX = min(it.pos1.x, it.pos2.x)
    val maxX = max(it.pos1.x, it.pos2.x)
    val minZ = min(it.pos1.z, it.pos2.z)
    val maxZ = max(it.pos1.z, it.pos2.z)
    player.location.x in minX..maxX && player.location.z in minZ..maxZ
}


private val uuidByChatMode = mutableMapOf<UUID, Boolean>()
var Player.isRegionChatMode: Boolean
    get() = uuidByChatMode.getOrDefault(uniqueId, false)
    set(value) {
        uuidByChatMode[uniqueId] = value
    }