package io.github.hoya.pixelmonlegend.utiliy

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.ExplosionPrimeEvent
import org.bukkit.event.entity.FoodLevelChangeEvent

class UtilityListener : Listener {
    @EventHandler
    fun onFoodLevelChangeEvent(event: FoodLevelChangeEvent) {
        event.isCancelled = true
    }

    @EventHandler
    fun onExplosionPrimeEvent(event: ExplosionPrimeEvent) {
        event.isCancelled = true
    }
}