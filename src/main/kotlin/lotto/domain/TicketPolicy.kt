package lotto.domain

object TicketPolicy {

    const val LOTTO_COUNT = 6

    fun generateNumber() = NumberPolicy.LOTTO_RANGE.random()

}
