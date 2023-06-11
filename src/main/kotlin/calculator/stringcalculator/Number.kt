package calculator.stringcalculator

@JvmInline
value class Number(val value: Int) {

    init {
        require(value >= 0) {
            throw RuntimeException("$REQUIRE_POSITIVE_NUMBER_MESSAGE $value")
        }
    }

    operator fun plus(other: Number): Number = Number(value + other.value)

    companion object {
        val ZERO: Number = Number(0)
        private const val REQUIRE_NUMBER_MESSAGE = "Require Number. InputValue:"
        private const val REQUIRE_POSITIVE_NUMBER_MESSAGE = "Require Positive Number. Input Value:"

        fun from(stringValue: String): Number {
            return stringValue.trim()
                .toIntOrNull()
                ?.run { Number(this) }
                ?: throw RuntimeException("$REQUIRE_NUMBER_MESSAGE $stringValue")
        }
    }
}
