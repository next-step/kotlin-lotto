package stringAddCalculator

import java.lang.RuntimeException

class StringAddCalculatorInput(private val input: String) {
    fun parse(): List<Int> {
        val customDelimiter = getCustomDelimiter()

        return getIntegerPart().split(Regex("[${DEFAULT_DELIMITERS.joinToString()}$customDelimiter]"))
            .map {
                try {
                    convertToInt(it)
                } catch (e: NumberFormatException) {
                    throw RuntimeException()
                }
            }
    }

    private fun getCustomDelimiter(): String {
        val result = Regex("//(.)\n(.*)").find(input) ?: return ""

        return result.groupValues[1]
    }

    private fun getIntegerPart(): String = input.split("\n").last()

    private fun convertToInt(text: String): Int {
        try {
            return text.toInt().also {
                if (it < 0) {
                    throw RuntimeException()
                }
            }
        } catch (e: NumberFormatException) {
            throw RuntimeException()
        }
    }

    companion object {
        val DEFAULT_DELIMITERS = listOf(",", ":")
    }
}
