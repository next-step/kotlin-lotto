package calculator.domain

class StringAddCalculator {
    fun add(input: Expression): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        if (!input.isNullOrBlank()) {
            input.checkNegative()
        }

        if (input.isOneNumber()) {
            return input.getOneNumber()
        }

        return calculateTotal(input.values.map { it.toInt() }.toList())
    }

    private fun calculateTotal(numbers: List<Int>): Int {
        return numbers.sum()
    }
}
