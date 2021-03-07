package calculator

class StringAddCalculator {

    fun run(input: String): Int {
        try {
            return calculate(input)
        } catch (e: RuntimeException) {
            throw RuntimeException(e.message, e)
        }
    }

    private fun calculate(input: String): Int {
        val token = Token(input)
        return token.values
            .map { PositiveNumber(it) }
            .reduce { acc, positiveNumber -> acc.plus(positiveNumber) }
            .value
    }
}
