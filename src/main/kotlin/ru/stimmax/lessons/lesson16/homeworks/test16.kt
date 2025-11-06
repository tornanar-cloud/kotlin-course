package ru.stimmax.lessons.lesson16.homeworks
/*
import ru.stimmax.lessons.lesson16.homeworks.animals.Animal
import ru.stimmax.lessons.lesson16.homeworks.animals.Bird
import ru.stimmax.lessons.lesson16.homeworks.animals.Cat
import ru.stimmax.lessons.lesson16.homeworks.animals.Dog
import ru.stimmax.lessons.lesson16.homeworks.logger.Logger
import ru.stimmax.lessons.lesson16.homeworks.printer.InkjetPrinter
import ru.stimmax.lessons.lesson16.homeworks.printer.LaserPrinter
import ru.stimmax.lessons.lesson16.homeworks.productBasket.ProductBasket
import ru.stimmax.lessons.lesson16.homeworks.shapes.Circle
import ru.stimmax.lessons.lesson16.homeworks.shapes.Shape
import ru.stimmax.lessons.lesson16.homeworks.shapes.Square
import ru.stimmax.lessons.lesson16.homeworks.shapes.Triangle
import java.io.IOException
import kotlin.jvm.Throws
import kotlin.math.sqrt

fun main() {
    val a = mutableListOf<Animal>()
    var i = 0
    for (x in 0..10) {
        when (i) {
            0 -> {
                a.add(Dog()); i++
            }

            1 -> {
                a.add(Cat()); i++
            }

            2 -> {
                a.add(Bird()); i = 0
            }
        }
    }
    println(a.isEmpty())

    a.forEach { it.makeSound() }

    val s1 = Circle(6.0)
    val s2 = Square(5.0)
    val s3 = Triangle(8.0, 10.0, 30.0)
    val s4 = listOf<Shape>(s1, s2, s3)
    s4.forEach { println(it.area()) }

    val y1 = LaserPrinter()
    y1.print("Привет Андрей. Как вообще оно?")

    val s5 = InkjetPrinter().print(
        "Прогуливаясь ранним утром по пустынному берегу моря, я видел, как первые солнечные лучи медленно окрашивали " +
                "спокойные волны в нежные оттенки розового и золотого, а прохладный ветер приносил запах свежести и лёгкого ожидания нового дня."
    )


    val products = mapOf(
        "Apple" to 10,
        "Banana" to 6,
        "Orange" to 12,
        "Milk" to 2,
        "Bread" to 4,
        "Eggs" to 30,
        "Cheese" to 3,
        "Tomato" to 8,
        "Potato" to 15,
        "Coffee" to 1
    )

    val s6 = ProductBasket(products.toMutableMap())
    s6.addToCart("Хорошие пельмени", 32)
    print(s6.toString())

    s6.addToCart(
        mapOf(
            "Apple" to 5,      // было в прошлом словаре
            "Milk" to 1,       // было в прошлом
            "Bread" to 2,      // было в прошлом
            "Water" to 6,      // новый
            "Chocolate" to 3,  // новый
            "Pasta" to 4       // новый
        )
    )
    println(s6.toString())

    s6.addToCart(
        mapOf(
            "Apple" to 4,       // из прошлого
            "Milk" to 3,        // из прошлого
            "Cheese" to 2,      // из прошлого
            "Juice" to 5,       // новый
            "Rice" to 7,        // новый
            "Tea" to 1          // новый
        )
    )

    println(s6.toString())

    val s7 = Logger()
    s7.log("Опача, ошибочка!")
    s7.log("Пу-пу-пу", "WARNING")
    s7.log("Пу-пу-пу", "ERROR")

    s7.log(listOf(
        "Application started",
        "Loading configuration file",
        "User 'admin' logged in",
        "Disk space is running low",
        "Failed to connect to database",
        "Retrying connection attempt",
        "Database connection established",
        "New order #5432 created",
        "High memory usage detected",
        "Unhandled exception in worker thread"
    ))

    s7.log(Exception("Ошибка"))
}
*/