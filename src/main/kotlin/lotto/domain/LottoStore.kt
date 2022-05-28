package lotto.domain

import lotto.model.LottoTicket

/**
 * Created by Jaesungchi on 2022.05.24..
 */
class LottoStore {
    fun buyLotto(money: Int): List<LottoTicket> {
        val ticketCount: Int = money / LOTTO_PRICE
        return List(ticketCount) { LottoTicketFactory.getRandomLottoTicket() }
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
