package lotto.domain.selling

import lotto.domain.lotto.LottoTicket
import lotto.domain.lotto.LottoType
import lotto.domain.lotto.WinningLottoTicket

data class PaymentResult(
    val money: Int,
    val change: Int,
    private val lottoTickets: List<LottoTicket>
) {

    fun findLottoTickets(type: LottoType) = lottoTickets.filter { it.lottoType == type }

    fun exchange(winningLottoTicket: WinningLottoTicket): ExchangeResult {
        val exchangeDetails = lottoTickets.groupingBy {
            Rank(winningLottoTicket.matchCount(it), winningLottoTicket.matchBonus(it))
        }.eachCount().toSortedMap()

        return ExchangeResult(money, exchangeDetails)
    }
}
