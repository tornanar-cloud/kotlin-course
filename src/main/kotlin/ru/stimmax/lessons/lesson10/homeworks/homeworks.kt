package ru.stimmax.lessons.lesson10.homeworks

import kotlin.collections.iterator

fun main() {
    //1. Создайте пустой неизменяемый словарь, где ключи и значения - целые числа.
    val map1: Map<Int, Int> = mapOf()

//2. Создайте словарь, инициализированный несколькими парами "ключ-значение", где ключи - float, а значения - double
    val map2: Map<Float, Double> = mapOf(1.0f to 2.0)

//3. Создайте изменяемый словарь, где ключи - целые числа, а значения - строки.
    val mmap3: MutableMap<Int, String> = mutableMapOf<Int, String>(1 to "Адын")
//4. Имея изменяемый словарь, добавьте в него новые пары "ключ-значение".
    mmap3[2] = "Это два"
    //5. Используя словарь из предыдущего задания, извлеките значение, используя ключ. Попробуй получить значение с ключом, которого в словаре нет.
    println(mmap3[3])
    println(mmap3[2])
    //6. Удалите определенный элемент из изменяемого словаря по его ключу.
    mmap3.remove(2)
    println(mmap3)
    //7. Создайте словарь (ключи Double, значения Int)
// и выведи в цикле результат деления ключа на значение. Не забудь обработать деление на 0 (в этом случае выведи слово “бесконечность”)
    val  mmap4: Map<Double, Int> = mapOf(1.0 to 3, 2.0 to 1, 3.0 to 0, 4.0 to 25)
    for ((k,v) in mmap4){
        if (v==0){println("Бесконечность"); continue}
        println(k/v)
    }
    //8. Измените значение для существующего ключа в изменяемом словаре.
    val mmap5: MutableMap<Int, String> = mutableMapOf<Int, String>(1 to "Адын")
    mmap5[1] = "Корги"
    println(mmap5)

    //9. Создайте два словаря и объедините их в третьем изменяемом словаре через циклы.

    val map6: Map<Int, String> = mapOf(1 to "1", 2 to "2", 3 to "3")
    val map7: Map<Int, String> = mapOf(4 to "4", 5 to "5", 6 to "6")
    val mmap8: MutableMap<Int, String> = mutableMapOf()
    for ((k,v) in map6){
        mmap8[k] = v
    }
    for ((k,v) in map7){
        mmap8[k] = v
    }
    println(mmap8)

    //10. Создайте словарь, где ключами являются строки, а значениями - списки целых чисел. Добавьте несколько элементов в этот словарь.
    val mmap9 = mutableMapOf<String, List<Int>>()
    mmap9["Важные дни"] = listOf<Int>(1,2,3,5)
    mmap9["Неважные дни"] = listOf<Int>(4,6,7)
    println(mmap9)

        //11. Создай словарь, в котором ключи - это целые числа, а значения - изменяемые множества строк. Добавь данные в словарь.
// Получи значение по ключу (это должно быть множество строк) и добавь в это множество ещё строку. Распечатай полученное множество.
    val map10 = mutableMapOf<Int, MutableSet<String>>(1 to mutableSetOf("Hello","Kotlin"))
    map10[1]?.add("again")
    println(map10)
    //12. Создай словарь, где ключами будут пары чисел. Через перебор найди значение
// у которого пара будет содержать цифру 5 в качестве первого или второго значения.
    val map11 :Map<Pair<Int, Int>, String> = mapOf((1 to 1)to "Куку",(5 to 1) to "Попався!")
    for ((k,v) in map11){
        if (k.first == 5 || k.second==5){
            println(map11[k])
        }
    }
    //Задачи на подбор оптимального типа для словаря
    //1. Словарь библиотека: Ключи - автор книги, значения - список книг
    val a: MutableMap<String, MutableList<String>> = mutableMapOf("Терри Пратчет" to mutableListOf("Цвет волшебства","Последний континент"))
    //2. Справочник растений: Ключи - типы растений (например, "Цветы", "Деревья"), значения - списки названий растений
    val  a2: MutableMap<String, MutableList<String>> = mutableMapOf<String, MutableList<String>>()
    //3. Четвертьфинала: Ключи - названия спортивных команд, значения - списки игроков каждой команды
    val a3 = mapOf<String, MutableList<String>>()
    //4. Курс лечения: Ключи - даты, значения - список препаратов принимаемых в дату
    val a4 = mapOf<String, MutableList<String>>()
    //5. Словарь путешественника: Ключи - страны, значения - словари из городов со списком интересных мест.
    val a5 = mapOf<String, MutableList<String>>()

}