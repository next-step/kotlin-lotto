package calculator

import calculator.utils.findByPattern

object DelimiterExtractor {
    fun run(expression: String): List<String> {
        val result = expression.findByPattern()
        return result?.let { listOf(it.groupValues[1]) } ?: run { listOf(",", ":") }
    }
}
