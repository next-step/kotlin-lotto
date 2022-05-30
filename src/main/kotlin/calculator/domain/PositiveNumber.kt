package calculator.domain

data class PositiveNumber(
    val value: Int,
) {
    init {
        if (value < 0) {
            throw RuntimeException("덧셈 피연산자 값은 음수일 수 없습니다. ($value)")
        }
    }

    companion object {
        fun from(text: String): PositiveNumber {
            val value = kotlin.runCatching { text.toInt() }
                .getOrElse { throw RuntimeException("'$text' 는 정수로 변환할 수 없는 문자열입니다.") }

            return PositiveNumber(value = value)
        }
    }
}
