package calculator

@JvmInline
value class PositiveNumber(
    val number: Int,
) {
    init {
        require(number >= 0) { "0보다 큰 양수를 입력하세요" }
    }

    companion object {
        fun of(token: String): PositiveNumber {
            val intValue = token.toIntOrNull()
            requireNotNull(intValue) { "숫자를 입력하세요" }
            return PositiveNumber(intValue)
        }
    }
}
