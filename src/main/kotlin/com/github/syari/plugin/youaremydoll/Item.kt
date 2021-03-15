package com.github.syari.plugin.youaremydoll

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import com.github.syari.spigot.api.item.displayName as eDisplayName

object Item {
    val NoAI = ItemStack(Material.FEATHER).apply {
        eDisplayName = "&aNo AI"
    }

    val Look = ItemStack(Material.ENDER_EYE).apply {
        eDisplayName = "&aLook"
    }
}
