package lotto.domain.selling

import lotto.domain.LottoTicket

object LottoExchanger {

    fun exchange(lottoTickets: List<LottoTicket>, winningLottoTicket: LottoTicket): ExchangeResult {
        val exchangeDetails = lottoTickets.groupingBy { it.getMatchCount(winningLottoTicket) }.eachCount()
        return ExchangeResult(exchangeDetails)
    }
}
