package ru.stimmax.lessons.lesson14

fun main() {
    val v1 = Emotion("Злость", -1)
    var v2 = Emotion("Злость", 5)
    var v3 = Emotion("Злость", 12)
    v1.express(v1.intensity)
    v2.express(v2.intensity)
    v3.express(v3.intensity)

    //4
    println(Moon.showPhase())
    Moon.isVisible = false
    println(Moon.showPhase())

    //5
    Concert("Вайяяяя","Задний двор",0.0,10).detailsPrint()

}

/* 1. Событие: вечеринка. Создайте класс Party, который описывает вечеринку. У него должны быть свойства location (String) и
attendees (Int). Добавьте метод details(), который выводит информацию о месте проведения и количестве гостей.
*/
class Party(var location: String, var attendees: Int) {
    fun details() {
        println("Вечеринка проходит в локации $location. Присутствующих - $attendees")
    }
}


/* 2. Аспект реальности: эмоция. Создайте класс Emotion, который представляет эмоцию. У него должно быть свойство type (String) и intensity (Int). Добавьте метод express(),
который выводит описание эмоции в зависимости от её типа и интенсивности.*/

class Emotion(val type: String, var intensity: Int) {
    fun express(intensity: Int) {
        println(
            when {
                intensity < 0 -> "$type вообще есть?"
                intensity in 1..10 -> "$type средней интенсивности"
                else -> "Пу пу пу"
            }
        )
    }
}

/*
3. Природное явление: луна. Создайте объект Moon, который будет представлять Луну. Добавьте свойства isVisible (Boolean), чтобы отображать, видна ли Луна в данный момент, и phase (String), чтобы отображать текущую фазу Луны
(например, "Full Moon", "New Moon"). Добавьте метод showPhase(), который выводит текущую фазу Луны.
 */

object Moon {
    var isVisible: Boolean = true
    var phase: String = "new moon"
    fun showPhase() {
        if (isVisible) {
            println("Фаза луны - $phase")
        } else println("НИЧЕГО НЕ ВИДНО")
    }
}


/*
4. Покупка: продукт. Создайте дата класс для продукта, который будет представлять продукт в магазине. У него должны быть свойства “название”, “цена”, “количество”.

*/
data class product(val name: String, var price: Double, var quantity: Int)


/* 5.
Мероприятие: концерт. Создайте класс, который будет представлять концерт. У него должны быть свойства “группа”, “место проведения”, “стоимость”, “вместимость зала”.
Также приватное поле “проданные билеты”. Добавьте метод, который выводит информацию о концерте и метод “купить билет”, который увеличивает количество проданных билетов на один.
 */
class Concert(val group: String, val location: String, val price: Double, val capacity: Int) {
    private var tickets: Int = 0
    fun buyTicket() {
        if (tickets < capacity) {
            tickets += 1
        }else println("А мест больше нет")
    }

    fun detailsPrint(){
        println("Выступает группа - $group\nМесто проведения - $location\nФиксированная цена - $price\nВместительность зала - $capacity\nОсталось билетов - ${capacity-tickets}")
    }


}