package ru.stimmax.lessons.lesson25.homeworks

import ru.stimmax.lessons.lesson14.product

//Задание 1. Функция высшего порядка.
//Создайте функцию timeTracker, которая принимает другую функцию в качестве аргумента и измеряет время её выполнения.
// Функция timeTracker должна возвращать затраченное время в миллисекундах. Для измерения времени используйте System.currentTimeMillis() до
// и после выполнения переданной функции.
//
//Для проверки результата можно выполнить в ней например такой ресурсоёмкий код:
val myFunction = {
    val list = List(10000000) { (0..10000).random() }
    list.sorted()
}

fun timeTracker(f: () -> List<Int>): Long {
    val currentTime = System.currentTimeMillis()
    f()
    val finishtime = System.currentTimeMillis()
    return finishtime - currentTime
}


class Person(val name: String, val age: Int) {
    var email: String = ""
}

class Employee(val name: String, val age: Int?, val position: String) {
    var email: String = ""
    var department: String = "General"
}


fun main() {
    // Задание 2: Использование apply для инициализации объекта Employee
    // Создайте объект Employee и используйте apply для инициализации его полей email и department.
    val e1 = Employee("Ваня", 23, "Важный человек").apply {
        email = "vch@gmail.com"
        department = "Департамент важных дел"
    }
    println("email - ${e1.email}\nДепартамент - ${e1.department} ")

    // Задание 3: Использование also для логирования
    // Создайте функцию, принимающую объект Person и выводящую информацию об объекте в консоль в красивом, отформатированном виде.
    // Используй with для создания контекста Person и возможности использовать поля объекта напрямую без обращения к переменной.
    // Создайте объект Person и используйте also для добавления почты и печати данных в консоль с помощью метода который только что создали.
    Person("Руслан", 33).also {
        it.email = "chikibriki@yandex.ru"
        personInfoPrint(it)
    }
    //Задание 4: Использование with для преобразование Person в Employee
    //Создайте объект класса Person. Используйте функцию with, чтобы создать из этого объекта Employee, указав дополнительно должность.
//   Возвращаемым значением должен быть новый объект Employee.
    val p1 = Person("Руслан", 56)
    var e2: Employee? = null

    with(p1){
      e2 =  Employee(p1.name,p1.age,"Важный человек")
    }

    val e3 = p1.run { Employee(p1.name,p1.age,"Важный человек") }


    //Задание 6: Использование let для безопасного преобразования Person в Employee
    //Создайте функцию toEmployee, которая расширяет класс Person, который может быть null.
    // В функции используйте функцию let для создания Employee, только если объект Person не null. В противном случае возвращается null

    if(e2 is Employee){
        println("Это работник")
    }

    val e4 = null//Person("Первый",22).toEmployee()
    e4?.let {employeeInfoPrint(e4)} ?: println("Нет такого работника")
    val e5 = Person("Второй",24).toEmployee()
    e5?.let {employeeInfoPrint(e5)}
}

// Задание 3: Использование also для логирования
// Создайте функцию, принимающую объект Person и выводящую информацию об объекте в консоль в красивом, отформатированном виде.
// Используй with для создания контекста Person и возможности использовать поля объекта напрямую без обращения к переменной.
fun personInfoPrint(p: Person) {
    with(p) {
        println("Имя - $name\nВозраст - $age")
    }
}
///Задание 6: Использование let для безопасного преобразования Person в Employee
// Создайте функцию toEmployee, которая расширяет класс Person, который может быть null.
// В функции используйте функцию let для создания Employee, только если объект Person не null. В противном случае возвращается null
fun Person?.toEmployee(): Employee?{
    return this?.let { Employee(this.name,this.age,"Важный человек") }
}


fun employeeInfoPrint(e: Employee) {
    with(e) {
        println("Имя - $name\nВозраст - $age\nДолжность - $position")
    }
}