package stringcalculator

@JvmInline
value class StringToken(private val token: String) {
    init {
        validateIsInt(token)
        validateIsPositive(token)
    }

    val getIntValue: Int
        get() = token.toInt()

    private fun validateIsPositive(token: String) {
        if (token.toInt() < 0) {
            throw RuntimeException("주어진 값 ($token)은 음수입니다.")
        }
    }

    private fun validateIsInt(token: String) {
        token.toIntOrNull() ?: throw RuntimeException("주어진 값 ($token)은 숫자가 아닙니다.")
    }
}
