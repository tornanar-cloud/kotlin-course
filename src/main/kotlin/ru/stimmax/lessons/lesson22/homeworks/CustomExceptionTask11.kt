package ru.stimmax.lessons.lesson22.homeworks
//Задание 11. Создай свой тип исключения в отдельном файле, наследуемый от AssertionError и принимающий текст. Выброси это исключение в main
class CustomException11(m: String) : AssertionError(m)


fun ce1(){
    throw CustomException11("Ошибка из метода ce1")
}

fun main() {
    ce1()
    try {
        ce1()
    }catch (e: CustomException11){
        println(e)
    }
}