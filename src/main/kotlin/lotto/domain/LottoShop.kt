package lotto.domain

import lotto.vo.Money

class LottoShop(private val lottoMachine: LottoMachine = DefaultLottoMachine) {
    fun buying(amount: Money): LottoTickets {
        val ticketCount = amount / LOTTO_TICKET_PRICE
        return LottoTickets((1..ticketCount).map { lottoMachine.generate() })
    }

    companion object {
        val LOTTO_TICKET_PRICE = Money.of(1_000)
    }
}
