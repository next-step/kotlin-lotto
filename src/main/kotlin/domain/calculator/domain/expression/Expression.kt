package domain.calculator.domain.expression

@JvmInline
value class Expression(private val _expression: String?) {
    val expression: String
        get() {
            if (_expression.isNullOrBlank()) {
                return DEFAULT_STRING
            }
            return _expression
        }

    val customSeparator: String
        get() {
            val result: MatchResult? = Regex(SEPARATOR_REGEX).find(expression)
            result?.let { return it.groupValues[CUSTOM_SEPARATOR_INDEX] }
            throw RuntimeException(NO_HAVE_CUSTOM_SEPARATOR_EXCEPTION_MESSAGE)
        }

    fun hasCustomExpression(): Boolean {
        val result: MatchResult? = Regex(SEPARATOR_REGEX).find(expression)
        result?.let { return true }
        return false
    }

    companion object {
        private const val NO_HAVE_CUSTOM_SEPARATOR_EXCEPTION_MESSAGE = "커스텀 구분자가 없습니다."

        private const val SEPARATOR_REGEX = "//(.)\n(.*)" // 이거 인터페이스 분리해야겠다.
        private const val DEFAULT_STRING = "0"

        private const val CUSTOM_SEPARATOR_INDEX = 1
        private const val NUMBER_POSITION = 2
    }
}
