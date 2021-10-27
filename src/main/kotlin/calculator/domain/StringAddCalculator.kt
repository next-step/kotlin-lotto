package calculator.domain

import calculator.usecase.Parser

interface Calculator {
    fun calculate(input: String): Int
}

class StringAddCalculator(
    private val parser: Parser,
) : Calculator {

    override fun calculate(input: String): Int {
        val numbers = parser.parse(input)
        return numbers.sum()
    }
}
