package io.github.hoya.pixelmonlegend.economy.entity

import io.github.hoya.pixelmonlegend.util.manager.Config
import io.github.hoya.pixelmonlegend.util.manager.ConfigManager
import io.github.hoya.pixelmonlegend.util.setTag
import kotlinx.serialization.Serializable
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

val economyConfig by lazy { EconomyConfigManager.get() }

@Serializable
data class CheckData(
    val money: Int,
)

@Serializable
data class EconomyConfig(
    private val currency: String = "원",
    private val type: Material = Material.PAPER,
    private val title: String = "%money% 원",
    private val description: String = "우클릭 시 %money% 을 획득 할 수 있습니다.",
) : Config("economy") {
    fun createCheck(price: Int, amount: Int): ItemStack {
        val itemStack = ItemStack(type, amount)
        val itemMeta = itemStack.itemMeta
        itemMeta.displayName = title.replace("%money%", price.toString()).replace("%currency%", currency)
        itemMeta.lore = listOf(description.replace("%money%", price.toString()).replace("%currency%", currency))
        itemStack.itemMeta = itemMeta
        return itemStack.setTag(CheckData(price))
    }
}

object EconomyConfigManager : ConfigManager<EconomyConfig>(
    "economy",
    EconomyConfig.serializer(),
    EconomyConfig()
)