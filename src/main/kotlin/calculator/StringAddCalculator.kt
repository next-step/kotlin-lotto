package calculator

class StringAddCalculator {

    fun add(expression: String?): Int {
        if (expression.isNullOrBlank()) {
            return 0
        }

        if (expression.contains("-")) {
            throw RuntimeException()
        }

        val parsedExpression = parseExpression(expression)
        return extractTokens(expression, parsedExpression).map { it.toIntOrNull() ?: 0 }.sum()
    }

    private fun extractTokens(origin: String, parsedExpression: List<String>) =
        if (parsedExpression.isEmpty()) {
            origin.split(*DELIMITER)
        } else {
            val customDelimiter = parsedExpression.first()[2]
            parsedExpression.last().split(customDelimiter)
        }

    private fun parseExpression(expression: String): List<String> =
        pattern.find(expression)?.groupValues ?: emptyList()

    companion object {
        private val DELIMITER = arrayOf(",", ":")
        private val pattern = "^//(.)\n(.*)$".toRegex()
    }
}

data class Token(
    private val delimiter: String,
    private val expression: String
)
