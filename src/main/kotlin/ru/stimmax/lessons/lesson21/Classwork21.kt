package ru.stimmax.lessons.lesson21

fun main() {
    val obj: Any = "Hello, World!"
    if (obj is String) {
        println("Объект является строкой")

    }
    if (obj !is Int) {
        println("Объект не является целым числом")
    }



    val nullableStr: String? = "Kotlin"
    val nonNullableStr: String = nullableStr as String // Явное приведение типа

    println(nullableStr is String?)
    println(nonNullableStr is String?)
}
interface W1{}
interface W2{}
class W3: W1, W2{}