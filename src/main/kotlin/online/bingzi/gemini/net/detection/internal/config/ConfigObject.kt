package online.bingzi.gemini.net.detection.internal.config

import taboolib.module.configuration.Config
import taboolib.module.configuration.Configuration

object ConfigObject {

    @Config(value = "config.yml")
    lateinit var config: Configuration
        private set

    val ipAddress by lazy {
        config.getString("ip")
    }
    val commandList by lazy {
        config.getStringList("command")
    }
}