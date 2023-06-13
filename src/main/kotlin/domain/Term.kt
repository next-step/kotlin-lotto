package domain

@JvmInline
value class Term private constructor(val value: Int) {

    constructor(input: String) : this(input.toPositiveOrThrow())

    companion object {
        @JvmStatic
        private fun String.toPositiveOrThrow(): Int {
            val value = toIntOrNull() ?: throw RuntimeException("숫자가 아닙니다.")
            require(value >= 0) { "음수는 입력할 수 없습니다." }
            return value
        }
    }
}
