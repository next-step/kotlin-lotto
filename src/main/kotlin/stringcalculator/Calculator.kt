package stringcalculator

import java.lang.RuntimeException

class Calculator(private val input: String) {

    private fun numberValidate(str: String): Int {
        val number = str.toIntOrNull()
        number ?: throw RuntimeException(NOT_NATURAL_NUMBER_ERROR_MESSAGE)
        if (number < 0) throw RuntimeException(NOT_NATURAL_NUMBER_ERROR_MESSAGE)
        return number
    }

    private fun addByCustomDelimiter(): Int {
        return CUSTOM_DELIMITER_REGEX.find(input)?.let {
            val customDelimiter = it.groupValues[GET_DELIMITER_INDEX]
            val tokens = it.groupValues[GET_VALUE_LIST_INDEX].split(customDelimiter)
            tokens.sumOf { token ->
                numberValidate(token)
            }
        }!!
    }

    fun addByDelimiter(): Int {
        if (input.isNullOrBlank()) {
            return NULL_OR_BLANK_RESULT_NUMBER
        }

        return if (CUSTOM_DELIMITER_REGEX.containsMatchIn(input)) {
            addByCustomDelimiter()
        } else input.split(",", ":").sumOf {
            numberValidate(it)
        }
    }

    companion object {
        private val CUSTOM_DELIMITER_REGEX = """//(.)\\n(.*)""".toRegex()
        private const val NULL_OR_BLANK_RESULT_NUMBER = 0
        private const val GET_DELIMITER_INDEX = 1
        private const val GET_VALUE_LIST_INDEX = 2
        private const val NOT_NATURAL_NUMBER_ERROR_MESSAGE = "0이상의 자연수를 입력하세요."
    }
}

fun main() {
    println("구분자를 이용한 문자열을 입력해주세요.")
    val input = readln()
    val calculator = Calculator(input)
    println(calculator.addByDelimiter())
}
