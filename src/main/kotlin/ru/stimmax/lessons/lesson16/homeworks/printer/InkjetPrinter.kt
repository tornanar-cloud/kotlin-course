package ru.stimmax.lessons.lesson16.homeworks.printer

import ru.stimmax.lessons.lesson16.homeworks.Colors
import ru.stimmax.lessons.lesson16.homeworks.PairsFontAndBackgrounds
import ru.stimmax.lessons.lesson16.homeworks.printColored

class InkjetPrinter() : Printer() {
    override fun print(s: String) {
        var c = 0
        for (x in s.split(" ")) {
            printColored(x, PairsFontAndBackgrounds.colorPairs[c].first,PairsFontAndBackgrounds.colorPairs[c].second)
            if (c == PairsFontAndBackgrounds.colorPairs.lastIndex){
                c = 0
                continue
            }
            c++
        }
    }
}