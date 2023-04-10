package io.github.hoya.pixelmonlegend.util.manager

import io.github.hoya.pixelmonlegend.PixelmonLegend
import io.github.hoya.pixelmonlegend.util.serialization.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.decodeFromStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

@OptIn(ExperimentalSerializationApi::class)
open class ConfigManager<T : Config>(
    private val dataFolderPath: String,
    private val kSerializer: KSerializer<T>,
    private val defaultData: T,
) {

    private var data: T = defaultData

    private val folder = File("${PixelmonLegend.dataFolder.path}/$dataFolderPath")
    val file = File("$folder", data.fileName)

    init {
        loadConfigFile()
    }

    fun update(config: T) {
        data = config
        saveConfigFile(data)
    }

    fun get(): T {
        return data
    }

    private fun loadConfigFile() {
        val file = File("${PixelmonLegend.dataFolder.path}/$dataFolderPath", data.fileName)
        if (!file.exists()) {
            folder.mkdirs()
            file.createNewFile()
            saveConfigFile(defaultData)
        }
        val fileInputStream = FileInputStream(file)
        val config = json.decodeFromStream(kSerializer, fileInputStream)
        data = config
    }

    private fun saveConfigFile(data: T) {
        val file = File(/* parent = */ "${PixelmonLegend.dataFolder.path}/$dataFolderPath", /* child = */ data.fileName)
        FileOutputStream(file).also {
            it.write(json.encodeToString(kSerializer, data).toByteArray())
            it.flush()
        }.close()
    }

}