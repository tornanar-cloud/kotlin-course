package ru.stimmax.lessons.lesson24.homeworks

import ru.stimmax.lessons.lesson16.homeworks.printColored

//Задачи на синтаксис функций высшего порядка.

//1)Создай функцию, которая:
//1.принимает булево значение
//2.принимает функцию, принимающую строку и ничего не возвращающую
//3.возвращает целое число

fun f1(b: Boolean, func: (String) -> Unit): Int {
    return 0
}

//2)Создай функцию расширения целого числа, которая:
//1.принимает функцию расширения целого числа, принимающую строку и возвращающую список строк
//2.возвращает список строк

fun Int.f2(func: Int.(String) -> List<String>): List<String> {
    return func(this.toString())
}

//3)Создай функцию с двумя дженериками расширяющую первый дженерик, которая:
//1.принимает функцию расширяющую первый дженерик, ничего не принимает и возвращает второй дженерик
//2.возвращает второй дженерик

fun <T, P> T.f3(func: T.() -> P): P {
    return func()
}


//4)Создай функцию, которая:
//1.принимает строку
//2.возвращает функцию, которая ничего не принимает и возвращает строку
fun f4(s: String): () -> String {
    return { s }
}

//5)Создай функцию расширяющую дженерик, которая:
//1.ничего не принимает
//2.возвращает функцию, принимающую строку и возвращающую дженерик
fun <T> T.f5(): (String) -> T {
    val a: (String) -> T = { this }
    return a
}


//6)Напиши функцию colorizeWords которая печатает слова из длинного предложения разбитого по пробелу разным цветом.
// Правило подбора цвета для каждого слова нужно передавать в виде функции, которая принимает слово и возвращает это же слово но уже "в цвете" через функцию colorize.

object Colors {
    const val RESET = "\u001B[0m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val BLUE = "\u001B[34m"
    const val PURPLE = "\u001B[35m"
    const val CYAN = "\u001B[36m"
    const val WHITE = "\u001B[37m"
    val list = listOf<String>(
        "\u001B[0m", "\u001B[31m", "\u001B[32m", "\u001B[33m", "\u001B[34m", "\u001B[35m", "\u001B[36m", "\u001B[37m"
    )
}

fun String.colorize(color: String): String {
    return "$color$this${Colors.RESET}"
}

fun String.colorizeWords(fn: (String) -> String) {
    println(fn(this))
}

//цвет слова зависит от его характеристик (для каждой характеристики отдельный цвет):
//*начинается с большой буквы
//*длина меньше трёх символов
//*длина больше 6 символов
//*длина кратна двум
//*для всех прочих отдельный цвет.
val func1: (String) -> String = {
    it.split(" ").joinToString(" ") {
        when {
            it[0].toString() == it[0].uppercase() -> it.colorize(Colors.RED)
            it.length < 3 -> it.colorize(Colors.GREEN)
            it.length > 6 -> it.colorize(Colors.YELLOW)
            it.length % 2 == 0 -> it.colorize(Colors.BLUE)
            else -> it.colorize(Colors.PURPLE)
        }
    }

}

//цвет слова выбирается по очереди из списка цветов для каждого слова через счётчик. Когда счётчик доходит до края списка слов - он обнуляется и начинается заново.
var c1 = 0
val func2: (String) -> String = {
    it.split(" ").joinToString(" ") {
        if (c1 == Colors.list.lastIndex) {
            c1 = 0
        }
        val s = it.colorize(Colors.list[c1])
        c1 += 1
        s

    }

}
// цвет слова выбирается по очереди из списка цветов для каждого слова через счётчик.
// Счётчиком управляет функция, находящаяся в изменяемой переменной.
// Сначала это функция с инкрементом счётчика. Когда счётчик доходит до края списка цветов, нужно заменить функцию счётчика на функцию с декрементом.
// Когда счётчик доходит до нуля - заменить функцию счётчика на функцию с инкрементом и так далее.

var c2 = 0

var cc2 = { c2 += 1 }

val func3: (String) -> String = {
    it.split(" ").joinToString(" ") { o ->
        if (c2 <= 0) {
            cc2 = { c2 += 1 }
        }
        if (c2 >= Colors.list.lastIndex) {
            cc2 = { c2 -= 1 }
        }
        val s = o.colorize(Colors.list[c2])
        cc2()
        s
    }
}

fun main() {
    println(425151225.f2 { it.map { it.toString() } })
    println(f4("Привет")())
    println(4453.f5()("1111111"))
    val text =
        "Напиши функцию colorizeWords которая печатает слова из длинного предложения разбитого по пробелу разным цветом." + " Правило подбора цвета для каждого слова нужно передавать в виде функции, которая принимает слово и возвращает это же слово но уже в цвете через " + "функцию colorize."



    text.colorizeWords(func1)
    text.colorizeWords(func2)
    text.colorizeWords(func3)


}
