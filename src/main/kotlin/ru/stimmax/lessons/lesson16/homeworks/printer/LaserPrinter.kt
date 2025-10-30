package ru.stimmax.lessons.lesson16.homeworks.printer

import ru.stimmax.lessons.lesson16.homeworks.Background
import ru.stimmax.lessons.lesson16.homeworks.Colors
import ru.stimmax.lessons.lesson16.homeworks.printColored

class LaserPrinter(): Printer() {
    override fun print(s: String) {
        for (x in s.split(" ")){
            printColored(x, Colors.BLACK, Background.WHITE)
        }
    }
}