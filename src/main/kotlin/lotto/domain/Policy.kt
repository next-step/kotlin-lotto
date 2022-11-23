package lotto.domain

object Policy {
    val LOTTO_RANGE = 1..45
}

object TicketPolicy {
    const val LOTTO_COUNT = 6
    const val PURCHASE_FEE = 1000
    fun generateNumber() = Policy.LOTTO_RANGE.random()
}
