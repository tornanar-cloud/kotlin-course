package ru.stimmax.lessons.lesson15.homeworks

//Геометрические Фигуры
//Базовый класс: Геометрическая Фигура
//Производные классы: Многоугольник, Круг
//Дополнительное разветвление для Многоугольник: Треугольник, Четырехугольник
//Отдельными файлами


//Учебные Заведения
//Базовый класс: Учебное Заведение
//Производные классы: Школа, …
//Дополнительное разветвление для …: …


open class EducationalInstitution(
    var name: String,
    var address: String,
    var institutionType: String,
    var educationLevel: String
) {

}


open class School(
    name: String,
    address: String,
    institutionType: String,
    educationLevel: String,
    val classCount: Int

) : EducationalInstitution(name, address, institutionType, educationLevel)

class MiddleSchool(
    name: String,
    address: String,
    institutionType: String,
    educationLevel: String,
    classCount: Int,
    val classes: MutableList<String>
) : School(name, address, institutionType, educationLevel, classCount)


class HighSchool(
    name: String,
    address: String,
    institutionType: String,
    educationLevel: String,
    classCount: Int,
    val classes: MutableList<String>
) : School(name, address, institutionType, educationLevel, classCount)


class Institute(
    name: String,
    address: String,
    institutionType: String,
    educationLevel: String
) : EducationalInstitution(name, address, institutionType, educationLevel) {

}


//Иерархия Мебели
//Базовый класс: Мебель
//Производные классы: …
//Дополнительное разветвление для …: …

open class Furniture(
    var name: String,
    var typeFurniture: String,
    var weight: Double
) {

}

open class OfficeFurniture(
    name: String,
    typeFurniture: String,
    weight: Double,
    val hasShockProtection: Boolean
) : Furniture(name, typeFurniture, weight)

class OfficeTable(
    name: String,
    typeFurniture: String,
    weight: Double,
    hasShockProtection: Boolean,
    val hasCoffeeStand: Boolean
) : OfficeFurniture(name, typeFurniture, weight, hasShockProtection)

class OfficeChair(
    name: String,
    typeFurniture: String,
    weight: Double,
    hasShockProtection: Boolean,
    val hasArmrests: Boolean
) : OfficeFurniture(name,typeFurniture,weight,hasShockProtection) {

}



