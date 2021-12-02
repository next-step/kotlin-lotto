package stringaddcalculator.domain

import stringaddcalculator.Message

class StringAddCalculator {
    fun calculate(input: String): Int {
        if (input.isBlank()) return DEFAULT_RETURN_VALUE
        val calculation = Calculation.getCalculation(input)
        return calculation.splitExpression().flatMap { item ->
            item.split(Calculation.ADD_DELIMITER.toRegex())
        }.sumOf { data ->
            require(data.toInt() > ZERO ) { throw RuntimeException(Message.ILLEGAL_MESSAGE) }
            data.toInt()
        }
    }

    companion object {
        private const val DEFAULT_RETURN_VALUE = 0
        private const val ZERO = 0
    }
}

