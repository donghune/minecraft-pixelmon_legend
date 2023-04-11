package io.github.hoya.pixelmonlegend.message.entity

import io.github.hoya.pixelmonlegend.util.manager.Config
import io.github.hoya.pixelmonlegend.util.manager.ConfigManager
import kotlinx.serialization.Serializable

val bossBarAnnouncementConfig = BossBarAnnouncementConfigManager.get()

@Serializable
class BossBarAnnouncementConfig(
    val messages: List<String> = listOf("공지1", "공지2", "공지3"),
    val delay: Int = 3,
) : Config("bossbar_announcement")

object BossBarAnnouncementConfigManager : ConfigManager<BossBarAnnouncementConfig>(
    "bossbar_announcement",
    BossBarAnnouncementConfig.serializer(),
    BossBarAnnouncementConfig()
)