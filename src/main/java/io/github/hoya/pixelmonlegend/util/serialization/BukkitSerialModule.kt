package io.github.hoya.pixelmonlegend.util.serialization

import io.github.hoya.pixelmonlegend.util.serialization.serializers.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual
import kotlinx.serialization.modules.plus

/**
 * All KotlinBukkitAPI already built Serializers for Kotlinx.serialization.
 *
 * Serializers for: Block, Chunk, Location, MaterialData, Material, World.
 */
val BukkitSerialModule = SerializersModule {
    contextual(BlockSerializer)
    contextual(ChunkSerializer)
    contextual(LocationSerializer)
    contextual(MaterialSerializer)
    contextual(WorldSerializer)
    contextual(ItemStackSerializer)
    contextual(UUIDSerializer)
    contextual(IntRangeSerializer)
    contextual(LocalDateTimeSerializer)
}

val json = Json {
    prettyPrint = true
    serializersModule += BukkitSerialModule
    encodeDefaults = true
    coerceInputValues = true
    ignoreUnknownKeys = true
    allowStructuredMapKeys = true
}