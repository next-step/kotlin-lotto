package calculator.domain

class Expression(
    val value: String = DEFAULT_EXPRESSION_VALUE
) {

    init {
        validateExpression()
    }

    private fun validateExpression() {
        value.forEach {
            runCatching { it.digitToInt() }
                .onFailure { throw IllegalArgumentException("숫자 외에 다른 문자는 들어올 수 없습니다.") }
        }
    }

    companion object {
        private const val DEFAULT_EXPRESSION_VALUE = ""
    }

}