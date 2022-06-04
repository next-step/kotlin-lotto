package lotto.domain

/**
 * Created by Jaesungchi on 2022.05.24..
 */
class LottoStore {
    fun buyAutoLotto(money: Int): LottoTickets {
        val ticketCount: Int = money / LOTTO_PRICE
        return LottoTickets(List(ticketCount) { LottoTicketFactory.getRandomLottoTicket() })
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
