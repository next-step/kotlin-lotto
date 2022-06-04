package lotto.domain

import lotto.constants.ErrorMessages

/**
 * Created by Jaesungchi on 2022.05.24..
 */
class LottoStore(private var money: Int) {
    fun buyManualLotto(count: () -> Int, lists: (Int) -> List<String>): LottoTickets {
        val manualCount = count.invoke()
        money -= manualCount * LOTTO_PRICE
        if (money < 0) {
            throw IllegalArgumentException(ErrorMessages.MANUAL_LOTTO_COUNT_IS_OVER_MONEY)
        }
        return LottoTickets.of(lists.invoke(manualCount))
    }

    fun buyAutoLotto(): LottoTickets {
        val ticketCount = money / LOTTO_PRICE
        return LottoTickets(List(ticketCount) { LottoTicketFactory.getRandomLottoTicket() })
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
