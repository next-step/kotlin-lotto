package lotto.domain

@JvmInline
value class Money(val value: Int) {

    init {
        require(value >= MONEY_MIN_LIMIT) {
            "$REQUIRE_POSITIVE_NUMBER_MESSAGE $value"
        }
    }

    operator fun plus(other: Money): Money = Money(value + other.value)

    operator fun div(other: Money) = Money(value / other.value)

    infix fun times(count: Int): Money = Money(value * count)

    operator fun compareTo(other: Money): Int = value.compareTo(other.value)

    override fun toString(): String = value.toString()

    companion object {
        val ZERO: Money = Money(0)
        private const val MONEY_MIN_LIMIT = 0
        private const val REQUIRE_POSITIVE_NUMBER_MESSAGE = "Require Positive Number. Input Value:"
        private const val NOT_CONVERTABLE_VALUE_MESSAGE = "Required Number converted value. Input: "

        fun from(value: String): Money =
            value.toIntOrNull()
                ?.let(::Money)
                ?: throw IllegalArgumentException("$NOT_CONVERTABLE_VALUE_MESSAGE $value")
    }
}
