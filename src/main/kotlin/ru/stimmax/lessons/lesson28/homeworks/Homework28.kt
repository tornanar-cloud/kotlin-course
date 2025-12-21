package ru.stimmax.lessons.lesson28.homeworks

import jdk.jfr.Period
import ru.stimmax.lessons.lesson16.homeworks.printer.Printer
import ru.stimmax.lessons.lesson25.homeworks.Person
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.Temporal
import java.util.logging.Formatter
import javax.swing.text.DateFormatter

fun main() {
//1. Создай текущую метку времени и выведи её на печать (чтобы ещё раз запомнить название этого класса)
    val instant = Instant.now()
    println(instant)
//2. Создай дату своего дня рождения.
    val myBirthday = LocalDate.of(1989,10,11)

//3. Создай период между датой своего рождения и текущей датой. Выведи на печать количество лет из этого периода.
    val period = java.time.Period.between(myBirthday, LocalDate.now())
    println(period.years)

//4. Создай функцию, которая принимает тип Temporal и выводит форматированное значение в зависимости от того, содержит ли аргумент время и часовой пояс.
// Temporal - это общий тип для разных классов даты-времени. В форматированном значении нужно выводить часы, минуты, секунды и таймзону,
// если они представлены в переданном объекте. Обработай в методе все типы дат, которые знаешь. Реализуй два варианта функции - с собственный
// форматированием и с форматами из ISO коллекции.


//5 Создай объекты дат и / или времени которые мы изучили и по очереди передай их в метод созданный выше. Не используй в них метод now()
fn41(LocalDate.of(1989,10,11))
fn41(LocalTime.of(23,22,1))
fn41(LocalDateTime.of(1989,10,11,23,22,1))
fn41(ZonedDateTime.of(1989,10,11,23,22,1,0, ZoneId.of("Europe/Moscow")))
fn41(OffsetDateTime.of(1989,10,11,23,22,1,0, ZoneOffset.of("+03:00")))


//6
    LocalDate.of(1945,12,2).identifyGeneration()
    LocalDate.of(1964,12,31).identifyGeneration()
    LocalDate.of(1996,12,12).identifyGeneration()
    LocalDate.of(1997,12,12).identifyGeneration()
    LocalDate.of(2013,12,12).identifyGeneration()

    //7. Создай два объекта даты: 25 февраля 2023 года и 25 февраля 2024 года. Создай форматтер, который форматирует дату в месяц и день.
    //8. Выведи первую отформатированную дату, прибавив к ней 10 дней.
    //9. Выведи вторую отформатированную дату, прибавив к ней 10 дней. Найди отличия)))
    val f = DateTimeFormatter.ofPattern("MM-dd")
    println(LocalDate.of(2023,2,25).plusDays(10).format(f))
    println(LocalDate.of(2024,2,25).plusDays(10).format(f))
}
//4. Создай функцию, которая принимает тип Temporal и выводит форматированное значение в зависимости от того, содержит ли аргумент время и часовой пояс.
// Temporal - это общий тип для разных классов даты-времени. В форматированном значении нужно выводить часы, минуты, секунды и таймзону,
// если они представлены в переданном объекте. Обработай в методе все типы дат, которые знаешь. Реализуй два варианта функции - с собственный
// форматированием и с форматами из ISO коллекции.
private fun fn41(t: Temporal){
    when(t){
        is LocalDate -> println(t)
        is LocalTime -> println(t)
        is LocalDateTime -> println(t)
        is ZonedDateTime -> println(t.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS ZZZ z")))
        is OffsetDateTime -> println(t.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS ZZZ")))
        else -> println("Тип даты не учтён")
    }
}
private fun fn42(t: Temporal){
    when(t){
        is LocalDate -> println(t)
        is LocalTime -> println(t)
        is LocalDateTime -> println(t)
        is ZonedDateTime -> println(t.format(DateTimeFormatter.ISO_ZONED_DATE_TIME))
        is OffsetDateTime -> println(t.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME))
        else -> println("Тип даты не учтён")
    }
}
//6. Создайте функцию identifyGeneration, которая расширяет класс LocalDate и печатает строку, определяющую,
// к какому поколению принадлежит человек родившийся в эту дату: "Бумер" для тех, кто родился с 1946 по 1964 год включительно,
// и "Зумер" для тех, кто родился с 1997 по 2012 год включительно. Если дата рождения не попадает ни в один из этих диапазонов,
// функция должна печатать "Не определено". Для сравнения дат используй методы isAfter(otherDate) и isBefore(otherDate) или проверку вхождения в диапазон.
// Объекты с эталонными датами вынеси в приватные поля файла с методом identifyGeneration.

fun LocalDate.identifyGeneration(){
    when{
        this.isAfter(LocalDate.of(1945,12,31)) && this.isBefore(LocalDate.of(1965,1,1)) -> println("Бумер")
        this.isAfter(LocalDate.of(1996,12,31)) && this.isBefore(LocalDate.of(2013,1,1)) -> println("Зумер")
        else -> println("Не определенно")
    }
}