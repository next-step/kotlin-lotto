package lotto.domain

@JvmInline
value class Amount(private val value: Int) : Comparable<Amount> {
    operator fun plus(amount: Amount): Amount {
        return Amount(this.value + amount.value)
    }

    operator fun minus(amount: Amount): Amount {
        return Amount(this.value - amount.value)
    }

    operator fun div(amount: Amount): Amount {
        return Amount(this.value / amount.value)
    }

    override operator fun compareTo(other: Amount): Int {
        return this.value.compareTo(other.value)
    }

    fun toInt(): Int = value
}
