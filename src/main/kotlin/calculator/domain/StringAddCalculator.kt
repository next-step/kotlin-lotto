package calculator.domain

class StringAddCalculator {

    @Throws(RuntimeException::class)
    fun add(input: String?): Int {
        if (input.isNullOrBlank()) {
            return DEFAULT_RESULT
        }

        val expression = Expression(input)
        return expression.extractTokens().sumBy { it.value }
    }

    companion object {
        private const val DEFAULT_RESULT = 0
    }
}
