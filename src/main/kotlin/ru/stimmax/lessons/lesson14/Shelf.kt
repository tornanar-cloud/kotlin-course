package ru.stimmax.lessons.lesson14

class Shelf(val capacity: Int, var items: MutableList<String>) {


    //Вместимость полки (capacity): максимальная сумма букв всех названий предметов, которые могут быть размещены на полке.
    //Список предметов (items): хранит названия предметов на полке.

    //Добавление Предмета (addItem):
    //Принимает название предмета.
    //Проверяет, поместится ли предмет на полку, учитывая длину его названия и текущее заполнение полки.
    //Возвращает true и добавляет предмет, если есть место. В противном случае возвращает false.
    fun addItem(item: String): Boolean {
        var b = false
        if (canAccommodate(item)) {
            items.add(item)
            b = true
        }
        return b
    }

    //Удаление Предмета (removeItem):
    //Принимает название предмета.
    //Удаляет предмет, если он найден на полке.
    //Возвращает true, если предмет был удален, и false, если такой предмет не найден.

    fun removeItem(item: String): Boolean {
        return items.remove(item)
    }

    //Проверка Вместимости (canAccommodate):
    //Принимает название предмета.
    //Определяет, вместится ли предмет на полку.
    //Возвращает true, если предмет вместится, и false, если места недостаточно.
    fun canAccommodate(item: String): Boolean {
        return (item.length + items.sumOf { it.length } <= capacity)
    }

    //Проверка наличия предмета (containsItem):
    //Принимает название предмета
    //Возвращает true если такой предмет есть
    fun containsItem(item: String): Boolean {
        return items.contains(item)
    }

    //Получение списка предметов (getItems):
    //Возвращает неизменяемый список предметов
    fun getItems(): List<String> {
        return items.toList()
    }


}


