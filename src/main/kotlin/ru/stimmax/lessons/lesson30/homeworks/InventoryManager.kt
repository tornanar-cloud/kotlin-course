package ru.stimmax.lessons.lesson30.homeworks

class InventoryManager (private val capacity: Int){

    private val items = mutableMapOf<String, Int>()

    /**
     * Метод возвращает количество инвентаря. Если наименования нет, возвращает 0
     */
    fun getItemCount(itemName: String): Int {
        return items.getOrDefault(itemName,0)
    }

    /**
     * Добавляет инвентарь в хранилище к существующему.
     * @param itemName название инвентаря
     * @param quantity количество инвентаря
     * @throws IllegalStateException в случае, если допустимое количество может быть превышено
     */
    fun addItem(itemName: String, quantity: Int) {
        if(quantity > 0) {
            checkCapacity(quantity)
            items[itemName] = getItemCount(itemName) + quantity
        }else if(quantity==0){
            println("Ничего не делал. Нет смысла добавлять 0.")
        }
        else  println("Ничего не делал. Количество отрицательным быть не может.")


    }

    /**
     * Удаляет инвентарь из хранилища
     * @param itemName название инвентаря
     * @param quantity количество инвентаря для удаления
     * @return true если удаление произошло и false если удаление невозможно, например нет наименования или нужного количества
     */
    fun removeItem(itemName: String, quantity: Int): Boolean {
        val currentQuantity = items[itemName]
        if (currentQuantity == null || quantity > currentQuantity) {
            return false
        }
        items[itemName] = currentQuantity - quantity
        if (items[itemName] == 0) {
            items.remove(itemName)
        }
        return true
    }

    /**
     * Проверяет, что количество объектов в инвентаре с учётом добавляющихся не превысит допустимого количества
     * @param itemsForAdding количество объектов для добавления
     * @throws IllegalStateException в случае, если допустимое количество может быть превышено
     */
    private fun checkCapacity(itemsForAdding: Int) {
        check(capacity - items.values.sum() >= itemsForAdding) {
            "Количество инвентаря не должно превышать $capacity единиц"
        }
    }

}