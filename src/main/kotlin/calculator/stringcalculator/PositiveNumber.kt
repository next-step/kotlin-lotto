package calculator.stringcalculator

@JvmInline
value class PositiveNumber(val value: Int) {

    init {
        require(value >= 0) {
            "$REQUIRE_POSITIVE_NUMBER_MESSAGE $value"
        }
    }

    operator fun plus(other: PositiveNumber): PositiveNumber = PositiveNumber(value + other.value)

    companion object {
        val ZERO: PositiveNumber = PositiveNumber(0)
        private const val REQUIRE_NUMBER_MESSAGE = "Require Number. InputValue:"
        private const val REQUIRE_POSITIVE_NUMBER_MESSAGE = "Require Positive Number. Input Value:"

        fun from(stringValue: String): PositiveNumber {
            return stringValue.trim()
                .toIntOrNull()
                ?.let(::PositiveNumber)
                ?: throw IllegalArgumentException("$REQUIRE_NUMBER_MESSAGE $stringValue")
        }
    }
}
