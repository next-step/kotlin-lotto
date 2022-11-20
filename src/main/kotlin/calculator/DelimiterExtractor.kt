package calculator

import calculator.utils.findByPattern

object DelimiterExtractor {
    fun run(expression: String): String? {
        val result = expression.findByPattern()
        return result?.let { it.groupValues[1] }
    }
}
