package online.bingzi.gemini.net.detection

import online.bingzi.gemini.net.detection.internal.util.infoAsLang
import taboolib.common.platform.Platform
import taboolib.common.platform.Plugin
import taboolib.module.metrics.Metrics
import taboolib.platform.util.bukkitPlugin

object GeminiNetDetection : Plugin() {
    /**
     * 初始化
     */
    override fun onLoad() {
        infoAsLang("Loading")
        infoAsLang("Loaded")
    }

    /**
     * 启动
     *
     */
    override fun onEnable() {
        infoAsLang("Enabling")
        Metrics(18525, bukkitPlugin.description.version, Platform.BUKKIT)
        infoAsLang("Enabled")
    }

    /**
     * 关闭
     *
     */
    override fun onDisable() {
        infoAsLang("Disabling")
        infoAsLang("Disabled")
    }
}