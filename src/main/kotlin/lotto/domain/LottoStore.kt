package lotto.domain

object LottoStore {

    private const val LOTTO_PRICE = 1000

    fun buyLotto(cash: Cash): LottoUnusedTickets {
        val ticketCount = cash.buy(LOTTO_PRICE)
        return LottoUnusedTickets.from(ticketCount)
    }
}
