package ru.stimmax.lessons.lesson16.homeworks.shapes



class Triangle(val sideA: Double, val sideB: Double, val angleAB: Double) : Shape() {
    override fun area(): Double {
        val rad = angleAB*(Math.PI/180.0)
        val b = Math.sin(rad)
        return Math.round((0.5 * (sideA * sideB) * b)*10.0/10.0).toDouble()
    }
}