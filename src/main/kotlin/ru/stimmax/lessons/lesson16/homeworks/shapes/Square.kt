package ru.stimmax.lessons.lesson16.homeworks.shapes

class Square(val s: Double) : Shape() {
    override fun area(): Double {
        return s * s
    }
}