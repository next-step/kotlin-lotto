package study

import java.lang.RuntimeException

object StringPlusCalculatorParser {
    fun parse(expression: String): List<Int> {
        if (expression.isBlank()) return emptyList()

        val stringNumbers = splitStringNumbers(expression)
        return stringNumbers
            .map(::parseStringNumber)
    }

    private fun splitStringNumbers(expression: String): List<String> {
        Regex("//(.)\n(.*)").find(expression)?.let {
            val customDelimiter = it.groupValues[1]
            return it.groupValues[2].split(customDelimiter)
        }
        val delimiters = "[,:]".toRegex()
        return expression.split(delimiters)
    }

    private fun parseStringNumber(stringNumber: String): Int {
        if (stringNumber.toIntOrNull() == null) throw RuntimeException("숫자 이외의 값은 입력할 수 없습니다.")
        val number = stringNumber.toInt()
        if (number < 0) throw RuntimeException("음수는 입력할 수 없습니다.")
        return number
    }
}
