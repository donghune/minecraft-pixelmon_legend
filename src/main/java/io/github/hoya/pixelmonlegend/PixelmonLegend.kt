package io.github.hoya.pixelmonlegend

import io.github.hoya.pixelmonlegend.customitem.CustomItemService
import io.github.hoya.pixelmonlegend.designation.DesignationService
import io.github.hoya.pixelmonlegend.economy.EconomyService
import io.github.hoya.pixelmonlegend.message.MessageService
import io.github.hoya.pixelmonlegend.randombox.RandomBoxService
import io.github.hoya.pixelmonlegend.regenblock.RegenBlockService
import io.github.hoya.pixelmonlegend.utiliy.UtilityService
import net.milkbowl.vault.economy.Economy
import org.bukkit.plugin.java.JavaPlugin
import java.util.logging.Level


class PixelmonLegend : JavaPlugin() {

    companion object {
        lateinit var instance: PixelmonLegend
            private set
    }

    lateinit var economy: Economy
        private set

    private val services = listOf(
        MessageService(),
        EconomyService(),
        CustomItemService(),
        DesignationService(),
        RandomBoxService(),
        RegenBlockService(),
        UtilityService(),
    )

    override fun onEnable() {
        logger.log(Level.INFO, "On Enable!")
        instance = this
        setupEconomy()
        services.forEach { it.onEnable(this@PixelmonLegend) }
    }

    override fun onDisable() {
        logger.log(Level.INFO, "On Disable!")
        services.forEach { it.onDisable(this@PixelmonLegend) }
    }

    private fun setupEconomy(): Boolean {
        if (server.pluginManager.getPlugin("Vault") == null) {
            return false
        }
        val rsp = server.servicesManager.getRegistration(Economy::class.java) ?: return false
        economy = rsp.provider
        return true
    }
}