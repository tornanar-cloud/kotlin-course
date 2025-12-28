package ru.stimmax.lessons.lesson31.homeworks

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class PhoneNumberFormatterTest {

    @ParameterizedTest
    @MethodSource("provideCorrectNumbers")
    fun `validatePhoneNumber returns true for valid 10 or 11 digit numbers starting with 7 or 8`(phoneNumber: String, expectedPhoneNumber: String){
        val actualFormatNumber = PhoneNumberFormatter().formatPhoneNumber(phoneNumber)
        assertEquals(expectedPhoneNumber, actualFormatNumber,"Ожидаемый и фактический результат не совпадают.")
    }
    //Проверяет положительный input с 10 символами и 11, которые начинаются на 7 и 8
    @ParameterizedTest
    @MethodSource("provideNumbersWithInvalidLength")
    fun `phone number validation fails when digit count is not 10 or 11` (phoneNumber: String){
        assertThrows(IllegalArgumentException::class.java){
            PhoneNumberFormatter().formatPhoneNumber(phoneNumber)
        }
    }
    @ParameterizedTest
    @MethodSource("provideNumbersWithInvalidFirstDigit")
    fun `validatePhoneNumber returns false for 11-digit numbers not starting with 7 or 8`(phoneNumber: String){
        assertThrows(IllegalArgumentException::class.java){
            PhoneNumberFormatter().formatPhoneNumber(phoneNumber)
        }
    }

    companion object {
        @JvmStatic
        fun provideCorrectNumbers() = listOf(
            arrayOf("1234567890","+7 (123) 456-78-90"),
            arrayOf("9682233441", "+7 (968) 223-34-41"),
            arrayOf("8 (922) 941-11-11","+7 (922) 941-11-11"),
            arrayOf("79229411111","+7 (922) 941-11-11"),
            arrayOf("89229411111","+7 (922) 941-11-11"),
            arrayOf("+7 922 941 11 11", "+7 (922) 941-11-11"),
            arrayOf("+79229411111","+7 (922) 941-11-11"),
            arrayOf("+7(922)941-11-11", "+7 (922) 941-11-11"),
            arrayOf("+7 (922) 941-11-11","+7 (922) 941-11-11"),
            arrayOf("abc +7 922 941 11 11фис","+7 (922) 941-11-11")
        )
        //Положительные. Без доп символов, с доп символами

        @JvmStatic
        fun provideNumbersWithInvalidLength() = listOf(
            arrayOf("123"),           // менее 10
            arrayOf("892fwagg294111"),     // 9 цифр
            arrayOf("8(922)94111111"),  // 12 цифр
            arrayOf("+7922941111111"),  // более 11
            arrayOf("gufwahfuwhufha++SSqq"), //0 цифр
            arrayOf("") // пустая строка
        )
        @JvmStatic
        fun provideNumbersWithInvalidFirstDigit() = listOf(
            arrayOf("+1 (922) 941-11-11"),
            arrayOf("+9 (922) 941-11-11"),
            arrayOf("+1 (922) fwafwaf941-11-11"))


    }
}
