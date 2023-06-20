package study

import java.lang.RuntimeException

class StringPlusCalculator {
    fun calculate(input: String): Int {
        if (input.isBlank()) return 0
        val numbers = StringPlusCalculatorParser.parse(input)
        return numbers.sum()
    }
}

class StringPlusCalculatorParser {
    companion object {
        fun parse(input: String): List<Int> {
            if (input.isBlank()) return emptyList()

            val stringNumbers = splitStringNumbers(input)
            return stringNumbers
                .map(::parseStringNumber)
        }

        private fun parseStringNumber(stringNumber: String): Int {
            if (stringNumber.toIntOrNull() == null) throw RuntimeException("숫자 이외의 값은 입력할 수 없습니다.")
            val number = stringNumber.toInt()
            if (number < 0) throw RuntimeException("음수는 입력할 수 없습니다.")
            return number
        }

        private fun splitStringNumbers(input: String): List<String> {
            if (input.startsWith("//")) {
                val customDelimiter = input.substring(2, 3)
                return input.substring(4).split(customDelimiter)
            }
            val delimiters = "[,:]".toRegex()
            return input.split(delimiters)
        }
    }
}
