package calculator

class StringAddCalculator {

    fun run(input: String): Int {
        return calculate(input)
    }

    private fun calculate(input: String): Int {
        if (input.isEmpty()) {
            return 0
        }

        val token = Token(input)
        return token.values
            .map { PositiveNumber(it) }
            .reduce { x, y -> x + y }
            .value
    }
}
