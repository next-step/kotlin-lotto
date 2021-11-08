package lotto.domain

data class Money(val value: Int) {

    override fun toString(): String {
        return value.toString()
    }

    operator fun plus(other: Money) = Money(value + other.value)
    operator fun div(other: Money) = value / other.value
    operator fun compareTo(other: Money) = value.compareTo(other.value)
}
