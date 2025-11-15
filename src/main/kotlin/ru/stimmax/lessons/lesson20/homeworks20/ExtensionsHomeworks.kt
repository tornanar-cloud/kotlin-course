package ru.stimmax.lessons.lesson20.homeworks20

import kotlin.math.abs
import kotlin.math.absoluteValue

class ExtensionsHomeworks {
}

/*
1)Определите функцию-расширение для массива чисел,
которая не принимает аргументов и возвращает пару из чисел - первое и последнее. Если массив был пуст то вернуть пару из null значений.
 */
fun <T : Number> Array<T>.fun1() = if (this.isEmpty()) null to null else this[0] to this[this.lastIndex]


/*
2)Создайте функцию-расширение для изменяемого списка элементов:
1.с дженериком T ограниченным интерфейсом Comparable<T>
2.которая принимает булево значение
3.возвращает этот же список только в виде неизменяемого
4.сам изменяемый список при этом должен стать отсортированным по возрастанию, если в функцию передано true и
по убыванию, если false (используем функции sort() и sortDescending()
 */
fun <T : Comparable<T>> MutableList<T>.fun2(bSort: Boolean = true): List<T> {
    if (bSort) {
        this.sort()
        return this
    } else {
        this.sortDescending()
        return this
    }
}

/*
3)Создайте функцию-расширение для nullable словаря с дженериком:
1.Ключ является дженериком
2.Значение является списком из дженериков
3.Принимает целое число
4.Возвращает nullable словарь из ключей изначального словаря приведённых к строке через toString()
5.Значений из nullable дженерика, взятых из изначального ключа-списка по индексу из аргумента, если такого индекса нет - значением будет null
 */
fun <T> Map<T, List<T>>?.fun3(i: Int): Map<String, T?>? {
    return this?.map { it }?.associate { it.key.toString() to it.value.getOrNull(i) }
}

/*
4)Реализуйте метод расширения within для класса Number, который проверяет, что текущее число отклоняется от эталонного не более допустимого значения.
Метод принимает два параметра: other — число для сравнения и deviation — максимально допустимое отклонение.
Метод должен возвращать true, если разница между текущим числом и числом для сравнения не превышает заданное отклонение.
Протестируйте функцию на разных типах чисел. Для получения отклонения, у разницы чисел нужно вызвать свойство absoluteValue.
 */
fun <T : Number> Number.within(other: T, deviation: T): Boolean {
    return (this.toDouble() - other.toDouble()).absoluteValue <= deviation.toDouble()
}


/*
5)Реализуйте для класса String два метода расширения: encrypt и decrypt. Метод encrypt должен сдвигать каждый символ исходной строки на
заданное число позиций вперед по таблице Unicode, а метод decrypt — на то же число позиций назад. Оба метода принимают один параметр base типа Int,
который определяет величину сдвига. Протестируйте вашу реализацию, убедившись, что после шифрования и последующей расшифровки строка возвращается к исходному состоянию.
Сдвиг по таблице Unicode реализуется простым прибавлением или вычитанием размера сдвига к char символу.
 */
//Сделал лимит по сдвигу
fun String.encrypt(d: Int): String? {
    var s = ""
    if (d !in 0..300) {
        println("Лимит по сдвигу 0 - 300")
        return null
    } else {
        this.forEach { s += (it.code + d).toChar() }
    }
    return s
}

fun String.decrypt(d: Int): String? {
    var s = ""
    if (d !in 0..300) {
        println("Лимит по сдвигу 0 - 300")
        return null
    } else {
        this.forEach { s += (it.code - d).toChar() }
    }
    return s
}

/*
6.Многие уже знают любимую игру в Твиттере - собирание разных слов из букв через ответы (но мы то знаем что слово только одно, но не будем его называть).
Напиши метод расширения строки, который будет принимать список имён пользователей и выводить в консоли исходную строку побуквенно в верхнем регистре в столбик:
имя автора и букву под ним. Вот ссылка на референс:
https://x.com/SadNSober_/status/1370280031616897026
Если ссылка не открывается по понятным причинам, вот скриншот
 */
fun String.fun6(names: List<String>) {
    var b: Int = 0
    for (x in this.indices) {
        println(names[b])
        println(this[x])
        b += 1
        if (b > names.lastIndex) {
            b = 0
        }
    }
}

fun main() {

    println(arrayOf(2, 3, 4, 6, 7).fun1())
    println(emptyArray<Int>().fun1())

    println(mutableListOf<Int>(5, 2, 1, 2, 7, 8, 3, 26, 62, -2).fun2(true))
    println(mutableListOf<Int>(5, 2, 1, 2, 7, 8, 3, 26, 62, -2).fun2(false))

    val m: Map<Int, String?>? = mapOf(2 to null)

    var m1: Map<Int, List<Int>>? =
        mapOf<Int, List<Int>>(1 to listOf(1, 2, 3), 2 to listOf(3, 2, 1), 5 to listOf(5, 6, 7))
    println(m1.fun3(5))
    println(m1.fun3(1))

    var q = -3
    println(q.within(-13, 4))

    println("Привет как дела".encrypt(200))
    println("ӧԈԀӺӽԊèԂӸԂèӼӽԃӸ".decrypt(200))

    "Напридумывали всяких твиттеров и теперь фигеют".fun6(listOf("Petya", "Sanya", "Jora"))
}




