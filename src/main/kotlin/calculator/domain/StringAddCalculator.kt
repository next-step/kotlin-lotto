package calculator.domain

class StringAddCalculator {
    fun add(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        if (isOneNumber(input)) {
            checkNegative(input.toInt())
            return input.toInt()
        }

        return calculateDefaultDelimiter(input)
    }

    private fun isOneNumber(input: String): Boolean {
        return input.length == 1
    }

    private fun checkNegative(number: Int) {
        require(number >= 1) { "음수 입력 불가" }
    }

    private fun calculateDefaultDelimiter(input: String): Int {
        val numbers = input.split(",|:".toRegex())
        return calculateTotal(numbers)
    }

    private fun calculateTotal(numbers: List<String>): Int {
        var total = 0
        for (number in numbers) {
            checkNegative(number.toInt())
            total += number.toInt()
        }
        return total
    }
}
