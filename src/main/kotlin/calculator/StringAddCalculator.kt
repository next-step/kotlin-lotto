package calculator

import calculator.utils.StringUtils

class StringAddCalculator {

    fun add(text: String?): Int {
        val numbers = StringUtils.parseToNumbers(text)
        return sum(numbers)
    }

    private fun sum(numbers: List<Int>): Int {
        return numbers.fold(0) { total, num -> total + num }
    }
}
