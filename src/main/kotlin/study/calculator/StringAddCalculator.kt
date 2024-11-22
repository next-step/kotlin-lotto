package study.calculator

/**
 * @author 이상준
 */
class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) return 0

        val expression = customDelimiter(text)
        if (expression.tokens.any { it.toInt() < 0 }) {
            throw RuntimeException("음수는 입력할 수 없습니다.")
        }

        return expression.tokens.sumOf {
            it.toInt()
        }
    }

    private fun customDelimiter(text: String): Expression {
        val result = Regex(CUSTOM_DELIMITER_PATTERN).find(text)
        result?.let {
            return Expression(it.groupValues[1], it.groupValues[2])
        }

        return Expression(DEFAULT_DELIMITER_PATTERN, text)
    }

    data class Expression(val delimiter: String, val numberText: String) {
        val tokens
            get() = numberText.split(delimiter.toRegex())
    }

    companion object {
        const val CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)"
        const val DEFAULT_DELIMITER_PATTERN = "[,:]"
    }
}
