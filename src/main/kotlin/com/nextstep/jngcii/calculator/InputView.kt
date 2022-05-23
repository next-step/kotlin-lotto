package com.nextstep.jngcii.calculator

class InputView(
    private val inputParser: InputParser
) {
    fun getNumbers(): List<Int> {
        val input = readLine()

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
