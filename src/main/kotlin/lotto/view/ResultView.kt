package lotto.view

import lotto.model.LottoResults
import lotto.model.LottoTicket
import lotto.model.Prize

object ResultView {
    fun renderTickets(lottoTickets: List<LottoTicket>) {
        lottoTickets.forEach { ticket -> println(ticket.numbers.map { it.number }) }
    }

    fun renderTicketCount(ticketCount: Int) {
        println("${ticketCount}개를 구매했습니다.")
    }

    fun renderResults(results: Map<Prize, Int>) {
        println("당첨 통계")
        println("---------")
        results.forEach { (key, value) ->
            println("${key.matched}개 일치 (${key.prize}원) - ${value}개")
        }
    }

    fun renderProfit(profit: Double) {
        println("총 수익률은 ${String.format("%.2f", profit)}입니다.")
    }
}
