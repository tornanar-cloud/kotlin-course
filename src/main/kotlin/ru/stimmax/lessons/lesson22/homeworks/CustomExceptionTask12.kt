package ru.stimmax.lessons.lesson22.homeworks

// Задание 12. Создай свой тип исключения в отдельном файле, наследуемый от RuntimeException и принимающий
// IndexOutOfBoundsException тип в качестве аргумента. Напиши код, который спровоцирует выброс IndexOutOfBoundsException,
// перехвати его с помощью try-catch и в блоке catch выведи сообщение в консоль и сделай выброс своего типа исключения.

class CustomException12(e: IndexOutOfBoundsException): RuntimeException(e)

fun main() {
    val a = listOf<Int>(1,2,3,4)
    try {
        val b = a[5]
    }catch (e: IndexOutOfBoundsException) {
        println(e)
        throw CustomException12(e)
    }
}