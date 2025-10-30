package ru.stimmax.lessons.lesson16.homeworks.logger

import ru.stimmax.lessons.lesson16.homeworks.Colors
import ru.stimmax.lessons.lesson16.homeworks.printColored

class Logger {
    fun log(s: String) {
        println("[INFO] : $s")
    }

    fun log(s: String, level: String) {
        var fontColor = Colors.RESET
        var backgroundColor = Colors.RESET
        when (level) {
            "WARNING" -> fontColor = Colors.YELLOW
            "ERROR" -> {
                backgroundColor = Colors.RED
            }

            //"INFO" -> {}
            else -> {}
        }
        printColored("[$level] : $s", fontColor, backgroundColor)
    }

    fun log(messages: List<String>) {
        for (x in messages){
            println("[INFO] : $x")
        }
    }

    fun log(e: Exception){
        println("[ERROR] : ${e.message}")
    }
}