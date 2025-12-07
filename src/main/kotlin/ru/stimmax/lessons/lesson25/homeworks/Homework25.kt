package ru.stimmax.lessons.lesson25.homeworks

val myFunction = {
    val list = List(10000000) { (0..10000).random() }
    list.sorted()
}

fun  timeTracker(f: () -> List<Int>): Long{
    val currentTime = System.currentTimeMillis()
    f()
    val finishtime = System.currentTimeMillis()
    return finishtime - currentTime
}


fun main() {
   println( timeTracker(myFunction))

}

class Person(val name: String, val age: Int) {
    var email: String = ""
}

class Employee(val name: String, val age: Int, val position: String) {
    var email: String = ""
    var department: String = "General"
}