package ru.stimmax.lessons.lesson22.homeworks

//Воспроизвести фрагменты кода, которые могут привести к возникновению исключений:
//
//1.NullPointerException
//2/IndexOutOfBoundsException
//3.ClassCastException
//4.IllegalArgumentException
//5.NumberFormatException
//6.IllegalStateException
//7.OutOfMemoryError
//8.StackOverflowError

fun main() {

    /*
    //1. NullPointerException
        try {
            val a: Int? = null
            a!!
            //2. IndexOutOfBoundsException
            val l1 = listOf<String>()
            println(l1[1])
            //3. ClassCastException
            val z1: Any = "2"
            z1 as Int
            //4. IllegalArgumentException
            addMoney(-300)
            //5.NumberFormatException
            val numberString: String = "24g"
            numberString.toInt()
            //6. IllegalStateException
            val y1 = 5
            check(y1 > 10)

            //7. OutOfMemoryError
            //while(true){или делаем рекурсию}

            //8.StackOverflowError
            //Большая вложенность или бесконечная рекурсия
        } catch (e: NullPointerException) {
            println("$e")
        } catch (e: IndexOutOfBoundsException) {
            println(e)
        } catch (e: ClassCastException) {
            println(e)
        } catch (e: IllegalArgumentException) {
            println(e)
        } catch (e: NumberFormatException) {
            println(e)
        } catch (e: IllegalStateException) {
            println(e)
        } catch (e: OutOfMemoryError) {
            println(e)
        } catch (e: StackOverflowError) {
            println(e)
        } catch (e: Exception) {
            println(e)
        }
         */

    fun10(null)
    fun10(20.0)
    fun10("2q")
    fun10(-10)
    fun10("20g")
    fun10(-50)
}
//Задание 9. Оберни все вызовы из предыдущего задания в блок try-catch и создай для каждого типа ошибки свой catch блок

//Задание 10. Напиши функцию, которая принимает nullable аргумент типа Any и в блоке try/catch выполни набор действий с этим
//аргументом которые могут потенциально вызвать одно из исключений в этом же порядке:
fun fun10(arg: Any?) {
    try {
        if (arg == null) {
            arg!!
        }

        if (arg is Double) {
            val l1 = mutableListOf<Any>()
            for (x in 1..3) {
                l1.add(arg)
            }
            l1[4]
        }

        if (arg is String) {
            if (arg.equals("2q")) {
                arg as Int
            }
        }

        if (arg is Int) {
            if (arg == -10) {
                addMoney(arg)
            }
        }

        if (arg is String) {
            if (arg.equals("20g")) {
                arg.toInt()
            }
        }

        if (arg is Int) {
            if (arg == -50) {
                val b = arg
                check(b > 0)
            }
        }

    } catch (e: Exception) {
        when (e) {
            is NullPointerException -> println(e)
            is IndexOutOfBoundsException -> println(e)
            is ClassCastException -> println(e)
            is IllegalArgumentException -> println(e)
            is NumberFormatException -> println(e)
            is IllegalStateException -> println(e)
            else -> println(e)
        }

    }

    //Задание 11. Создай свой тип исключения в отдельном файле, наследуемый от AssertionError и принимающий текст. Выброси это исключение в main

    //Задание 12. Создай свой тип исключения в отдельном файле, наследуемый от RuntimeException и принимающий
    // IndexOutOfBoundsException тип в качестве аргумента. Напиши код, который спровоцирует выброс IndexOutOfBoundsException,
    // перехвати его с помощью try-catch и в блоке catch выведи сообщение в консоль и сделай выброс своего типа исключения.
}


fun addMoney(amount: Int) {
    require(amount > 0) {
        "Сумма меньше нуляяяя, алллоооо!!!!"
    }
}