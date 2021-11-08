package lotto.domain.money

interface Money {
    val value: Int
    val displayValue: String

    operator fun div(other: Money) = value / other.value
    operator fun compareTo(other: Money) = value.compareTo(other.value)
}
