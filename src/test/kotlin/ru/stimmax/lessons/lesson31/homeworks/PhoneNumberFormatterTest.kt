package ru.stimmax.lessons.lesson31.homeworks

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class PhoneNumberFormatterTest {
@ParameterizedTest
@MethodSource()





companion object{
    @JvmStatic
    fun provideCorrectNumbers() = listOf(
        arrayOf("8 (922) 941-11-11"),
        arrayOf("79229411111"),
        arrayOf("")
    )
}


}