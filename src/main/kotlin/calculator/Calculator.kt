package calculator

import util.requireOrThrow

class Calculator {
    fun add(expression: String): Int {

        if (expression.isBlank()) {
            return 0
        }

        val result = CUSTOM_DELIMITER.toRegex().find(expression)
        val tokens =
            result?.let { it.groupValues[2].split(it.groupValues[1]) } ?: expression.split(DEFAULT_DELIMITER.toRegex())

        return tokens
            .requireOrThrow("음수는 지원하지 않습니다.") { it.toInt() >= 0 }
            .sumOf { it.toInt() }
    }

    companion object {
        private const val DEFAULT_DELIMITER = "[,:]"
        private const val CUSTOM_DELIMITER = "//(.*)\\\\n(.*)"
    }
}
