package stringcalculator

import java.lang.RuntimeException
import kotlin.NumberFormatException

class Calculator(private val input: String?) {

    private fun numberValidate(str: String): Int {
        return try {
            if (str.toInt() < 0) throw RuntimeException(NOT_NATURAL_NUMBER_ERROR_MESSAGE)
            str.toInt()
        } catch (e: NumberFormatException) {
            throw RuntimeException(NOT_NATURAL_NUMBER_ERROR_MESSAGE)
        }
    }

    fun addByDelimiter(): Int {
        if (input.isNullOrBlank()) {
            return NULL_OR_BLANK_RESULT_NUMBER
        }

        if (CUSTOM_DELIMITER_REGEX.containsMatchIn(input)) {
            return CUSTOM_DELIMITER_REGEX.find(input)?.let {
                val customDelimiter = it.groupValues[1]
                val tokens = it.groupValues[2].split(customDelimiter)
                tokens.sumOf { token ->
                    numberValidate(token)
                }
            }!!
        }

        return input.split(",", ":").sumOf {
            numberValidate(it)
        }
    }

    companion object {
        private val CUSTOM_DELIMITER_REGEX = """//(.)\\n(.*)""".toRegex()
        private const val NULL_OR_BLANK_RESULT_NUMBER = 0
        private const val NOT_NATURAL_NUMBER_ERROR_MESSAGE = "0이상의 자연수를 입력하세요."
    }
}

fun main() {
    println("구분자를 이용한 문자열을 입력해주세요.")
    val input = readLine()
    val calculator = Calculator(input)
    println(calculator.addByDelimiter())
}
