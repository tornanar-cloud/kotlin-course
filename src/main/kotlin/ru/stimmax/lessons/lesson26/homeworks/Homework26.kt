package ru.stimmax.lessons.lesson26.homeworks

import java.io.File

// Задача 1
//
//Создайте текстовый файл workspace/task1/example.txt. Запишите в него строку "Hello, Kotlin!",
// а затем проверьте, существует ли файл. Реши задачу с использованием scope функции без создания переменной.
fun createExampleTxt() {
    File("workspace/task1/example.txt").also {
        if (!it.exists()) {
            it.parentFile.mkdirs()
            it.createNewFile()
            if (it.exists()) {
                println("Я создаль example.txt ")
            } else {
                println("Я не создаль example.txt")
            }
            it.writeText("Hello Kotlin")
        } else {
            println("Файл уже создан")
        }
    }
}

//Задача 2
//Создайте директорию workspace/task2/testDir. Проверьте, является ли она директорией, и выведите её абсолютный путь.

fun createTestDirdirectory() {
    File("workspace/task2/testDir").also {
        if (!it.exists()) {
            it.mkdirs()
            if (it.exists()) {
                println("Директория существует")
                if (it.isDirectory) {
                    println("Директория workspace/task2/testDir создана")
                } else {
                    println("Не удалось создать директорию")
                }
            } else {
                println("Директория не существует")
            }
            println(it.absolutePath)
        } else {
            println("workspace/task2/testDir уже создана")
            println(it.absolutePath)
        }
    }
}

//Задача 3
//
// Создайте директорию workspace/task3/structure. Внутри директории structure создайте папку myDir с двумя вложенными поддиректориями
// subDir1 и subDir2. Проверьте, что myDir действительно содержит эти поддиректории.
// Используй scope функции для минимизации создания переменных а так же метод file.resolve("myDir") для создания нового объекта File путём
// добавления к существующему пути ещё одной секции. И так же для других директорий.
fun fn3() {
    File("workspace/task3/structure").also {
        if (!it.exists()) {
            it.mkdirs()
            val f = it.resolve("myDir")
            f.mkdir()
             f.resolve("subDir1").mkdir()

             f.resolve("subDir2").mkdir()

            val l = f.listFiles().map { it.name }
            println(l)
            if (l.contains("subDir1") && l.contains("subDir2")){
                println("Поддиректории subDir1 и subDir2 существуют")
                println(f.absolutePath)
            }
        } else {
            println("workspace/task3/structure")
        }
    }
}

//Задача 4.
// Создайте директорию workspace/task4/temp. Внутри директории temp создайте несколько вложенных файлов и директорий.
// Удалите директорию workspace/task4 со всем содержимым
fun fn4(){
    File("workspace/task4/temp").also {
        it.mkdirs()
        var f1 = it.resolve("dir1")
        f1.mkdirs()
        f1 = f1.resolve("txt1.txt")
        f1.createNewFile()
        if (f1.exists()){
            println("Создана директория dir1 и файл txt1.txt")
        }
        var f2 = it.resolve("dir2")
        f2.mkdirs()
        f2 = f2.resolve("txt2.txt")
        f2.createNewFile()
        if (f2.exists()){
            println("Создана директория dir2 и файл txt2.txt")
        }
        //it.deleteRecursively()
        if(!it.exists()){
            println("Удалена директория /temp")
        }
    }
}
//Задача 5. Создайте файл workspace/task5/config/config.txt. запишите в него список параметров (в формате ключ=значение),
// а затем прочитайте файл и выведите только значения.
fun fn5(){
    val dataMap = mapOf<String, Int>("Сила" to 2,"Ловкость" to 3000,"Харизма" to -5)
    File("workspace/task5/config/config.txt").also { file ->
        file.parentFile.mkdirs()
        file.createNewFile()
        val dataWrite = dataMap.map { "${it.key} = ${it.value}" }.joinToString("\n")
        file.writeText(dataWrite)
        val dataRead = file.readText().split("\n").map { it.substring(it.indexOf('=')+1,it.length) }
        println(dataRead)
    }
}
//Задача 6. Пройди по всем вложенным директориям workspace и выведи в консоль сначала пути директорий, а потом пути файлов
fun main() {
    createExampleTxt()
    createTestDirdirectory()
    fn3()
    fn4()
    fn5()
}


