package calculator

@JvmInline
value class PositiveNumber(val value: Int) {

    init {
        require(value > 0) { "음수는 입력될 수 없다" }
    }

    operator fun plus(positiveNumber: PositiveNumber) = PositiveNumber(value + positiveNumber.value)

    companion object {
        fun from(value: String): PositiveNumber = PositiveNumber(parseToNumber(value))

        private fun parseToNumber(value: String) =
            value.toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닌 문자를 입력할 수 없다")
    }
}
