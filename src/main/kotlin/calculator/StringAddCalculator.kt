package calculator

object StringAddCalculator {

    private const val DEFAULT_RESULT = 0

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return DEFAULT_RESULT
        }

        val expression = Expression(text)
        if (expression.isNumber()) {
            return expression.toPositiveInt()
        }

        val numbers = expression.split()
        return numbers.sum()
    }
}
