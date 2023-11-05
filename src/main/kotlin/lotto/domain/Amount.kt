package lotto.domain

@JvmInline
value class Amount(
    val value: Int
) {
    init {
        require(value >= 0) { "금액은 0보다 크거나 같아야 합니다" }
    }

    operator fun plus(other: Amount): Amount =
        Amount(value + other.value)

    operator fun times(count: Int): Amount =
        Amount(value * count)

    operator fun div(other: Amount): Int =
        value / other.value

    operator fun rem(other: Amount): Int =
        value % other.value
}


