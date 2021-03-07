package calculator

class StringAddCalculator {

    fun calculate(input: String): Int {
        try {
            val token = Token(input)
            return token.values
                .map { PositiveNumber(it) }
                .reduce { acc, positiveNumber -> acc.plus(positiveNumber) }
                .value
        } catch (e: RuntimeException) {
            throw RuntimeException(e.message, e)
        }
    }
}
