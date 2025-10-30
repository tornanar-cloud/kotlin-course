package ru.stimmax.lessons.lesson16.homeworks


    object Colors {
        const val RESET = "\u001B[0m"
        const val BLACK = "\u001B[30m"
        const val RED = "\u001B[31m"
        const val GREEN = "\u001B[32m"
        const val YELLOW = "\u001B[33m"
        const val BLUE = "\u001B[34m"
        const val PURPLE = "\u001B[35m"
        const val CYAN = "\u001B[36m"
        const val WHITE = "\u001B[37m"
    }
    object Background {
        const val RESET = "\u001B[0m"
        const val BLACK = "\u001B[40m"
        const val RED = "\u001B[41m"
        const val GREEN = "\u001B[42m"
        const val YELLOW = "\u001B[43m"
        const val BLUE = "\u001B[44m"
        const val PURPLE = "\u001B[45m"
        const val CYAN = "\u001B[46m"
        const val WHITE = "\u001B[47m"
    }
    fun printColored(text: String, color: String, backgroundColor: String = "") {
        println("$color$backgroundColor$text${Colors.RESET}")
    }

    object PairsFontAndBackgrounds{
        val colorPairs = listOf(
            "\u001B[31m" to "\u001B[42m", // красный текст на зелёном
            "\u001B[31m" to "\u001B[43m", // красный на жёлтом
            "\u001B[31m" to "\u001B[46m", // красный на циан

            "\u001B[32m" to "\u001B[41m", // зелёный на красном
            "\u001B[32m" to "\u001B[44m", // зелёный на синем
            "\u001B[32m" to "\u001B[45m", // зелёный на пурпурном

            "\u001B[33m" to "\u001B[44m", // жёлтый на синем
            "\u001B[33m" to "\u001B[45m", // жёлтый на пурпурном
            "\u001B[33m" to "\u001B[41m", // жёлтый на красном

            "\u001B[34m" to "\u001B[43m", // синий на жёлтом
            "\u001B[34m" to "\u001B[42m", // синий на зелёном
            "\u001B[34m" to "\u001B[46m", // синий на циан

            "\u001B[35m" to "\u001B[42m", // пурпурный на зелёном
            "\u001B[35m" to "\u001B[46m", // пурпурный на циан
            "\u001B[35m" to "\u001B[43m", // пурпурный на жёлтом

            "\u001B[36m" to "\u001B[41m", // циан на красном
            "\u001B[36m" to "\u001B[45m", // циан на пурпурном
            "\u001B[36m" to "\u001B[44m"  // циан на синем
        )
    }