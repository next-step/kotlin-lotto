package lotto.domain

import lotto.domain.lottoticket.LottoTicket
import lotto.domain.lottoticket.LottoTickets

class LottoShop(
    private val lottoTicketMachine: LottoTicketMachine = LottoTicketMachine()
) {
    fun sellLottoTickets(
        money: Money,
        manualNumbersList: List<List<Int>>
    ): LottoTickets {
        val totalTicketCount = money.divideInt(LottoTicket.PRICE)
        require(totalTicketCount >= manualNumbersList.count()) { "주어진 금액으로는 입력한 만큼의 수동 로또를 구매할 수 없습니다." }

        val manalLottoTickets = LottoTickets(manualNumbersList.map { lottoTicketMachine.createManualTicket(it) })
        val autoLottoTickets = lottoTicketMachine.createAutoTickets(totalTicketCount - manalLottoTickets.getCount())

        return manalLottoTickets.combine(autoLottoTickets)
    }
}
