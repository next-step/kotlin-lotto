package calculator

import util.requireOrThrow

class Calculator {
    fun add(expression: String): Int {

        if (expression.isBlank()) {
            return 0
        }

        val result = CUSTOM_DELIMITER_REGEX.find(expression)
        val tokens =
            result?.let { it.groupValues[2].split(it.groupValues[1]) } ?: expression.split(DEFAULT_DELIMITER_REGEX)

        return tokens
            .requireOrThrow("음수는 지원하지 않습니다.") { it.toInt() >= 0 }
            .sumOf { it.toInt() }
    }

    companion object {
        private val DEFAULT_DELIMITER_REGEX = "[,:]".toRegex()
        private val CUSTOM_DELIMITER_REGEX = "//(.*)\\\\n(.*)".toRegex()
    }
}
