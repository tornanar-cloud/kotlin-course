package ru.stimmax.lessons.lesson31.homeworks

import javax.xml.stream.events.Characters

class PhoneNumberFormatter {
    fun formatPhoneNumber(phone: String): String{
        var tmp = phone.replace("\\D".toRegex(),"")
        require(tmp.length in 10..11) {"Длинна номера должна быть 10-11 символов."}
        if(tmp.length == 11 ){
            require(tmp.length == 11 && tmp.first().digitToInt() in 7..8)
            tmp = tmp.drop(1)
        }
        return "+7 (${tmp.substring(0,3)}) ${tmp.substring(3,6)}-${tmp.substring(6,8)}-${tmp.substring(8,10)}"
    }
}

fun main() {
    PhoneNumberFormatter().formatPhoneNumber("1234567890")
}

