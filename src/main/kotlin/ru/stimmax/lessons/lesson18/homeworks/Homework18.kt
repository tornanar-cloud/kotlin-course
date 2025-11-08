package ru.stimmax.lessons.lesson18.homeworks

import java.io.InputStream
import java.sql.Time
import kotlin.math.min

class Homework18 {
}

//Интерфейсы для работы

interface Powerable {
    fun powerOn()
    fun powerOff()
}

interface Openable {
    fun open()
    fun close()
}

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}

interface TemperatureRegulatable {
    val maxTemperature: Int
    fun setTemperature(temp: Int)
}

interface WaterConnection {
    fun connectToWaterSupply()
    fun getWater(amount: Int)
}

interface AutomaticShutdown {
    val sensorType: String
    val maxSensoredValue: Int
    fun startMonitoring()
}

interface Drainable {
    fun connectToDrain()
    fun drain()
}

interface Timable {
    fun setTimer(time: Int)
}

interface BatteryOperated {
    fun getCapacity(): Double
    fun replaceBattery()
}

interface Mechanical {
    fun performMechanicalAction()
}

interface LightEmitting {
    fun emitLight()
    fun completeLiteEmission()
}

interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: InputStream)
}

interface Programmable {
    fun programAction(action: String)
    fun execute()
}

interface Movable {
    fun move(direction: String, distance: Int)
}

interface Cleanable {
    fun clean()
}

interface Rechargeable {
    fun getChargeLevel(): Double
    fun recharge()
}


//Задача 1. Создай абстрактные классы устройств, используя эти интерфейсы. Реализовывать методы не нужно.

//Холодильник
abstract class Fridge : Powerable, Openable, TemperatureRegulatable, LightEmitting, Programmable

//Стиральная машина
abstract class Washer : Powerable, Openable, TemperatureRegulatable, WaterContainer, WaterConnection, AutomaticShutdown,
    Cleanable,
    Programmable, Timable, SoundEmitting

//Умная лампа
abstract class SmartLamp : Powerable, AutomaticShutdown, Timable, Mechanical, LightEmitting, SoundEmitting,
    Programmable {}

//Электронные часы
abstract class ElectronicWatches : Powerable, Timable, BatteryOperated, Rechargeable, Programmable, SoundEmitting {}

//Робот-пылесос
abstract class RobotVacuumCleaner : Powerable, Openable, AutomaticShutdown, Timable, BatteryOperated, LightEmitting,
    Programmable,
    Movable, Cleanable, Rechargeable {}

//Механические часы
abstract class MechanicalWatches : Powerable, Timable, Mechanical, SoundEmitting {}

//Фонарик
abstract class Lantern : Powerable, Openable, BatteryOperated, LightEmitting, Programmable {}

//Кофемашина
abstract class CoffeeMachine : Powerable, Openable, WaterContainer, TemperatureRegulatable, AutomaticShutdown,
    Drainable, Timable, SoundEmitting, Programmable, Cleanable {}

//Умная колонка
abstract class SmartSpeaker : Powerable, AutomaticShutdown, Timable, LightEmitting, SoundEmitting, Programmable,
    Rechargeable


//Задача 2. Создай абстрактный класс для включаемого оборудования и имплементируй соответствующий интерфейс с реализацией методов (достаточно println с выполняемым действием).
abstract class BasePowerDevice : Powerable {
    protected var isOn = false
    override fun powerOn() {
        isOn = true
        println("Устройство включено")

    }

    override fun powerOff() {
        isOn = false
        println("Устройство выключено")
    }
}

//Задача 3. Создай абстрактный класс для программируемого оборудования (с имплементацией соответствующего интерфейса и реализацией методов)
// и наследуй его от абстрактного класса включаемого оборудования.
abstract class BaseProgrammableDevice : BasePowerDevice(), Programmable {

    override fun programAction(action: String) {
        if (isOn) {
            println("Запрограммировал действие - $action")
        }
    }

    override fun execute() {
        if (isOn) {
            println("Выполнил запрограммированное действие в методе programAction() ")
        }
    }
}

//Задача 4. Создай абстрактный класс оборудования с возможностью устанавливать температуру и открываться и с
// наследованием от программируемого оборудования. Также имплементируй интерфейсы.
abstract class BaseTempRegulatableAndOpenableDevice : BaseProgrammableDevice(), TemperatureRegulatable, Openable {
    override fun open() {
        println("Открыл")
    }

    override fun close() {
        println("Закрыл")
    }

    override fun setTemperature(temp: Int) {
        if (temp <= maxTemperature) {
            println("Установил температуру на $temp")
        } else {
            println("Температура превышает максимальную. Установил температуру на $maxTemperature как максимально доступную")
        }
    }

    override val maxTemperature: Int = 40


}
//Задача 5. Создай не абстрактные классы устройств с наследованием от абстрактного класса с возможностью устанавливать температуру и открываться.
// Пусть это будет холодильник, стиральная машина, чайник, духовка. Добавь недостающие интерфейсы и реализуй необходимые методы (достаточно вывод в консоль производимого действия).
// Обрати внимание на то, что установка температуры и программирование устройства (считай - задание режима работы) не имеет смысла при выключенном питании - добавь эту проверку.

class Fridge1() : BaseTempRegulatableAndOpenableDevice(), LightEmitting {

    override fun powerOn() {
        isOn = true
        println("Холодильник включен")
    }

    override fun powerOff() {
        isOn = false
        println("Холодильник отключен")
    }

