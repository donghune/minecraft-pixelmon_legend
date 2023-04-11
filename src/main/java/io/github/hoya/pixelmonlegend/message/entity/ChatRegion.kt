package io.github.hoya.pixelmonlegend.message.entity

import io.github.hoya.pixelmonlegend.util.manager.DataModel
import io.github.hoya.pixelmonlegend.util.manager.DataModelManager
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.bukkit.Location

@Serializable
data class ChatRegion(
    val name: String,
    val displayName: String,
    val pos1: @Contextual Location,
    val pos2: @Contextual Location,
) : DataModel(name)

object ChatRegionManager : DataModelManager<ChatRegion>(
    dataFolderPath = "chat_region",
    kSerializer = ChatRegion.serializer(),
)