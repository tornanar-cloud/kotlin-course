package ru.stimmax.lessons.lesson16.homeworks.shapes

class Circle(val radius: Double) : Shape() {
    override fun area(): Double {
        return 3.14 * (radius * radius)
    }

//S = π * r²
}