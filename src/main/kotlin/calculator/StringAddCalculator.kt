package calculator

import java.util.regex.Pattern

val TO_REGEX: Pattern = Pattern.compile(",|:")

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }
        val numbers = text.split(TO_REGEX)
        return numbers.sumOf { it.toInt() }
    }
}