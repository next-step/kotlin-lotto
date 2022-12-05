package calculator

class Expression private constructor(val value: String) {
    fun hasCustomDelimiter(): Boolean {
        val result = Regex(CUSTOM_DELIMITER_REG_EXP).find(this.value)
        return result != null
    }
    companion object {
        const val CUSTOM_DELIMITER_REG_EXP = "//(.)\n(.*)"

        fun from(expression: String?): Expression {
            require(!expression.isNullOrBlank()) { "빈 문자열 또는 null 을 입력할 수 없습니다." }
            return Expression(value = expression)
        }
    }
}
