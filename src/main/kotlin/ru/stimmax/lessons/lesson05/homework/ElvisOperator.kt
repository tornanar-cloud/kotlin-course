package ru.stimmax.lessons.lesson05.homework
var j = 4;
fun main() {
    //Начальная интенсивность звука
    var startingSoundIntensity: Double = 5.00
    var soundAttenuationCoefficient: Double? = 0.2
    var base1: Double = 0.5
    var result1: Double = startingSoundIntensity * (soundAttenuationCoefficient ?: base1 )
    println(result1)


    var cargoСost: Double = 258.00;
    var insurance: Double? =null //(cargoСost / 100) /2
    var base2: Double = 50.00
    var result2 = cargoСost + (insurance ?: base2)
    println(result2)

    var atmosphericPressureMetrics: String? = null //"Всякие разные показатели"
    var attentionMessage: String = "Внимание внимание"
    var result3: String = atmosphericPressureMetrics ?: attentionMessage
    println(result3)
}