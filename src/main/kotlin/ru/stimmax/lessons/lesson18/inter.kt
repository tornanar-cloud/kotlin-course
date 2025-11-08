package ru.stimmax.lessons.lesson18

interface Powerable{
    fun turnOn()
    fun turnOff()
    fun move(){}
}

class A : Powerable{
    override fun turnOn() {
        println("Включить")
    }

    override fun turnOff() {
        println("Выключить")
    }

}

fun main() {
    val a = A()
    a.turnOn()
}