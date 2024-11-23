package calculator

import java.lang.RuntimeException

class Expression(val expressions: List<String>) {

    init {
        validate()
    }

    private fun validate() {
        expressions.forEach {
            if(it.toInt() < 0) {
                throw RuntimeException("음수는 입력할 수 없습니다. input = $it")
            }
        }
    }

    fun sum(): Int {
        return expressions.sumOf { it.toInt() }
    }

    companion object {
        private const val DEFAULT_DELIMITER_PATTERN = "[,:]"
        private const val CUSTOM_DELIMITER_PATTERN = "//(.*?)\\n"

        private val DEFAULT_DELIMITER_REGEX = DEFAULT_DELIMITER_PATTERN.toRegex()
        private val CUSTOM_DELIMITER_REGEX = CUSTOM_DELIMITER_PATTERN.toRegex()

        fun created(expression: String): Expression {
            if(expression.isBlank()) {
                return Expression(emptyList())
            }
            val matchResult = CUSTOM_DELIMITER_REGEX.find(expression)
            if(matchResult != null) {
                val customDelimiter = matchResult.groupValues[1]
                val expressionWithoutCustomDelimiter = expression.substringAfter("\n")
                return Expression(expressionWithoutCustomDelimiter.split(customDelimiter))
            }
            return Expression(expression.split(DEFAULT_DELIMITER_REGEX))
        }
    }
}
