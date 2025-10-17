package ru.stimmax.lessons.lesson13.homeworks13

fun main() {
    val food = mapOf(
        "Овощи" to listOf("Картофель", "Морковь", "Лук"),
        "Фрукты" to listOf("Яблоки", "Груши", "Апельсины"),
        "Ягоды" to listOf("Виноград", "Клубника", "Голубика"),
        "Орехи" to listOf("Арахис", "Фундук", "Макадамия"),
        "Зелень" to listOf(),
    )

    //Дан словарь с именем и временем выполнения каждого автоматизированного теста в секундах. Определите среднее время выполнения теста.
    val nameAndTests = mapOf<String, Long>("Ваня" to 300, "Петя" to 100, "Вова" to 200, "Дима" to 500, "Сергей" to 600)

    println(nameAndTests.values.average())

    //Имеется словарь с метаданными автоматизированных тестов,
// где ключи — это имена тестовых методов, а значения - строка с метаданными. Выведите список всех тестовых методов.
    val methodsAndStrings = mapOf<String, String>("fun1" to "ацфошаофшц", "fun2" to "ydgywad", "fun3" to "dwadwad")
    println(methodsAndStrings.map { it.key })

    //В изменяемый словарь с данными о прохождении тестов добавьте новый тест и его результат.
    val methodsAndResults = mutableMapOf<String, String>("test1" to "PASS", "test2" to "PASS", "test3" to "FAIL")
    methodsAndResults["test4"] = "FAIL"
    println(methodsAndResults)


    //Посчитайте количество успешных тестов в словаре с результатами (ключ - название, значение - результат из passed, failed, skipped).
    val passedCountTests = mapOf<String, String>(
        "test1" to "passed",
        "test2" to "failed",
        "test3" to "skipped",
        "test4" to "passed",
        "test5" to "failed",
        "test6" to "passed"
    )
    println(passedCountTests.count { it.value == "passed" })

    //Удалите из изменяемого словаря с баг-трекингом запись о баге, который был исправлен (ключ - название, значение - статус исправления).
    val bugsMap =
        mutableMapOf<String, String>("bug1" to "Ничего не работает", "bug2" to "Здесь вообще что-нибудь заработает?")
    bugsMap.remove("bug2")
    println(bugsMap)

    //Для словаря с результатами тестирования веб-страниц (ключ — URL страницы, значение — статус ответа), выведите сообщение о странице и статусе её проверки.
    val urlsAndRespons = mapOf<String, Int>("url1" to 200, "url2" to 400)
    println("Специальное сообщение - по ul2  вот такое статус ответа ${urlsAndRespons.getValue("url1")} ")

//
//
}