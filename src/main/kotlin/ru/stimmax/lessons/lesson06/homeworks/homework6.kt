package ru.stimmax.lessons.lesson06.homeworks

fun main() {
    //determineSeason(0)
    //dogAgeToHumanAge(12)
    //determineTransportType(42)
    calculateBonusPoints(900)

    determineDocType("name.txt")
    determineDocType("name.xlsx")
    determineDocType("name.jpg")

    convertTemperature(25.0, 'F')
    convertTemperature(25.0, 'C')
    convertTemperature(25.0, 'R')

    recommendClothesForWeather(-31)
    recommendClothesForWeather(-30)
    recommendClothesForWeather(9)
    recommendClothesForWeather(10)
    recommendClothesForWeather(18)
    recommendClothesForWeather(19)
    recommendClothesForWeather(35)
    recommendClothesForWeather(36)

    movieByAge(-1)
    movieByAge(0)
    movieByAge(9)
    movieByAge(10)
    movieByAge(17)
    movieByAge(18)
    movieByAge(19)
}

/*Задание 1: "Определение сезона"
Напишите функцию, которая на основе номера месяца распечатывает сезон года. Номера месяцев начинаются с единицы.
*/
fun determineSeason(month: Int) {
    when (month) {
        12, 1, 2 -> println("Зима")
        3, 4, 5 -> println("Весна")
        6, 7, 8 -> println("Лето")
        9, 10, 11 -> println("Осень")
        else -> println("Указан некорректный номер месяца")
    }
}


/*Задание 2: "Расчет возраста питомца"
Создайте функцию, которая преобразует возраст собаки в "человеческие" годы. До 2 лет каждый год собаки равен 10.5 человеческим годам, после - каждый год равен 4 человеческим годам. Результат распечатай в консоль.*/

fun dogAgeToHumanAge(humanAge: Int) {
    val errorMessage = "Некорректный возраст. Возраст должен быть указан от 1 до 150 включительно"
    if (humanAge !in 1..150) {
        println(errorMessage)
    } else {
        if (humanAge < 3) {
            val result: Int = (humanAge * 126) / 12
            println("$result - Лет")
        } else {
            val firstAge: Int = 2
            val secondAge: Int = humanAge - firstAge
            val result: Int = (firstAge * 126 / 12) + secondAge * 4
            println("$result - Лет ")
        }
    }
}

/*Задание 3: "Определение способа перемещения"
Напишите функцию, которая печатает в консоль, какой способ перемещения лучше использовать, исходя из длины маршрута. Если маршрут до 1 км - "пешком", до 5 км - "велосипед", иначе - "автотранспорт".
 */
fun determineTransportType(distance: Int) {
    if (distance >= 1) {
        when (distance) {
            1 -> println("Пешком")
            in 2..5 -> println("Велосипед")
            else -> println("Автотранспорт")
        }
    } else println("Введите целое положительное число")
}

/*Задание 4: "Расчет бонусных баллов"
Клиенты интернет-магазина получают бонусные баллы за покупки. Напишите функцию, которая принимает сумму покупки и печатает в консоль количество бонусных баллов:
2 балла за каждые 100 рублей при сумме покупки до 1000 рублей и 3 балла за каждые 100 рублей при сумме свыше этого.*/
fun calculateBonusPoints(purchaseAmount: Int) {
    if (purchaseAmount > 0) {
        if (purchaseAmount < 1000) {
            val res: Int = (purchaseAmount / 100) * 2
            println("Количество бонусных баллов - $res")
        } else {
            val res: Int = (purchaseAmount /100) * 3
            println("Количество бонусных баллов - $res")
        }
    } else {
        println("Сумма покупки не может быть отрицательной")
    }
}

/*Задание 5: "Определение типа документа"
В системе хранения документов каждый файл имеет расширение. Напишите функцию, которая на основе расширения файла печатает в консоль его тип: "Текстовый документ", "Изображение", "Таблица" или "Неизвестный тип".
*/
fun determineDocType(docName: String) {
    val tmp = docName.substring(docName.indexOf('.'), docName.length)
    val result = when (tmp) {
        ".txt" -> "Текстовый документ"
        ".jpg" -> "Изображение"
        ".xlsx" -> "Таблица"
        else -> "Неизвестный тип"

    }
    println("Формат файла $docName - $result")
}

/*
Задание 6: "Конвертация температуры"
Создайте функцию, которая конвертирует температуру из градусов Цельсия в Фаренгейты и наоборот в зависимости от указанной единицы измерения (C/F). Единицу измерения нужно передать вторым аргументом функции. Несколько аргументов передаются через запятую. Распечатай в консоль результат конвертации с добавлением единицы измерения. Чтобы добавить единицу измерения после результата используй функцию печати без переноса строки print("C") или print("F").
 */
fun convertTemperature(temperature: Double, temperatureType: Char) {

    if (temperatureType == 'C' || temperatureType == 'F') {
        var tmp: Double? = null
        if (temperatureType.equals('C')) {
            tmp = (temperature * 9.0) / 5.0 + 32.0
            tmp = Math.round(tmp * 100.00) / 100.00

        } else if (temperatureType.equals('F')) {
            tmp = (temperature - 32) * 5 / 9.0
            tmp = Math.round(tmp * 100.00) / 100.00
        }
        print(tmp)
        if (temperatureType == 'C') println("F")
        else println("C")
    } else println("Неверный формат температуры")


}


/*Задание 7: "Подбор одежды по погоде"
Напишите функцию, которая на основе температуры воздуха рекомендует тип одежды: "куртка и шапка" при температуре ниже +10, "ветровка" от +10 до +18 градусов включительно и "футболка и шорты" при температуре выше +18 градусов. При температурах ниже -30 и выше +35 рекомендуйте не выходить из дома.
 */
fun recommendClothesForWeather(temperature: Int){
    if(temperature !in -30..35) {
        println("Не рекомендуем выходить")
    }else {
        when(temperature){
            in -30..9 -> println("куртка и шапка")
            in 10..18 -> println("ветровка")
            in 19 .. 35->println("футболка и шорты")
        }
    }
}

/*
Задание 8: "Выбор фильма по возрасту"
Кинотеатр предлагает фильмы разных возрастных категорий. Напишите функцию, которая принимает возраст зрителя и возвращает доступные для него категории фильмов:
"детские" (от 0 до 9), "подростковые" (от 10 до 18), "18+" для остальных.

 */
fun movieByAge(age: Int) {
    if(age !in 0..150){
        println("Ошибка. Значение возраста должно быть от 0 до 150")
    }else {
        when (age) {
            in 0..9 -> println("детские")
            in 10..17 -> println("подростковые")
            else -> println("18+")
        }
    }
}