package com.nextstep.jngcii.calculator

object InputView {
    private const val ZERO = 0

    fun getNumbers(input: String?): List<Int> {
        if (input.isNullOrBlank()) {
            return listOf(ZERO)
        }

        val (expression, delimiter) = InputParser.parseDelimiter(input)

        return InputParser.parseExpression(expression, delimiter)
    }
}
