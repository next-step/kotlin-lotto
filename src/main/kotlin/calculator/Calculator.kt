package calculator

object Calculator {

    private const val DEFAULT_RESULT = 0

    fun add(expression: String?): Int {
        if (expression.isNullOrEmpty()) {
            return DEFAULT_RESULT
        }
        return Parser.parse(expression).sumOf { it.value }
    }
}
