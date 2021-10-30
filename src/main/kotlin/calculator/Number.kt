package calculator

@JvmInline
value class Number private constructor(val value: Int) {
    companion object {
        fun make(token: String): Number {
            val value = token.toInt()
            require(value >= 0) {
                "음수는 불가능합니다."
            }
            return Number(value)
        }
    }
}
