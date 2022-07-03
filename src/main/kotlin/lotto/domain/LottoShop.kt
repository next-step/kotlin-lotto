package lotto.domain

import lotto.domain.lottoticket.LottoNumbers
import lotto.domain.lottoticket.LottoTicket
import lotto.domain.lottoticket.LottoTickets

class LottoShop(
    private val lottoTicketMachine: LottoTicketMachine = LottoTicketMachine()
) {

    fun canNotPurchasableBy(money: Money, lottoNumbersCount: Int): Boolean {
        val ticketCount = money.divideInt(LottoTicket.PRICE)
        return ticketCount >= lottoNumbersCount
    }

    fun sellLottoTickets(
        money: Money,
        lottoNumbersList: List<LottoNumbers>
    ): LottoTickets {
        val totalTicketCount = money.divideInt(LottoTicket.PRICE)

        val manalLottoTickets = LottoTickets(lottoNumbersList.map { lottoTicketMachine.createManualTicket(it) })
        val autoLottoTickets = lottoTicketMachine.createAutoTickets(totalTicketCount - manalLottoTickets.totalCount)

        return manalLottoTickets + autoLottoTickets
    }
}
