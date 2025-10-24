package ru.stimmax.lessons.lesson14

class Rack(var shelvesCount: Int) {
    private val shelves: MutableList<Shelf> = mutableListOf<Shelf>()


    //Добавление Полки (addShelf):
    //Добавляет новую полку в стеллаж.
    //Возвращает true, если полка была успешно добавлена или false если стеллаж уже заполнен или была попытка добавить полку которая уже установлена.
    fun addShelf(sh: Shelf): Boolean {
        if (shelves.size < shelvesCount && !shelves.contains(sh)) {
            shelves.add(sh)
            return true
        }
        return false
    }

    //Удаление Полки (removeShelf):
    //Принимает индекс полки для удаления.
    //Удаляет полку по указанному индексу.
    //Возвращает список предметов полки, если полка была успешно удалена или пустой список если полка не существует.

    fun removeShelf(i: Int): List<String> {
        var b = listOf<String>()
        if (shelves.size >= i) {
            b = shelves[i].getItems()
            shelves.removeAt(i)
        }
        return b
    }

    //Удаление Предмета (removeItem):
    //Находит и удаляет только один предмет с любой полки.
    //Возвращает true, если предмет был удален, и false, если такой предмет не найден.

    fun removeItem(item: String): Boolean {
        for (x in shelves) {
            if (x.containsItem(item)) {
                x.removeItem(item)
                return true
            }
        }
        return false
    }

    //Проверка наличия предмета на стеллаже (containsItem):
    //Возвращает true если предмет есть на одной из полок

    fun containsItem(item: String): Boolean {
        return shelves.any{it.containsItem(item)}
    }

    //Получение списка полок (getShelves):
    //Возвращает неизменяемый список полок

    fun getShelves(): List<Shelf> {
        return shelves.toList()
    }

    //Печать Содержимого (printContents):
    //Выводит в консоль информацию о каждой полке: индекс, вместимость, оставшуюся вместимость, список предметов. Информацию выводить в наглядном читаемом виде

    fun printContents() {
        var pat: String = "%d вместимость: %d доступно: %d"
        for(x in shelves.indices){
            println(pat.format(x,shelves[x].capacity,(shelves[x].capacity-shelves[x].getItems().sumOf { it.length })))
            println(shelves[x].getItems().joinToString( " , "))
        }
    }

    //Сложное удаление полки (advancedRemoveShelf):
    //Принимает индекс полки для удаления
    //Перераспределяет предметы по имеющимся полкам, начиная с самых длинных. Если очередной предмет никуда не вмещается, его нужно пропустить и попробовать разместить следующий.
    //Удаляет полку с оставшимися предметами
    //Возвращает неизменяемый список предметов, которые не удалось удалить или пустой список если полки с таким индексом нет.
    fun advancedRemoveShelf(index: Int): List<String> {
        if (index !in shelves.indices) {
            return emptyList()
        }
        val notReplacedItems = mutableListOf<String>()
        val otherShelves = shelves - shelves[index]
        for (item in shelves[index].getItems()) {
            if (otherShelves.none { it.addItem(item) }) {
                notReplacedItems.add(item)
            }
        }
        shelves.removeAt(index)
        return notReplacedItems.toList()
    }
}
