package lotto

data class Lottos(val values: List<Lotto>) {
    val size: Int = values.size
    val totalAmount: Amount
        get() = TICKET_PRICE.times(values.size)

    fun match(
        otherLotto: Lotto,
        isBonus: Boolean,
    ): List<Rank> {
        return values.map { Rank.match(it.match(otherLotto), isBonus) }
    }

    fun merge(other: Lottos): Lottos {
        return Lottos(values + other.values)
    }

    companion object {
        fun from(count: Int, generator: () -> List<Int>): Lottos {
            return Lottos(List(count) { Lotto.from(generator()) })
        }

        private val TICKET_PRICE: Amount = Amount(1000)
    }
}
