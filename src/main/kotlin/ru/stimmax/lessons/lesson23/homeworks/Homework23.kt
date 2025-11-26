package ru.stimmax.lessons.lesson23.homeworks

import ru.stimmax.lessons.lesson22.homeworks.ce1
import kotlin.collections.average

//1)Создай функцию, которая принимает список чисел и возвращает среднее арифметическое всех чётных чисел этого списка. С помощью require проверь, что список не пустой.
//1.Создай аналогичную анонимную функцию.
//2.Создай аналогичное лямбда выражение с указанием типа.
//3.Создай лямбда выражение без указания типа.
//4.Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных (в том числе пустого).

fun a1(list: List<Int>): Double {
    try {
        require(list.isNotEmpty())
        return list.filter { it != 0 && it % 2 == 0 }.average()
    } catch (e: IllegalArgumentException) {
        println(e)
        return 0.0
    }

}

val a2 = fun(list: List<Int>): Double {
    try {
        require(list.isNotEmpty())
        return list.filter { it != 0 && it % 2 == 0 }.average()
    } catch (e: IllegalArgumentException) {
        println(e)
        return 0.0
    }

}
val a3: (List<Int>) -> Double = { list ->
    try {
        require(list.isNotEmpty())
        list.filter { it != 0 && it % 2 == 0 }.average()
    } catch (e: IllegalArgumentException) {
        println(e)
        0.0
    }
}
val a4 = { list: List<Int> ->
    try {
        require(list.isNotEmpty())
        list.filter { it != 0 && it % 2 == 0 }.average()
    } catch (e: IllegalArgumentException) {
        println(e)
        0.0
    }
}

fun main() {
    val l = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8)
    println(a4(l))
    println(a4(listOf()))
    println(a4(listOf(1, 3, 5, 7, 9, 11)))
    println(a4(listOf(0, 0, 0, 0, 0, 0, 0)))
    println('2'.toInt())
    println(b1(28556289658743752))
    println(listOf<Int>(1,2,3,4,4,5,5,1,1).c3())
    println(listOf<Int>().c3())
}


//2)Создай функцию, которая принимает большое число и возвращает сумму цифр этого числа. Сделай проверку, что входящее число больше нуля.
// Подсказка: для парсинга символа в число можно использовать функцию digitToInt()
//1.Создай аналогичную анонимную функцию.
//2.Создай аналогичное лямбда выражение с указанием типа.
//3.Создай лямбда выражение без указания типа.
//4.Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.

fun b1(l: Long): Long {
    try {
        require(l > 0)
        return l.toString().map { it.digitToInt() }.sumOf { it.toLong() }
    } catch (e: IllegalArgumentException) {
        println(e)
        return 0
    }
    //return l.toString().map { it.toString().toLong() }.sum()
}

val b2 = fun(l: Long): Long {
    try {
        require(l > 0)
        return l.toString().map { it.digitToInt() }.sumOf { it.toLong() }
    } catch (e: IllegalArgumentException) {
        println(e)
        return 0
    }
    //return l.toString().map { it.toString().toLong() }.sum()
}

val b3: (Long) -> Long = { l ->
    try {
        require(l > 0)
        l.toString().map { it.digitToInt() }.sumOf { it.toLong() }
    } catch (e: IllegalArgumentException) {
        println(e)
        0
    }
}

val b4 = { l: Long ->
    try {
        require(l > 0)
        l.toString().map { it.digitToInt() }.sumOf { it.toLong() }
    } catch (e: IllegalArgumentException) {
        println(e)
        0
    }
}

//3)Создай функцию-расширение списка чисел, которая будет возвращать множество дубликатов чисел (встречающихся в списке более одного раза).
//1.Создай аналогичную анонимную функцию.
//2.Создай аналогичное лямбда выражение с указанием типа.
//3.Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.


fun List<Int>.c1(): Set<Int> {
    val s = mutableSetOf<Int>()
    val dubl = mutableSetOf<Int>()
    for(x in this){
        if (!s.add(x)) dubl.add(x)
    }
    return dubl.toSet()
}

val c2 = fun List<Int>.(): Set<Int> {
    val s = mutableSetOf<Int>()
    val dubl = mutableSetOf<Int>()
    for(x in this){
        if (!s.add(x)) dubl.add(x)
    }
    return dubl.toSet()
}

val c3 : List<Int>.() -> Set<Int> = {
    val s = mutableSetOf<Int>()
    val dubl = mutableSetOf<Int>()
    for(x in this){
        if (!s.add(x)) dubl.add(x)
    }
     dubl.toSet()
}

