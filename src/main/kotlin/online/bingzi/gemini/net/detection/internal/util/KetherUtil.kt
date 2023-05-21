package online.bingzi.gemini.net.detection.internal.util

import org.bukkit.command.CommandSender
import taboolib.library.kether.LocalizedException
import taboolib.module.kether.KetherShell.eval
import taboolib.module.kether.ScriptOptions
import taboolib.module.kether.printKetherErrorMessage

fun List<String>.ketherEval(sender: CommandSender) {
    try {
        eval(this, ScriptOptions.builder().sender(sender).build())
    } catch (e: LocalizedException) {
        e.printKetherErrorMessage()
    } catch (e: Throwable) {
        e.printKetherErrorMessage()
    }
}

fun String.ketherEval(sender: CommandSender) {
    try {
        eval(this, ScriptOptions.builder().sender(sender).build())
    } catch (e: LocalizedException) {
        e.printKetherErrorMessage()
    } catch (e: Throwable) {
        e.printKetherErrorMessage()
    }
}