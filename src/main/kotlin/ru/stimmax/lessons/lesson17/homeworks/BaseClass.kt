package ru.stimmax.lessons.lesson17.homeworks

abstract class BaseClass(
    // 1. объясни, почему это поле доступно в main() для чтения из класса ChildrenClass
    //Потому что там указано val privateVal: String, что является объявлением одноименной переменной
    private val privateVal: String,
    // 2. объясни, почему это поле недоступно в main()
    //Потому что модификатор доступа protected. Вызов доступен из класса и из его дочерних классов. В дочернем классе можно создать метод и использовать его как интерфейс.в main доступно не будет.
    protected val protectedVal: String,
    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }
        get(){
            return if (field =="2") "2" else "1"
        }
    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"
    private var privateField = "6. добавь сеттер чтобы изменить меня из main()"
    // Эту задачу нельзя выполнить
    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate(),
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }

    fun printText() {
        privatePrint()
    }

    // 7. объясни, почему эта функция не может быть публичной
    //Потому что она возвращает protected класс, который доступен только наследникам. Был бы private класс, то и метод был бы private без open
    protected open fun getProtectedClass() = ProtectedClass()
    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }

    // 8. Распечатай getAll() и объясни, почему в поле "generate" другой текст
    // метод generate переопределен в дочернем классе.
    open fun generate(): String {
        return "Это генерация из родительского класса"
    }

    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }

    // 9. объясни, почему эта функция не может быть публичной или protected
    //Потому что метод возвращает приватный класс. Т
    private fun getPrivateClass(): PrivateClass = PrivateClass()

    protected class ProtectedClass() {}

    private class PrivateClass() {}
/*
    fun setPrivateFieldValue(value: String) {
        privateField = value
    }
*/

}

class ChildrenClass(
    val privateVal: String,
    protectedVal: String,
    // 10. объясни, почему этот аргумент доступен в main() несмотря на то, что это не поле
    // Это поле родительского класса, которое используется в конструкторе. Здесь мы просто передает значение в родительский. А в мейне мы уже используем родительский.
    //Модификатор public
    publicVal: String
) : BaseClass(privateVal, protectedVal, privateVal) {

    // 11. объясни, почему в main() доступна функция getAll() хотя её здесь нет
    //fun getAll(): String имеет модификатор public потому можно вызвать в main
    // 12. проверь, что выводится на печать при вызове функции printText()
    // и объясни, почему не происходит переопределение метода privatePrint()
    // printText() вызывает метод private fun privatePrint() из родительского класса. В отличии от override fun verifyPublicField(value: String): Boolean он не
    //переопределен
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }

    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }

    fun printProtect() {
        println(protectedField)
    }

    override fun verifyPublicField(value: String): Boolean {
        return value.length < 51
    }

    fun setProtectedFieldValue(v: String) {
        protectedField = v

    }

    fun getProtectedFieldValue(): String {
        return protectedField
    }
}

fun main() {
    val a = ChildrenClass("Приват", "Протект", "Публичный")
    a.publicField = "Антонио Бандерас"
    println(a.publicField)
    a.setProtectedFieldValue("изменил protectedField")
    println(a.getProtectedFieldValue())
    println(a.getAll())
    a.printText()
}

fun rString() = "Привет"