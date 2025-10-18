package ru.stimmax.lessons.lesson13.homeworks13

fun main() {


    //1. Дан словарь с именем и временем выполнения каждого автоматизированного теста в секундах. Определите среднее время выполнения теста.
    val nameAndTests = mapOf<String, Long>("Ваня" to 300, "Петя" to 100, "Вова" to 200, "Дима" to 500, "Сергей" to 600)

    println(nameAndTests.values.average())

    //2. Имеется словарь с метаданными автоматизированных тестов,
// где ключи — это имена тестовых методов, а значения - строка с метаданными. Выведите список всех тестовых методов.
    val methodsAndStrings = mapOf<String, String>("fun1" to "ацфошаофшц", "fun2" to "ydgywad", "fun3" to "dwadwad")
    println(methodsAndStrings.map { it.key })

    //3. В изменяемый словарь с данными о прохождении тестов добавьте новый тест и его результат.
    val methodsAndResults = mutableMapOf<String, String>("test1" to "PASS", "test2" to "PASS", "test3" to "FAIL")
    methodsAndResults["test4"] = "FAIL"
    println(methodsAndResults)


    //4. Посчитайте количество успешных тестов в словаре с результатами (ключ - название, значение - результат из passed, failed, skipped).
    val passedCountTests = mapOf<String, String>(
        "test1" to "passed",
        "test2" to "failed",
        "test3" to "skipped",
        "test4" to "passed",
        "test5" to "failed",
        "test6" to "passed"
    )
    println(passedCountTests.count { it.value == "passed" })

    //5. Удалите из изменяемого словаря с баг-трекингом запись о баге, который был исправлен (ключ - название, значение - статус исправления).
    val bugsMap =
        mutableMapOf<String, String>("bug1" to "Ничего не работает", "bug2" to "Здесь вообще что-нибудь заработает?")
    bugsMap.remove("bug2")
    println(bugsMap - "bug1") // возвращает новый словарь, а не меняет текущий
    println(bugsMap)

    //6. Для словаря с результатами тестирования веб-страниц (ключ — URL страницы, значение — статус ответа), выведите сообщение о странице и статусе её проверки.
    val urlsAndResponse = mapOf<String, Int>("url1" to 200, "url2" to 400)
    println("Специальное сообщение - по ul2  вот такое статус ответа ${urlsAndResponse.getValue("url1")} ")

//7. Найдите в словаре с названием и временем ответа сервисов только те, время ответа которых превышает заданный порог.
    val tests2 = mapOf<String, Int>("t1" to 300, "t2" to 100, "t3" to 200, "t4" to 500, "t5" to 600)
    val test21 = tests2.filterValues { it > 199 }
    println(test21)
//8. В словаре хранятся результаты тестирования API (ключ — endpoint, значение — статус ответа в виде строки).
// Для указанного endpoint найдите статус ответа, если endpoint отсутствует, предположите, что он не был протестирован.
    val tests3 =
        mapOf<String, String>("t1" to "PASS", "t2" to "PASS", "t3" to "FAIL", "t4" to "SKIPPED", "t5" to "SKIPPED")
    tests3.containsKey("t6")
    println(tests3.getOrDefault("t6", "t6 был пропущен, нужно провести ран"))
    println(tests3)

    //9. Из словаря, содержащего конфигурации тестового окружения (ключ — название параметра конфигурации, значение - сама конфигурация),
// получите значение для "browserType". Ответ не может быть null.

    val test4 = mapOf<String, String?>("c1" to null, "c2" to "p2")
    val bt = test4.getOrElse("c1") { "Тут был null" }
    println(bt)


    //10. Создайте копию неизменяемого словаря с данными о версиях тестируемого ПО, добавив новую версию.
    val test5 = mapOf<String, String>("v1" to "ok")
    val t = test5 + ("v2" to "OK")
    println(t)

    //11. Используя словарь с настройками тестирования для различных мобильных устройств (ключ — модель устройства, значение - строка с настройками),
    // получите настройки для конкретной модели или верните настройки по умолчанию.
    val modelsAndParams = mapOf<String, String>("v1" to "s1", "v2" to "s2")
    println(modelsAndParams.getOrDefault("v3", "дефолтные настройки"))

    //12. Проверьте, содержит ли словарь с ошибками тестирования (ключ - код ошибки, значение - описание ошибки) определенный код ошибки.
    val testsAndErrors = mapOf<String, Int>("t1" to 500, "t2" to 404)
    println(testsAndErrors.containsValue(404))

    //13. Дан неизменяемый словарь, где ключи — это идентификаторы тестовых сценариев в формате "TestID_Version", а значения — статусы выполнения этих тестов ("Passed", "Failed", "Skipped").
// Отфильтруйте словарь, оставив только те сценарии, идентификаторы которых соответствуют определённой версии тестов, то-есть в ключе содержится требуемая версия.
    val test6 = mapOf(
        "LoginTest_1" to "Passed",
        "LoginTest_2" to "Failed",
        "PaymentTest_1" to "Passed",
        "PaymentTest_3" to "Skipped",
        "RegistrationTest_2" to "Passed",
        "LogoutTest_1" to "Failed",
        "SearchTest_3" to "Passed",
        "ProfileTest_2" to "Skipped",
        "SettingsTest_1" to "Passed",
        "DashboardTest_3" to "Failed",
        "AdminPanelTest_2" to "Passed",
        "UserManagementTest_3" to "Skipped",
        "ReportTest_1" to "Passed",
        "AnalyticsTest_2" to "Failed",
        "NotificationTest_3" to "Passed",
        "SecurityTest_1" to "Skipped",
        "PerformanceTest_2" to "Passed",
        "UITest_3" to "Failed",
        "APITest_1" to "Passed",
        "DatabaseTest_2" to "Skipped"
    )

    println(test6.filterKeys { it.takeLast(1) == 3.toString() })

    //14. У вас есть словарь, где ключи — это названия функциональных модулей приложения, а значения — результаты их тестирования.
    // Проверьте, есть ли модули с неудачным тестированием.
    val testResults = mapOf(
        "Auth" to "pass",
        "Pay" to "fail",
        "User" to "pass",
        "Cart" to "skipped",
        "Admin" to "pass",
        "Report" to "fail",
        "Search" to "pass",
        "Config" to "skipped"
    )
    println(testResults.any { it.value == "fail" })


    //15. Добавьте в изменяемый словарь с настройками тестовой среды настройки из другого словаря.
    val environment1 = mutableMapOf<String, String>(
        "Dev" to "настройки 1",
        "Test" to "настройки 2",
        "Stage" to "настройки 3"
    )
    environment1.putAll(
        mapOf(
            "QA" to "настройки 4",
            "UAT" to "настройки 5",
            "Prod" to "настройки 6"
        )
    )

    println(environment1)

    //16. Объедините два неизменяемых словаря с данными о багах.
    val bugs1 = mapOf(
        1 to "Данные о баге 1",
        2 to "Данные о баге 2",
        3 to "Данные о баге 3"
    )


    val bugs2 = mapOf(
        4 to "Данные о баге 4",
        5 to "Данные о баге 5",
        6 to "Данные о баге 6"
    )

    val bugs3 = bugs1 + bugs2

    println(bugs3)

    //17. Очистите изменяемый словарь с временными данными о последнем прогоне автоматизированных тестов.
    val testResults1 = mutableMapOf(
        "Auth" to "pass",
        "Pay" to "fail",
        "User" to "pass",
        "Cart" to "skipped",
        "Admin" to "pass",
        "Report" to "fail",
        "Search" to "pass",
        "Config" to "skipped"
    )
    testResults1.clear()
    println(testResults1)
    //18. Исключите из отчета по автоматизированному тестированию те случаи, где тесты были пропущены (имеют статус “skipped”). Ключи - название теста, значения - статус.

    val test7 = mapOf(
        "LoginTest_1" to "Passed",
        "LoginTest_2" to "Failed",
        "PaymentTest_1" to "Passed",
        "PaymentTest_3" to "Skipped",
        "RegistrationTest_2" to "Passed",
        "LogoutTest_1" to "Failed",
        "SearchTest_3" to "Passed",
        "ProfileTest_2" to "Skipped",
        "SettingsTest_1" to "Passed",
        "DashboardTest_3" to "Failed",
        "AdminPanelTest_2" to "Passed",
        "UserManagementTest_3" to "Skipped",
        "ReportTest_1" to "Passed",
        "AnalyticsTest_2" to "Failed",
        "NotificationTest_3" to "Passed",
        "SecurityTest_1" to "Skipped",
        "PerformanceTest_2" to "Passed",
        "UITest_3" to "Failed",
        "APITest_1" to "Passed",
        "DatabaseTest_2" to "Skipped"
    ).filterValues { it != "Skipped" }
    println(test7)

    //19. Создайте копию словаря с конфигурациями тестирования удалив из него несколько конфигураций.
    val test8 = mapOf<String, Int>("r1" to 1, "r2" to 2, "r3" to 3)
    val test9 = test8 - "r1" - "r2"
    println(test8)
    println(test9)

    //20. Создайте отчет о тестировании, преобразовав словарь с результатами тестирования
    // (ключ — идентификатор теста, значение — результат) в список строк формата "Test ID: результат".
    val test10 = test7.toMutableMap()
    println(test10.map { "${it.key}: ${it.value}" })


    //21. Преобразуйте изменяемый словарь с результатами последнего тестирования в неизменяемый для архивации.
    val archive = test10.toMap()

    //22. Преобразуйте словарь, содержащий числовой ID теста и данные о времени выполнения тестов,
// заменив идентификаторы тестов на их строковый аналог (например через toString()).
    val testExecutionTimes = mapOf(
        101 to "2.3s",
        102 to "1.8s",
        103 to "3.1s",
        104 to "0.9s",
        105 to "4.2s",
        106 to "2.7s",
        107 to "1.5s",
        108 to "3.8s",
        109 to "2.1s",
        110 to "5.3s"
    )
    val tests11 = testExecutionTimes.mapKeys { it.key.toString() }
    println(tests11)

    //23. Для словаря с оценками производительности различных версий приложения (ключи - строковая версия, значения - дробное число времени ответа сервера)
    // увеличьте каждую оценку на 10%, чтобы учесть новые условия тестирования.
    val appPerformance = mapOf(
        "v1.0.0" to 7.3,
        "v1.1.0" to 8.9,
        "v1.2.0" to 6.2,
        "v2.0.0" to 9.7,
        "v2.1.0" to 8.1,
        "v2.2.0" to 7.6,
        "v3.0.0" to 9.9,
        "v3.1.0" to 8.8
    )
    val appPerformance1 = appPerformance.mapValues { (Math.round((it.value * 1.1) * 10.0) / 10) }
    println(appPerformance1)

    //24. Проверьте, пуст ли словарь с ошибками компиляции тестов.
    val tests12 = mapOf<String, String>()

    //25. Убедитесь, что словарь с результатами нагрузочного тестирования не пуст.

    val tests13 = mapOf<String, String>()
    println(tests13.isNotEmpty())

    //26. Проверьте, прошли ли успешно все автоматизированные тесты в словаре с результатами.
    val tests14 = test7.toMap()
    println(tests14.all { it.value == "Passed" })

    //27. Определите, содержит ли словарь с результатами тестирования хотя бы один тест с ошибкой.
    println(tests14.any { it.value == "Failed" })

    //28. Отфильтруйте словарь с результатами тестирования сервисов, оставив только те тесты, которые не прошли успешно и содержат в названии “optional”
    val testResults4  = mapOf(
        "AuthService" to "passed",
        "OptionalPayment" to "failed",
        "UserProfile" to "passed",
        "OptionalNotification" to "skipped",
        "DatabaseCheck" to "failed",
        "OptionalSecurityScan" to "failed",
        "ReportGenerator" to "passed",
        "OptionalCacheCleanup" to "skipped"
    )
    val tests15 = testResults4.filter { it.key.lowercase().contains("Optional".lowercase()) && it.value != "passed"}
    println(tests15)
}