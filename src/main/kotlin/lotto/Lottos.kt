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

    companion object {
        private val TICKET_PRICE: Amount = Amount(1000)
    }
}
