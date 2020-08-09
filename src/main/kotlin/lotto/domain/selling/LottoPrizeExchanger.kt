package lotto.domain.selling

import lotto.domain.WinningLottoTicket

object LottoPrizeExchanger {

    fun exchange(paymentResult: PaymentResult, winningLottoTicket: WinningLottoTicket): ExchangeResult {
        val exchangeDetails = paymentResult.lottoTickets.groupingBy {
            Rank(it.getMatchCount(winningLottoTicket), winningLottoTicket.matchBonus(it))
        }.eachCount().toSortedMap()

        return ExchangeResult(paymentResult, exchangeDetails)
    }
}
