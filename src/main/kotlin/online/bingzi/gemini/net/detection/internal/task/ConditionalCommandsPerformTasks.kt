package online.bingzi.gemini.net.detection.internal.task

import online.bingzi.gemini.net.detection.internal.config.ConfigObject.commandList
import online.bingzi.gemini.net.detection.internal.config.ConfigObject.ipAddress
import online.bingzi.gemini.net.detection.internal.util.infoAsLang
import online.bingzi.gemini.net.detection.internal.util.ketherEval
import online.bingzi.gemini.net.detection.internal.util.warningAsLang
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.function.submit
import taboolib.platform.util.bukkitPlugin

object ConditionalCommandsPerformTasks {

    // 出现故障的时候会变更为true，等下次畅通的时候会自动恢复为false
    private var networkStatusIndicator = true

    @Awake(LifeCycle.ACTIVE)
    fun detect() {
        submit(async = true, delay = 20L * 30, period = 20L * 30) {
            try {
                val process = System.getProperty("os.name").lowercase().let { // 执行ping命令
                    if (it.contains("win")) Runtime.getRuntime().exec("ping $ipAddress")
                    else Runtime.getRuntime().exec("ping -c 4 $ipAddress")
                }
                val exitCode = process.waitFor() // 等待进程结束并获取退出码
                if (exitCode == 0) {
                    if (networkStatusIndicator.not()) {
                        networkStatusIndicator = true
                        infoAsLang("NetworkSuccess")
                    }
                } else {
                    if (networkStatusIndicator) {
                        commandList.ketherEval(bukkitPlugin.server.consoleSender)
                        networkStatusIndicator = false
                        warningAsLang("NetworkFailure")
                    }
                }
            } catch (e: Exception) {
                warningAsLang("NetworkError", e.message ?: "未提供任何错误信息")
            }
        }
    }
}
