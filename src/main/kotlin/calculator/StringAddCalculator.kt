package calculator

import java.lang.RuntimeException

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        val result = Regex("//(.)\n(.*)").find(text)
        val numbers = if (result != null) {
            val customDelimiter = result.groupValues[1]
            result.groupValues[2].split(",", ":", customDelimiter)
        } else {
            text.split(",", ":")
        }
        return if (numbers.size == 1) {
            text.parseNumber()
        } else {
            numbers.map { it.parseNumber() }.sum()
        }
    }

    private fun String.parseNumber() = toInt().also { number ->
        if (number < 0) throw RuntimeException()
    }

}
