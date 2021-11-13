package lotto.domain

@JvmInline
value class Money private constructor(
    val money: Int
) {

    operator fun div(other: Money) = money.div(other.money)

    operator fun compareTo(other: Money) = money.compareTo(other.money)

    companion object {
        const val NUMBER_FORMAT_EXCEPTION_MESSAGE = "금액은 숫자만 입력할 수 있습니다"

        fun from(value: Int): Money {
            return Money(value)
        }

        fun from(value: String): Money {
            return Money(value.toIntOrNull() ?: throw IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE))
        }
    }
}
