package stringaddcalculator.domain

import java.lang.NumberFormatException

data class Number(val text: String) {
    val number: Int = convertInt()

    init {
        isNegative()
    }

    fun convertInt(): Int {
        try {
            return text.toInt()
        } catch (ex: NumberFormatException) {
            throw RuntimeException("$text is Not Number")
        }
    }

    fun isNegative() {
        if (number < 0) throw RuntimeException("$number is Negative")
    }


}