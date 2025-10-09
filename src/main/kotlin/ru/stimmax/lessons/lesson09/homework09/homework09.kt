package ru.stimmax.lessons.lesson09.homework09

import ru.stimmax.lessons.lesson04.homework.v11

fun main() {
    //ARRAY
    //1. Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
    val a1: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    println(a1.joinToString(" "))

//2. Создайте пустой массив строк размером 10 элементов.
    var i = 0
    val a2: Array<Int> = Array(10) { i++ }
    println(a2.joinToString(" "))
//3. Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.

    //val a3 = Array(5) { it.toDouble() * 2.0 }

    val a3 = Array(5) { 0.0 }
    for (x in a3.indices) {
        a3[x] = x * 2.0
    }
    println(a3.joinToString(" "))
//4. Создайте массив из 5 элементов типа Int. Используйте цикл, чтобы присвоить каждому элементу значение, равное его индексу, умноженному на 3.
    val a4 = Array(5) { 0 }

    for (x in a4.indices) {
        a4[x] = x * 3
    }
    println(a4.joinToString(" "))

    //5. Создайте массив из 3 nullable строк. Инициализируйте его одним null значением и двумя строками.
    val a5: Array<String?> = arrayOf(null, "Строка 2", "Строка 3")

    //6. Создайте массив целых чисел и скопируйте его в новый массив в цикле.
    val a6: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    val a7: Array<Int> = Array(a6.size) { 0 }
    for (x in a6.indices) {
        a7[x] = a6[x]
    }
    println(a6.joinToString(" "))
    println(a7.joinToString(" "))

    //7. Создайте два массива целых чисел одинаковой длины. Создайте третий массив, вычев значения одного из другого. Распечатайте полученные значения.
    val a8: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    val a9: Array<Int> = arrayOf(6, 7, 8, 9, 10)
    val a10: Array<Int> = Array(a8.size) { 0 }
    for (x in a10.indices) {
        a10[x] = a8[x] - a9[x]
    }
    println(a8.joinToString(" "))
    println(a9.joinToString(" "))
    println(a10.joinToString(" "))

    //8. Создайте массив целых чисел. Найдите индекс элемента со значением 5. Если значения 5 нет в массиве, печатаем -1. Реши задачу через цикл while.
    val a11: Array<Int> = arrayOf(1, 4, 6, 5, 8, 1, 3, 6)
    var res1 = -1
    var count1 = 0
    while (count1 < a11.size) {
        if (a11[count1] == 5) {
            res1 = count1
            break
        }
        count1++
    }
    println(res1)

    //9. Создайте массив целых чисел. Используйте цикл для перебора массива и вывода каждого элемента в консоль.
// Напротив каждого элемента должно быть написано “чётное” или “нечётное”.
    val a12: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    for (x in a12) {
        if (x % 2 == 0) {
            println("$x - Чётное")
        } else println("$x - Нечётное")
    }

    //10. Создай функцию, которая принимает массив строк и строку для поиска.
// Функция должна находить в массиве элемент, в котором принятая строка является подстрокой (метод contains()). Распечатай найденный элемент.
    aTask10(arrayOf<String>("Привет", "Подмога", "Поддержать разговор", "А был ли мальчик?"), "под")

    //LIST
    //1. Создайте пустой неизменяемый список целых чисел.
    val l1: List<Int> = emptyList()
    val l2: List<Int> = listOf()
    println("${l1.size} - ${l2.size}")
    //2. Создайте неизменяемый список строк, содержащий три элемента (например, "Hello", "World", "Kotlin").
    val l3: List<String> = listOf("Hello", "World", "Kotlin")
    println(l3.joinToString(" "))
    //3. Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
    val l4: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
    println(l4)
    //4. Имея изменяемый список целых чисел, добавьте в него новые элементы (например, 6, 7, 8)
    val l5: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
    l5.addAll(mutableListOf(6, 7, 8))
    l5.add(6)
    l5.add(7)
    l5.add(8)
    println(l5.joinToString(" "))
    //5. Имея изменяемый список строк, удалите из него определенный элемент (например, "World").
    val l6: MutableList<String> = mutableListOf("Hello", "World", "Kotlin")
    l6.remove("World")
    println(l6.joinToString(" "))
//6. Создайте список целых чисел и используйте цикл для вывода каждого элемента на экран.
    val l7: List<Int> = listOf(1, 2, 3, 4, 5)
    for (x in l7) {
        print("$x ")
    }
    println()
    //7. Создайте список строк и получите из него второй элемент, используя его индекс.
    val l8: List<String> = listOf("Hello", "World", "Kotlin")
    println(l8[1])

    //8. Имея изменяемый список чисел, измените значение элемента на определенной позиции (например, замените элемент с индексом 2 на новое значение).
    val l9: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
    l9[2] = 9
    println(l9.joinToString(" "))

    //9. Создайте два списка строк и объедините их в один новый список, содержащий элементы обоих списков. Реши задачу с помощью циклов.
    val l10: List<String> = listOf("раз", "два", "три")
    val l11: List<String> = listOf("четыре", "пять", "шесть")
    //val l12: List<String> = l10+l11
    val l12: MutableList<String> = mutableListOf()
    for (x in l10.indices) {
        l12.add(l10[x])
    }
    for (x in l11.indices) {
        l12.add(l11[x])
    }
    println(l12.joinToString(" "))
//10. Создайте список целых чисел и найдите в нем минимальный и максимальный элементы используя цикл.
    val l13: List<Int> = listOf(2, 4, 5, 1, 2, 8, 3, 7, 8, -50)
    var min: Int = l13[0]
    var max: Int = l13[0]
    for (x in l13.indices) {
        if (min > l13[x]) {
            min = l13[x]
        }
        if (max < l13[x]) {
            max = l13[x]
        }

    }
    println(min)
    println(max)
//11. Имея список целых чисел, создайте новый список, содержащий только четные числа из исходного списка используя цикл.
    val l14: List<Int> = listOf(2, 4, 5, 1, 2, 8, 3, 7, 8, -50)
    val l15: MutableList<Int> = mutableListOf()
    for (x in l14) {
        if (x % 2 == 0) {
            l15.add(x)
        }
    }
    println(l15.joinToString(" "))
    //Set
    //1. Создайте пустое неизменяемое множество целых чисел.
    val s1: Set<Int> = setOf()

    //2. Создайте неизменяемое множество целых чисел, содержащее три различных элемента (например, 1, 2, 3).
    val s2: Set<Int> = setOf(1, 2, 3)
    println(s2.joinToString(" "))
    //3. Создайте изменяемое множество строк и инициализируйте его несколькими значениями (например, "Kotlin", "Java", "Scala").
    val s3: MutableSet<String> = mutableSetOf("Kotlin", "Java", "Scala")
    println(s3.joinToString(" "))
    //4. Имея изменяемое множество строк, добавьте в него новые элементы (например, "Swift", "Go").
    //s3.addAll(mutableSetOf("Swift", "Go"))
    s3.add("Swift")
    s3.add("Go")
    println(s3.joinToString(" "))
    //5. Имея изменяемое множество целых чисел, удалите из него определенный элемент (например, 2).
    val s4: MutableSet<Int> = mutableSetOf(1, 2, 3, 4, 5, 6, 7)
    s4.remove(2)
    println(s4.joinToString(" "))

    //6. Создайте множество целых чисел и используйте цикл для вывода каждого элемента на экран.
    for (x in s4) {
        println(x)
    }

    //7. Создай функцию, которая принимает множество строк (set) и строку и проверяет, есть ли в множестве указанная строка.
// Нужно вернуть булево значение true если строка есть. Реши задачу через цикл.
    println(sTask7(setOf("vred", "set", "get"), "pet"))
    //8 Создайте множество строк и конвертируйте его в изменяемый список строк с использованием цикла.
    val s5: Set<String> = setOf("Kotlin", "Java", "Scala", "Swift", "Go")
    val stl6: MutableList<String> = mutableListOf()
    for (x in s5) {
        stl6.add(x)
    }
    println(stl6.joinToString(" "))
}






//10. Создай функцию, которая принимает массив строк и строку для поиска.
// Функция должна находить в массиве элемент, в котором принятая строка является подстрокой (метод contains()). Распечатай найденный элемент.
fun aTask10(arg: Array<String>, str: String) {
    for (x in arg) {
        if (x.contains(str, true)) {
            println(x)

        }
    }
}

//7. Создай функцию, которая принимает множество строк (set) и строку и проверяет, есть ли в множестве указанная строка.
// Нужно вернуть булево значение true если строка есть. Реши задачу через цикл.
fun sTask7(arg: Set<String>, str: String): Boolean {
    var b: Boolean = false
    for (x in arg) {
        if (x.equals(str, true)) {
            b = true
            break
        }
    }
    return b
}