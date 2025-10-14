package ru.stimmax.lessons.lesson11.homeworks

fun main() {
    println(multiplyByTwo(2))
    println(isEven(2))
    println(isEven(0))
    println(isEven(1))
    printNumbersUntil(14)
    println()
    println(findFirstNegative(listOf(1, 2, 3, -5, 0, 2, 3, 5, -100)))
    processList(listOf("Hello", "World", null,"null"))
}


// Задачи на сигнатуру метода
//1. Не принимает аргументов и не возвращает значения.
fun a1() {}

//2. Принимает два целых числа и возвращает их сумму.
fun a2(a: Int, b: Int): Int = a + b

//3. Принимает строку и ничего не возвращает.
fun a3(s: String) {}

//4. Принимает список целых чисел и возвращает среднее значение типа Double.
fun a4(l: List<Int>): Double {
    return 0.0
}

//5. Принимает nullable строку и возвращает её длину в виде nullable целого числа и доступна только в текущем файле.
private fun a5(s: String?): Int? {
    return 2
}

//6. Не принимает аргументов и возвращает nullable вещественное число.
fun a6(): Double? {
    return 0.0
}

//7. Принимает nullable список целых чисел, не возвращает значения и доступна только в текущем файле.
private fun a8(l: List<Int>?) {}

//8. Принимает целое число и возвращает nullable строку.
fun a8(i: Int): String? {
    return ""
}

//9. Не принимает аргументов и возвращает список nullable строк.
fun a9(): List<String?> {
    return listOf()
}

//10. Принимает nullable строку и nullable целое число и возвращает nullable булево значение.
fun a10(s: String?, i: Int?): Boolean? {
    return true
}

//Задачи на написание кода
//11. Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.
fun multiplyByTwo(i: Int): Int = i * 2

//12. Создайте функцию isEven, которая принимает целое число и возвращает true, если число чётное, и false в противном случае.
fun isEven(i: Int): Boolean {
    return i % 2 == 0
}

//13. Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n.
// Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.
fun printNumbersUntil(n: Int) {
    if (n < 1) {
        return
    } else {
        for (x in 1 until n) {
            print("$x ")
        }
    }
}

//14. Создайте функцию findFirstNegative, которая принимает список целых чисел и возвращает первое отрицательное число в списке.
// Если отрицательных чисел нет, функция должна вернуть null.
fun findFirstNegative(il: List<Int>): Int? {

    for (x in il) {
        if (x < 0) {
           return x
        }
    }
    return null
}

//15. Напишите функцию processList, которая принимает список строк. Функция должна проходить по списку и выводить каждую строку.
// Если встречается null значение, функция должна прекратить выполнение с помощью return без возврата значения.
fun processList(sl: List<String?>) {
    for (x in sl) {
        if (x == null) {
            return
        }
        println(x)
    }

}