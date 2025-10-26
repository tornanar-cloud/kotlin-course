package ru.stimmax.lessons.lesson15.homeworks

open class Polygon(
    type: String,
    var numberSides: Int
    ) : Figure(type) {

    fun printNumberOfSides() {
        println(numberSides)
    }

    fun getNumberOfSides(): Int {
        val a : Int = numberSides
        return a
        //Выдают ошибку сигнатуры, если делать return numberOfSides. Не будет ошибки, если numberOfSides сделать приватным
    }
}


