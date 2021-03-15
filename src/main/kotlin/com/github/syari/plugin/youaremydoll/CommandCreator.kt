package com.github.syari.plugin.youaremydoll

import com.github.syari.plugin.youaremydoll.Main.Companion.plugin
import com.github.syari.spigot.api.command.command
import com.github.syari.spigot.api.command.tab.CommandTabArgument.Companion.argument
import com.github.syari.spigot.api.string.toColor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object CommandCreator {
    fun register() {
        plugin.command("mydoll") {
            tab {
                argument { addAll("noai", "look") }
            }
            execute {
                val player = sender as? Player ?: return@execute sender.send("&cプレイヤーからのみ実行できるコマンドです")
                when (args.lowerOrNull(0)) {
                    "noai" -> {
                        player.inventory.addItem(Item.NoAI)
                    }
                    "look" -> {
                        player.inventory.addItem(Item.Look)
                    }
                    else -> {
                        sender.send("&c/$label [noai, look]")
                    }
                }
            }
        }
    }

    fun CommandSender.send(message: String) {
        sendMessage("&b[YouAreMyDoll] &r$message".toColor())
    }
}
