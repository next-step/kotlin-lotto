package lotto.domain

@JvmInline
value class Money(val value: Int) {
    init {
        require(value >= 0) { "금액은 0 이상이어야 합니다." }
    }

    operator fun plus(other: Money) = Money(value + other.value)

    operator fun minus(other: Money) = Money(value - other.value)

    operator fun times(count: Int) = Money(value * count)

    operator fun div(other: Money) = Money(value / other.value)

    operator fun compareTo(other: Money) = value.compareTo(other.value)

    fun toDouble(): Double = value.toDouble()

    override fun toString(): String = value.toString()

    companion object {
        val ZERO = Money(0)
    }
}
