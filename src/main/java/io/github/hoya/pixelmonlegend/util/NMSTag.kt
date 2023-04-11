package io.github.hoya.pixelmonlegend.util

import io.github.hoya.pixelmonlegend.util.serialization.json
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import net.minecraft.server.v1_12_R1.NBTTagCompound
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack
import org.bukkit.inventory.ItemStack

inline fun <reified T> ItemStack.setTag(key: String, value: T): ItemStack {
    val craftItemStack = CraftItemStack.asNMSCopy(this)
    val compound = craftItemStack.tag ?: NBTTagCompound()
    compound.setString(key, json.encodeToString(value))
    craftItemStack.tag = compound
    return CraftItemStack.asBukkitCopy(craftItemStack) ?: throw NullPointerException()
}


inline fun <reified T> ItemStack.setTag(value: T): ItemStack {
    return setTag(T::class.simpleName!!, value)
}


inline fun <reified T> ItemStack.getTag(key: String): T? {
    val craftItemStack = CraftItemStack.asNMSCopy(this)
    val compound = craftItemStack.tag ?: NBTTagCompound()
    return compound.getString(key)?.let { json.decodeFromString<T>(it) }
}

inline fun <reified T> ItemStack.getTag(): T? {
    return getTag(T::class.simpleName!!)
}