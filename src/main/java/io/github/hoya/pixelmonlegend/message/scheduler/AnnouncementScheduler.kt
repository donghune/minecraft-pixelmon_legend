package io.github.hoya.pixelmonlegend.message.scheduler

import io.github.hoya.pixelmonlegend.PixelmonLegend
import io.github.hoya.pixelmonlegend.message.entity.bossBarAnnouncementConfig
import org.bukkit.Bukkit
import org.bukkit.boss.BarColor
import org.bukkit.boss.BarStyle

class AnnouncementScheduler {

    private val bossBar = Bukkit.createBossBar("", BarColor.GREEN, BarStyle.SOLID)
    private var index = 0

    fun start() {
        val length = bossBarAnnouncementConfig.messages.size
        Bukkit.getScheduler().runTaskTimer(
            PixelmonLegend.instance,
            { bossBar.title = bossBarAnnouncementConfig.messages[index++ % length] },
            0L,
            20L * bossBarAnnouncementConfig.delay
        )
    }

}