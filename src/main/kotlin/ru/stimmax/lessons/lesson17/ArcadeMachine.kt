package ru.stimmax.lessons.lesson17

class ArcadeMachine(val name: String, val model: String, private var pin: String = "1111") {
    private var isOn = false
    private var isOsLoaded = false
    private var installedGame = mutableListOf<String>("CS2", "Dota 2", "Hots")
    private var hasJoystic = true
    private var balance = 0.0
    private var supportPhoneNumber = "+7777777777"
    private var isSessionPaid = false
    private var gameSessionPrice = 20.0
    private var owner: String =""

    fun turnOn() {
        if (isOn) {
            println("Игровой автомат уже включен")
        } else {
            isOn = true
            println("Включил игровой автомат")
            loadOs()
        }
    }

    fun turnOff(){}


    private fun loadOs(){
        isOsLoaded = true
        println("Загрузил ОС")
    }

    private fun
}