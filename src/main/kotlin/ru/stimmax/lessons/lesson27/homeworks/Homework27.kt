package ru.stimmax.lessons.lesson27.homeworks


/*
Задание 1
Создай Enum со статусами прохождения теста (passed, broken, failed).

Создай Enum с типами жилой недвижимости для сайта аренды, включая человекопонятные названия этих типов.

Создай Enum с планетами солнечной системы, включая расстояние до солнца в астрономических единицах и вес планеты.
 */

enum class TestStatus {
    passed,
    broken,
    failed
    ;
}

enum class ResidentialPropertyType(val type: String) {
    APARTMENT("квартира"),        // квартира
    STUDIO("студия"),           // студия
    ROOM("комната"),             // комната
    HOUSE("Дом")             // Дом
    ;

    //Задание 2
//Создай функцию, которая выводит на печать человекочитаемые названия типов недвижимости в порядке возрастания длины названия enum.
    companion object {
        fun printResidentialPropertyTypeInfoBySortEnumName() {
            val b = entries
            b.map { mapOf(it.name to it.type).entries.first() }.sortedBy { it.key.length }
                .forEach { println("Enum - ${it.key} | Тип - ${it.value}") }
        }
    }
}


enum class Planet(
    val distanceFromSunAu: Double,
    val massKg: Double
) {
    MERCURY(
        distanceFromSunAu = 0.39,
        massKg = 3.3011e23
    ),
    VENUS(
        distanceFromSunAu = 0.72,
        massKg = 4.8675e24
    ),
    EARTH(
        distanceFromSunAu = 1.0,
        massKg = 5.97237e24
    ),
    MARS(
        distanceFromSunAu = 1.52,
        massKg = 6.4171e23
    ),
    JUPITER(
        distanceFromSunAu = 5.20,
        massKg = 1.8982e27
    ),
    SATURN(
        distanceFromSunAu = 9.58,
        massKg = 5.6834e26
    ),
    URANUS(
        distanceFromSunAu = 19.20,
        massKg = 8.6810e25
    ),
    NEPTUNE(
        distanceFromSunAu = 30.05,
        massKg = 1.02413e26
    )
    ;
}

//Задание 2
//Создай функцию, которая выводит на печать человекочитаемые названия типов недвижимости в порядке возрастания длины названия enum.


/*
Задание 3
Создай функцию, которая принимает лямбду без аргументов и возвращаемого значения и возвращает
Enum со статусом прохождения теста в зависимости от того как выполнится принятая лямбда:

если без исключений - PASSED
если будет AssertionError - FAILED
прочие исключения  - BROKEN
 */

fun fn3(func: () -> Unit): TestStatus {
    return try {
        func()
        TestStatus.passed
    } catch (e: AssertionError) {
        println(e)
        return TestStatus.failed
    } catch (e: Exception) {
        println(e)
        return TestStatus.broken
    }
}


/*
Задание 4
Создай функцию, которая принимает лямбду и возвращает enum планеты. Лямбда должна принимать планету и возвращать булево значение.
Лямбда здесь выступает в качестве фильтра, который должен отфильтровать список всех планет по какому-либо признаку (расстояние или вес).
Вернуть нужно первый элемент из отфильтрованного списка или выкинуть исключение если список пустой.
 */
fun fn4(p:(Planet) -> Boolean): Planet{
    return Planet
}

fun main() {
    ResidentialPropertyType.printResidentialPropertyTypeInfoBySortEnumName()
}