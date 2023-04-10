package io.github.hoya.pixelmonlegend.util

import org.bukkit.plugin.java.JavaPlugin

interface BaseService {
    fun onEnable(plugin: JavaPlugin)
    fun onDisable(plugin: JavaPlugin)
}