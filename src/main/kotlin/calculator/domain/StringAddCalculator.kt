package calculator.domain

class StringAddCalculator {
    fun add(input: Expression): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        if (input.isOneNumber()) {
            return input.getOneNumber()
        }

        return calculateTotal(input.values)
    }

    private fun calculateTotal(numbers: List<String>): Int {
        var total = 0
        for (number in numbers) {
            total += number.toInt()
        }
        return total
    }
}
