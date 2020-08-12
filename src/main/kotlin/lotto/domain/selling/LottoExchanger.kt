package lotto.domain.selling

import lotto.domain.WinningLottoTicket

object LottoExchanger {

    fun exchange(
        paymentResult: PaymentResult,
        winningLottoTicket: WinningLottoTicket
    ): ExchangeResult {
        val exchangeDetails = paymentResult.lottoTickets.groupingBy {
            Rank(winningLottoTicket.matchCount(it), winningLottoTicket.matchBonus(it))
        }.eachCount().toSortedMap()

        return ExchangeResult(paymentResult.money, exchangeDetails)
    }
}
