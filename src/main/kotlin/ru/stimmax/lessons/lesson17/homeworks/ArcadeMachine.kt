package ru.stimmax.lessons.lesson17.homeworks

class ArcadeMachine(val name: String, val model: String, private var pin: String = "1111", val color: String) {
    private var isOn = false
    private var isOsLoaded = false
    private val installedGames = mutableListOf<String>("CS2", "Dota 2", "Hots")
    val hasJoystic = true
    private var balance = 0.0
    var supportPhoneNumber = "+7777777777"
        private set
    private var isSessionPaid = false
    var gameSessionPrice = 20.0
        private set
    private var owner: String = ""

    fun turnOn() {
        if (isOn) {
            println("Игровой автомат уже включен")
        } else {
            isOn = true
            println("Включил игровой автомат")
            loadOs()
        }
    }

    fun turnOff() {
        unloadOs()
        isOn = false
        println("Игровой автомат выключен")
    }


    private fun loadOs() {
        isOsLoaded = true
        println("Загрузил ОС")
    }

    private fun unloadOs() {
        isOsLoaded = false
        println("Выгрузил ОС")
    }

    fun showInstalledGames() {
        println(installedGames)
    }

    fun startGame(game: String) {
        if (installedGames.contains(game)) {//Проверит есть ли игра в списке
            if (isSessionPaid) {
                println("Запустил игру.\n Играем в игру $game\nЗакончили играть")
                isSessionPaid = false
            } else {
                println("Нужно оплатить игровую сессию")
            }
        } else println("Игра не установлена")
    }

    fun payGameSession() {
        if (balance >= gameSessionPrice) {
            balance -= gameSessionPrice
            isSessionPaid = true
            println("Игровая сессия оплачена")
        } else {
            println("Недостаточно средств на балансе")
        }
    }

    fun addToBalance(amount: Double) {
        balance += Math.abs(amount)
        println("Пополнение прошло успешно. Текущий баланс $balance")
    }

    fun withdrawCash(pin: String): Double {
        return if (this.pin == pin) {
            openSafeAndDispenseCash()
        } else {
            println("Неверный пин")
            0.0
        }
    }

    private fun openSafeAndDispenseCash(): Double {
        val a = balance
        balance = 0.0
        return a
    }
}