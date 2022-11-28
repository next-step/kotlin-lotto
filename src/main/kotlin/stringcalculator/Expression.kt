package stringcalculator

data class Expression(val tokens: List<Int>) {
    companion object {
        fun from(expression: String?): Expression {
            if (expression.isNullOrBlank()) {
                return DEFAULT_EXPRESSION
            }
            val result = DEFAULT_REGEX.find(expression)
            val tokens = result?.let {
                val delimiter = it.groupValues[1]
                it.groupValues[2].split(delimiter, *DEFAULT_DELIMITER).map(String::toInt)
            } ?: expression.split(*DEFAULT_DELIMITER).map(String::toInt)
            require(tokens.all { token -> token >= 0 }) { "음수는 인자로 받을 수 없습니다." }
            return Expression(tokens)
        }
        private val DEFAULT_DELIMITER = arrayOf(":", ",")
        private val DEFAULT_REGEX = Regex("//(.)\n(.*)")
        private val DEFAULT_EXPRESSION = Expression(listOf(0))
    }
}
