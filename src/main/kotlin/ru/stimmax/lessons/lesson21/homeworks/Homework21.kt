package ru.stimmax.lessons.lesson21.homeworks

/*
Задача 1

Напишите функцию analyzeDataType, принимающую параметр типа Any. Функция должна определить тип аргумента и вывести соответствующее сообщение:

Для строки: "Это строка: [значение]".
Для любого числа: "Это число: [значение]".
Для списка: "Это список, количество элементов: [количество]".
Для словаря: "Это словарь, количество пар: [количество]".
Для остальных типов: "Неизвестный тип данных".
Используйте оператор is для проверки типов.
 */
fun analyzeDataType(par: Any?) {
    when (par) {
        is String -> println("Это строка: $par")
        is Number -> println("Это число: $par")
        is List<*> -> println("Это список, количество элементов: ${par.size}")
        is Map<*, *> -> println("Это словарь, количество пар: ${par.size}")
        else -> println("Неизвестный тип данных")
    }
}

/*
Задача 2
Создайте функцию safeCastToList, принимающую параметр типа Any и возвращающую размер списка, если аргумент можно безопасно привести к типу List.
В случае неудачного приведения функция должна возвращать -1. Используйте as? для безопасного приведения типа.
 */

fun safeCastToList(par: Any?): Int {
    return (par as? List<*>)?.size ?: -1
}

/*
Задача 3
Создайте функцию getStringLengthOrZero, которая принимает параметр типа Any? и возвращает длину строки, если аргумент можно привести к типу String.
В случае, если аргумент равен null или не является строкой, функция должна возвращать 0.
 */
fun getStringLengthOrZero(par: Any): Int {
    return (par as? String)?.length ?: 0
}

/*
Задача 4

Создайте функцию-расширение класса Any toSquare. Функция гарантированно вызывается у числа (в виде числа или строки, например 4 или 4.2 или “4.2”)
и должна вернуть квадрат этого числа. Если придёт число, его нужно возвести в квадрат, если придёт строка, то его нужно преобразовать
в число через функцию toDouble() и возвести в квадрат.
 */

fun Any.toSquare(): Double {
    val a = (this as? Number)?.toDouble() ?: (this as String).toDouble()
    return a * a
}

/*
Задача 5
Напишите функцию sumIntOrDoubleValues, которая принимает список элементов типа Any и возвращает сумму всех целочисленных (Int)
и вещественных (Double) значений в списке. Все остальные типы должны быть проигнорированы.
 */

fun sumIntOrDoubleValues(list: List<Any>): Double {
    /*var sum = 0.0

    list.forEach {
        if (it is Int) {
            sum += it.toDouble()
        }
        if (it is Double){
            sum +=it
        }
    }
    */
/*
    return list.sumOf {
          if (it is Int) {
            it.toDouble()
        } else if (it is Double) {
            it
        } else 0.0
    }
  */
   return list.sumOf { (it as? Int)?.toDouble() ?: (it as? Double) ?: 0.0 }

}



/*
Задача 6

Создайте функцию tryCastToListAndPrint, которая принимает параметр типа Any и пытается привести его к типу List<*>.
Если приведение успешно, функция должна напечатать все строки из списка, если элемент не является строкой то вывести предупреждение об этом.
Если приведение неудачно, должно быть выведено сообщение об ошибке, не прерывая выполнение программы.
 */

fun tryCastToListAndPrint(par: Any){
    (par as? List<*>)?.forEach { println((it as? String) ?: "Не является строкой")} ?: println("Ошибка при попытке преобразования типа в List<*>")
}

fun main() {
    //Задача 1
    analyzeDataType("Привет")
    analyzeDataType(4)
    analyzeDataType(4.0)
    analyzeDataType(listOf<Any>(2, "Привет"))
    analyzeDataType(mapOf(2 to "223"))
    analyzeDataType(null)
    //Задача 2
    println(safeCastToList(2))
    println(safeCastToList(listOf(2,3,5,6)))
    //Задача 3
    println(getStringLengthOrZero(2511))
    println(getStringLengthOrZero("Четыре"))
    //Задача 4
    println(5.0.toSquare())
    println(2.toSquare())
    println("3.0".toSquare())

    //Задача 5
    println(sumIntOrDoubleValues(listOf(5,5,"афф",5.0)))
    //Задача 6
    println(tryCastToListAndPrint(listOf(1,2,3,"4","5",4.0)))
    println(tryCastToListAndPrint(225151))
}