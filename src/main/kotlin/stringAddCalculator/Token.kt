package stringAddCalculator

@JvmInline
value class Token(
    val value: Int
) {
    companion object {
        fun of(value: String): Token {
            val trimmedValue = value.trim()
            require(trimmedValue.toIntOrNull() != null) {
                "토큰 값은 숫자여야 합니다."
            }
            require(trimmedValue.toInt() >= 0) {
                "토큰 값으로 음수는 들어올 수 없습니다."
            }
            return Token(trimmedValue.toInt())
        }
    }
}
