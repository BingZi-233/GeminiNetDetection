package online.bingzi.gemini.net.detection.internal.util

import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.ProxyPlayer
import taboolib.common.platform.function.info
import taboolib.common.platform.function.warning
import taboolib.module.chat.colored
import taboolib.module.lang.asLangText
import taboolib.platform.util.asLangText
import taboolib.platform.util.bukkitPlugin

private val consoleSender = bukkitPlugin.server.consoleSender


internal fun infoAsLang(node: String) {
    info(consoleSender.asLangText(node).colored())
}

internal fun infoAsLang(node: String, vararg args: Any) {
    info(consoleSender.asLangText(node, *args).colored())
}

internal fun warningAsLang(node: String) {
    warning(consoleSender.asLangText(node).colored())
}

internal fun warningAsLang(node: String, vararg args: Any) {
    warning(consoleSender.asLangText(node, *args).colored())
}

internal fun ProxyCommandSender.sendMessageAsLang(node: String) {
    this.sendMessage(this.asLangText(node).colored())
}

internal fun ProxyCommandSender.sendMessageAsLang(node: String, vararg args: Any) {
    this.sendMessage(this.asLangText(node, *args).colored())
}

internal fun CommandSender.sendMessageAsLang(node: String) {
    this.sendMessage(this.asLangText(node).colored())
}

internal fun CommandSender.sendMessageAsLang(node: String, vararg args: Any) {
    this.sendMessage(this.asLangText(node, *args).colored())
}

internal fun ProxyPlayer.sendMessageAsLang(node: String) {
    this.sendMessage(this.asLangText(node).colored())
}

internal fun ProxyPlayer.sendMessageAsLang(node: String, vararg args: Any) {
    this.sendMessage(this.asLangText(node, *args).colored())
}

internal fun Player.sendMessageAsLang(node: String) {
    this.sendMessage(this.asLangText(node).colored())
}

internal fun Player.sendMessageAsLang(node: String, vararg args: Any) {
    this.sendMessage(this.asLangText(node, *args).colored())
}