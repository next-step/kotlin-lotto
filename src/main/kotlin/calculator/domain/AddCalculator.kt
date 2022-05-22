package calculator.domain

class AddCalculator {
    fun sum(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        val tokens = InputParser.parse(input)
        checkValidNumbers(tokens)

        val numbers = tokens.map { it.toInt() }
        return sum(numbers)
    }

    private fun sum(numbers: List<Int>): Int {
        return numbers.sum()
    }

    private fun checkValidNumbers(tokens: List<String>) {
        tokens.forEach {
            InputValidator.checkNatualAndZero(it)
        }
    }
}
