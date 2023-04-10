package io.github.hoya.pixelmonlegend.util.manager

import kotlinx.serialization.Serializable

@Serializable
abstract class Config(
    private val primaryKey: String,
) {
    val fileName
        get() = "${primaryKey}.json"
}