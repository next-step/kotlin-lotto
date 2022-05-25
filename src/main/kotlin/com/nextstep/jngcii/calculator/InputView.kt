package com.nextstep.jngcii.calculator

class InputView(
    private val inputParser: InputParser
) {
    fun getNumbers(read: () -> String?): List<Int> {
        val input = read()

        if (input.isNullOrBlank()) {
            return listOf(ZERO)
        }

        val (expression, delimiter) = inputParser.parseDelimiter(input)

        return inputParser.parseExpression(expression, delimiter)
    }

    companion object {
        private const val ZERO = 0
    }
}
