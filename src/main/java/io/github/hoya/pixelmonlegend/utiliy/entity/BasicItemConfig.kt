package io.github.hoya.pixelmonlegend.utiliy.entity

import io.github.hoya.pixelmonlegend.util.manager.Config
import io.github.hoya.pixelmonlegend.util.manager.ConfigManager
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.bukkit.inventory.ItemStack
import java.util.*

val basicItemConfig = BasicItemConfigManager.get()

@Serializable
data class BasicItemConfig(
    val items: List<@Contextual ItemStack> = emptyList(),
    private val receivePlayers: List<@Contextual UUID> = emptyList(),
) : Config("basic_item") {
    fun isReceivePlayer(uuid: UUID) = receivePlayers.contains(uuid)
}

object BasicItemConfigManager : ConfigManager<BasicItemConfig>(
    "basic_item",
    BasicItemConfig.serializer(),
    BasicItemConfig()
)