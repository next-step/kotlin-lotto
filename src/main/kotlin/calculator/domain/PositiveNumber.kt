package calculator.domain

data class PositiveNumber(
    val value: Int,
) {
    init {
        require(0 <= value) {
            throw RuntimeException("덧셈 피연산자 값은 음수일 수 없습니다. ($value)")
        }
    }

    companion object {
        fun from(text: String): PositiveNumber = kotlin.runCatching { PositiveNumber(text.toInt()) }
            .getOrElse { throw RuntimeException("'$text' 는 정수로 변환할 수 없는 문자열입니다.") }
    }
}
