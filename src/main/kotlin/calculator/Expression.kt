package calculator

class Expression private constructor(val value: String) {
    companion object {
        fun from(expression: String?): Expression {
            require(!expression.isNullOrBlank()) { "빈 문자열 또는 null 을 입력할 수 없습니다." }
            return Expression(value = expression)
        }
    }
}
