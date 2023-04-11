package io.github.hoya.pixelmonlegend.economy.extension

import io.github.hoya.pixelmonlegend.PixelmonLegend
import io.github.hoya.pixelmonlegend.economy.entity.CheckData
import io.github.hoya.pixelmonlegend.util.getTag
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

fun ItemStack.getCheckData(): CheckData? {
    return getTag<CheckData>()
}

fun Player.withdraw(money: Long) {
    PixelmonLegend.instance.economy.withdrawPlayer(this, money.toDouble())
}

fun Player.deposit(money: Long) {
    PixelmonLegend.instance.economy.depositPlayer(this, money.toDouble())
}

fun Player.money(): Long {
    return PixelmonLegend.instance.economy.getBalance(this).toLong()
}

fun Player.withdraw(money: Int) {
    PixelmonLegend.instance.economy.withdrawPlayer(this, money.toDouble())
}

fun Player.deposit(money: Int) {
    PixelmonLegend.instance.economy.depositPlayer(this, money.toDouble())
}
