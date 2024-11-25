package string_calculator

object ExpressionParser {
    fun parseToInts(expression: String, delimiters: Regex): List<Int> =
        expression.split(delimiters).map {
            val num = if (it.isBlank()) 0 else it.toIntOrNull() ?: throw RuntimeException("숫자로 변환할 수 없습니다")
            if (num < 0) throw RuntimeException("음수는 입력할 수 없습니다")
            num
        }
}