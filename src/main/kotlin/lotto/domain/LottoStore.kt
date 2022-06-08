package lotto.domain

/**
 * Created by Jaesungchi on 2022.05.24..
 */
class LottoStore(private var money: Money) {
    fun buyManualLotto(count: () -> Int, lists: (Int) -> List<String>): LottoTickets {
        val manualCount = count.invoke()
        money -= manualCount * LOTTO_PRICE
        return LottoTickets.of(lists.invoke(manualCount))
    }

    fun buyAutoLotto(): LottoTickets {
        val ticketCount = money / LOTTO_PRICE
        return LottoTicketFactory.getRandomLottoTickets(ticketCount)
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
