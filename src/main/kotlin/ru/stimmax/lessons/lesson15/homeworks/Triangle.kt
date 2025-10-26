package ru.stimmax.lessons.lesson15.homeworks


class Triangle(type: String, val sideA: Double, val sideB: Double, val sideC: Double,): Polygon(type,3) {
    var typeTriangle: String = "Не определен"
    var isTriangleValid: Boolean = sideA + sideB > sideC && sideA + sideC > sideB && sideC + sideB > sideA
    //много много кода

}

