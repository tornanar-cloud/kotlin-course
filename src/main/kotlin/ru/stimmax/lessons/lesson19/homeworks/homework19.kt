package ru.stimmax.lessons.lesson19.homeworks

/*
1)Напиши функцию getMiddleElement с дженериком, которая будет принимать список и возвращать средний элемент,
 если он существует, иначе возвращать null. Например, у списка из четырёх элементов - среднего элемента нет.
 */
fun <T> getMiddleElement(list: List<T>): T? {
    var a: T? = null
    if (list.size % 2 != 0) {
        a = list[list.size / 2] // 0 1 2 4 5 - 5/2 = 2 |  0 1 2 3 4 5 6 - 7/2 = 3
    }
    return a
}

/*
2)Напиши класс ListHolder, который будет хранить список элементов типа T и
иметь метод для добавления нового элемента и получения всех элементов в виде неизменяемого списка.
 */
class ListHolder<T>(val list: MutableList<T>) {
    fun addElement(arg: T) {
        list.add(arg)
    }

    fun getAll(): List<T> {
        return list.toList()
    }
}

/*
3)Создай интерфейс Mapper с двумя дженериками, который будет определять методы для преобразования:
1.элементов одного типа в элементы другого типа
2.списка элементов одного типа в список элементов другого типа
 */

interface Mapper<T, V> {
    fun convert(arg: T): V
    fun convertList(list: List<T>): List<V>
}


/*
4)Создай класс PhrasesToListOfStrings и имплементируй интефрейс Mapper с типами String и List<String>.
Метод преобразования должен разбивать входящую строку по символу пробела и возвращать список из полученных слов. Метод преобразования списков с аналогичной механикой.
 */
class PhrasesToListOfStrings() :
    Mapper<String, List<String>> {
    override fun convert(arg: String): List<String> {
        return arg.split(" ")
    }

    override fun convertList(list: List<String>): List<List<String>> {
        var tmp = mutableListOf<List<String>>()
        list.forEach { tmp.add(it.split(" ")) }
        return tmp.toList()
    }
}

/*
5)Создай функцию transposition с двумя дженериками, которая принимает словарь с дженериками и возвращает словарь, в котором ключ и значения поменялись местами.
 */
fun <T,V> transposition(map: Map<T,V>): Map<V,T> {
    val m = mutableMapOf<V,T>()
    map.forEach {m[it.value] = it.key}
    return m.toMap()
}

/*

 */

fun main() {
    val v = PhrasesToListOfStrings()
    println(v.convert("Кабы не было зимы в городах и сёлах."))
    var l = listOf<String>("Привет как дела","ой замечательно вообще","Я так за тебя рад" )
    println(v.convertList(l))

    val m = mapOf(
        1 to "Январь",
        2 to "Февраль",
        3 to "Март",
        4 to "Апрель",
        5 to "Май",
        6 to "Июнь",
        7 to "Июль",
        8 to "Август",
        9 to "Сентябрь",
        10 to "Октябрь"
    )
    println(transposition(m))

}