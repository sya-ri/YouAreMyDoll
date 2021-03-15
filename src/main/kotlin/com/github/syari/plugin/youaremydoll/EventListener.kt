package com.github.syari.plugin.youaremydoll

import com.github.syari.spigot.api.event.EventRegister
import com.github.syari.spigot.api.event.Events
import org.bukkit.entity.LivingEntity
import org.bukkit.event.player.PlayerInteractEntityEvent

object EventListener : EventRegister {
    override fun Events.register() {
        event<PlayerInteractEntityEvent> {
            val target = it.rightClicked
            val player = it.player
            val item = player.inventory.itemInMainHand
            when {
                item.isSimilar(Item.NoAI) -> {
                    (target as? LivingEntity)?.setAI(player.isSneaking)
                }
                item.isSimilar(Item.Look) -> {
                    target.teleport(target.location.setDirection(player.location.subtract(target.location).toVector()))
                }
            }
        }
    }
}
