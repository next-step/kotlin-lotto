package calculator.stringcalculator

@JvmInline
value class Number(val value: Int) {

    init {
        require(value >= 0) {
            "$REQUIRE_POSITIVE_NUMBER_MESSAGE $value"
        }
    }

    companion object {
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
