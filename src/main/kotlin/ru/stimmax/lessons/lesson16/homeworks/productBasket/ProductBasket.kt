package ru.stimmax.lessons.lesson16.homeworks.productBasket

class ProductBasket(private val cart: MutableMap<String, Int>) {

    fun addToCart(itemId: String) {
        cart[itemId] = cart.getOrDefault(itemId, 0) + 1
    }

    fun addToCart(itemId: String, amount: Int){
        cart[itemId] = cart.getOrDefault(itemId, 0) + amount
    }

    fun addToCart(itemsAndAmount: Map<String, Int>){
        for ((key,value ) in itemsAndAmount ){
            cart[key] = cart.getOrDefault(key, 0) + value
        }
    }

    fun addToCart(ids: List<String>){
        for (x in ids){
            cart[x] = cart.getOrDefault(x, 0) + 1
        }
    }


    override fun toString(): String {
        var r ="Артикулов - ${cart.size}. Общее количество товаров - ${cart.values.sum()}\n"
        for ((k,v) in cart){
            r = r + "Название продукта: $k , количество - $v\n"
        }
        return r.trim() + "\n"
    }
}