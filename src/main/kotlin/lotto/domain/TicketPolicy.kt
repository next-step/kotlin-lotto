package lotto.domain

object TicketPolicy {

    const val LOTTO_COUNT = 6
    const val PURCHASE_FEE = 1000

    fun generateNumber() = NumberPolicy.LOTTO_RANGE.random()
}
