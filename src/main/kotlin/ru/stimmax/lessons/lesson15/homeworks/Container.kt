package ru.stimmax.lessons.lesson15.homeworks

fun main() {
    /*
        val m = Child1("Я первый под нулевым индексом")
        println(m)
        m.addFirst()
        m.printContainer()
        "twenty first"

        val m2 = Child2(listOf("Первый", "Третий","Пятый"))
        m2.insertOneByOne()
        m2.printContainer()


    val m3 = Child3("twenty first")
    m3.addPlusSort()
    m3.printContainer()

     */

    val m4 = Child4(mapOf(1 to "первый", 2 to "второй", 3 to "Третий"))
    m4.insertMap()
    m4.printContainer()
}

abstract class Materials {
    private val materials = mutableListOf<String>(
        "first", "second", "third", "fourth", "fifth",
        "sixth", "seventh", "eighth", "ninth", "tenth",
        "eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth",
        "sixteenth", "seventeenth", "eighteenth", "nineteenth", "twentieth"
    )

    fun addMaterial(material: String) {
        materials.add(material)
    }

    fun extractMaterials(): List<String> {
        val extracted = materials.toList()
        materials.clear()
        return extracted
    }

    fun printContainer() {
        materials.forEachIndexed { index, layer ->
            println("[$index]: $layer")
        }
    }
}


//4. Первый класс должен вставлять строку на дно контейнера (должно появиться под индексом 0)
class Child1(val s: String) : Materials() {

    fun addFirst() {
        var b = extractMaterials().toMutableList()
        b.add(0, s)
        b.forEach { addMaterial(it) }
    }
}


//5. Второй класс должен получать список строк и вставлять их в начало контейнера но поочерёдно с теми данными, которые уже есть.
// То-есть, наш список должен появиться в контейнере по индексам 0, 2, 4 и так далее.
class Child2(val list: List<String>) : Materials() {


    fun insertOneByOne() {
        val mat = extractMaterials()
        val index = if (list.size > mat.size) list.size else mat.size
        for (x in 0..index) {
            if (x < list.size) {
                addMaterial(list[x])
            }
            if (x < mat.size) {
                addMaterial(mat[x])
            }
        }
    }
}

//6. Третий класс при добавлении строки должен отсортировать весь список метериалов в алфавитном порядке включая добавляемый материал.
class Child3(val s: String) : Materials() {

    fun addPlusSort() {
        val mat = extractMaterials()
        val b = (mat + listOf<String>(s)).sorted()
        for (x in b) {
            addMaterial(x)
        }
    }
}


//7.Четвёртый класс должен принимать словарь (ключи и значения строки). Каждая пара ключа и значения должна попадать в контейнер следующим образом - ключ в начало, значение в конец.
// Таким образом в начале должны быть ключи в обратном порядке, потом существующие материалы, потом все значения.

class Child4(val map: Map<Int, String>) : Materials() {


    fun insertMap() {
        val mat = extractMaterials().toMutableList()
        map.forEach { key, value ->
            mat.addFirst(key.toString())
            mat.addLast(value)
        }
        for (x in mat){
            addMaterial(x)
        }
    }
}