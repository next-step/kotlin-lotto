package calculator.domain

class StringAddCalculator {

    @Throws(RuntimeException::class)
    fun add(input: String?): Int {
        if (input.isNullOrBlank()) {
            return DEFAULT_RESULT
        }

        val expression = Expression(input)
        return when {
            expression.isValid() -> expression.extractTokens().map { it.toIntOrNull() ?: 0 }.sum()
            else -> throw RuntimeException()
        }
    }

    companion object {
        private const val DEFAULT_RESULT = 0
    }
}
