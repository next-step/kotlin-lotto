package lotto.domain

import lotto.domain.lottoticket.LottoNumbers
import lotto.domain.lottoticket.LottoTicket
import lotto.domain.lottoticket.LottoTickets

class LottoShop(
    private val lottoTicketMachine: LottoTicketMachine = LottoTicketMachine()
) {
    fun sellLottoTickets(
        money: Money,
        lottoNumbersList: List<LottoNumbers>
    ): LottoTickets {
        val totalTicketCount = money.divideInt(LottoTicket.PRICE)
        require(totalTicketCount >= lottoNumbersList.count()) { "주어진 금액으로는 입력한 만큼의 수동 로또를 구매할 수 없습니다." }

        val manalLottoTickets = LottoTickets(lottoNumbersList.map { lottoTicketMachine.createManualTicket(it) })
        val autoLottoTickets = lottoTicketMachine.createAutoTickets(totalTicketCount - manalLottoTickets.totalCount)

        return manalLottoTickets.combine(autoLottoTickets)
    }
}
