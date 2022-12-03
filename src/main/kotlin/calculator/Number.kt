package calculator

@JvmInline
value class Number(
    val value: Int,
) {
    companion object {
        fun of(str: String): Number {
            val value = str.toIntOrNull()?.let {
                require(it >= 0) { RuntimeException("음수는 입력할 수 없습니다.") }
                it
            } ?: throw RuntimeException("숫자를 입력해주세요.")
            return Number(value)
        }

        fun zero(): Number = Number(0)
    }
}
