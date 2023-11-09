package lotto.view

import lotto.collection.LottoResults
import lotto.collection.LottoTicket
import lotto.collection.WinningMoney
import lotto.model.ProfitCalculator

object ResultView {
    fun renderTickets(lottoTickets: List<LottoTicket>): List<LottoTicket> {
        lottoTickets.forEach { ticket -> println(ticket.numbers.map { it.number }) }
        return lottoTickets
    }

    fun renderTicketCount(ticketCount: Int): Int {
        println("${ticketCount}개를 구매했습니다.")
        return ticketCount
    }

    fun renderResults(lottoResults: LottoResults) {
        println("당첨 통계")
        println("---------")
        lottoResults.results.forEach { (key, value) ->
            println("${key}개 일치 (${WinningMoney.getPrizePerMatch(value)}원) - ${value}개")
        }
        println("총 수익률은 ${String.format("%.2f", ProfitCalculator.calculate(lottoResults))}입니다.")
    }
}
