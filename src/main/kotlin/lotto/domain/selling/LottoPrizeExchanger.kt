package lotto.domain.selling

import lotto.domain.LottoTicket

object LottoPrizeExchanger {

    fun exchange(paymentResult: PaymentResult, winningLottoTicket: LottoTicket): ExchangeResult {
        val exchangeDetails = paymentResult.lottoTickets.groupingBy {
            Prize(it.getMatchCount(winningLottoTicket))
        }.eachCount().toSortedMap()

        return ExchangeResult(paymentResult, exchangeDetails)
    }
}