    override fun open() {
        println("Дверца холодильника открыта")
        emitLight()
    }

    override fun close() {
        completeLiteEmission()
        println("Дверца холодильника закрыта")
    }

    override val maxTemperature: Int = 10
    val minTemperature = -35

    override fun setTemperature(temp: Int) {
        if (isOn) {
            if (temp in minTemperature..maxTemperature) {
                println("Температура холодильника изменена на $temp")
            } else {
                println("$temp - недопустимая температура. Допустимая температура от $minTemperature до $maxTemperature включительно")
            }
        } else println("Нельзя изменить температуру.Холодильник выключен")
    }

    // По этой же логике программирование работы
    override fun emitLight() {
        println("Излучаю свет в холодильнике")
    }

    override fun completeLiteEmission() {
        println("Перестал излучать свет в холодильнике")
    }

}

class Washer1() : BaseTempRegulatableAndOpenableDevice(), Timable, WaterConnection, Drainable, Cleanable {


    private val minTemperature = 30
    override val maxTemperature: Int = 60

    override fun powerOn() {
        println("Стиральная машинка включена")
    }

    override fun powerOff() {
        println("Стиральная машинка выключена")
    }

    override fun open() {
        println("Дверца стиральной машинки открыта")
    }

    override fun close() {
        println("Дверца стиральной машинки закрыта")
    }

    override fun setTimer(time: Int) {
        if (isOn) {
            println("Установил таймер на машинке")
        }
    }

    override fun programAction(action: String) {
        if (isOn) {
            println("Запрограммировал действие $action")
        }
    }

    override fun setTemperature(temp: Int) {
        if (isOn) {
            if (temp in minTemperature..maxTemperature) {
                println("Температура машинки изменена на $temp")
            } else {
                println("Недопустимая температура")
            }
        }
    }

    override fun connectToWaterSupply() {
        println("Подключено к трубам")
    }

    override fun getWater(amount: Int) {
        println("Заливается вода")
    }

    override fun connectToDrain() {
        println("Подключается к сливу")
    }

    override fun drain() {
        println("Вода сливается")
    }

    override fun clean() {
        if (isOn){
            println("Идет автопромывка")
        }
    }
}

class Teapot : BaseTempRegulatableAndOpenableDevice(), WaterContainer, AutomaticShutdown, LightEmitting {
    override val capacity: Int = 40
    override val sensorType: String = "Сенсор температуры"
    override val maxSensoredValue: Int = 100
    override fun startMonitoring() {
        println("Мониторю температуру")
    }

    override fun powerOn() {
        isOn = true
        println("Чайник включен")
    }

    override fun powerOff() {
        isOn = false
        println("Чайник выключен")
    }

    override fun open() {
        println("Чайник открыт")
    }

    override fun close() {
        println("Чайник выключен")
    }

    override fun fillWater(amount: Int) {
        if (amount <= capacity){
            println("Налить воду $amount")
        }else println("Так много воды я не могу налить")
    }

    override fun getWater(amount: Int) {
        if (amount <= capacity){
            println("Вылил воду $amount")
        }else println("Вылил всю воду")
    }

    override fun emitLight() {
        if (isOn) {
            println("Индикатор горит")
        }
    }

    override fun completeLiteEmission() {
        if (isOn) {
            println("Индикатор больше не горит")
        }
    }
}

class Oven1: BaseTempRegulatableAndOpenableDevice(), AutomaticShutdown, Timable{
    override val sensorType: String = "Температурный сенсор"

    override val maxSensoredValue: Int = 241

    private var minTemperature = 0
    override val maxTemperature: Int = 240
    override fun powerOn() {
        isOn = true
        println("Духовка включена")
        startMonitoring()
    }

    override fun powerOff() {
        isOn = false
        println("Духовка выключена")
    }

    override fun open() {
        println("Духовка открыта")
    }

    override fun close() {
        println("Духовка закрыта")
    }

    override fun setTemperature(temp: Int) {
        if (isOn) {
            if (temp in minTemperature..maxTemperature) {
                println("Температура духовки изменена на $temp")
            } else {
                println("Недопустимая температура")
            }
        }
    }

    override fun startMonitoring() {
        if(isOn){println("Начал мониторинг")}
    }

    override fun setTimer(time: Int) {
        if(isOn){
            println("Установлен таймер $time")
        }
    }
}
//Создай объекты этих устройств и позапускай их с различными методами.


fun main() {
    val f1 = Fridge1()
    f1.powerOn()
    f1.open()
    f1.close()
    f1.setTemperature(-30)
    f1.programAction("Хоп хоп")
    f1.execute()
    f1.powerOff()
    println()
    val w1 = Washer1()
    w1.powerOn()
    w1.open()
    w1.close()
    w1.setTimer(3)
    w1.setTemperature(4)
    w1.programAction("Стирать")
    w1.connectToWaterSupply()
    w1.connectToDrain()
    w1.getWater(23)
    w1.drain()
    w1.powerOff()
    w1.programAction("Куку")
    w1.setTimer(5)

    val t1 = Teapot()
    t1.powerOn()
    t1.open()
    t1.fillWater(10)
    t1.fillWater(55)
    t1.getWater(30)
    t1.getWater(59)
    t1.close()
    t1.emitLight()
    t1.completeLiteEmission()
    t1.powerOff()

    val o1 = Oven1()
    o1.powerOn()
    o1.open()
    o1.close()
    o1.setTimer(120)
    o1.setTimer(10)
    o1.startMonitoring()
    o1.powerOff()

}