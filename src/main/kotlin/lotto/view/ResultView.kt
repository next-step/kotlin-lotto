package lotto.view

import lotto.model.LottoTicket
import lotto.model.Prize

object ResultView {
    fun renderTickets(lottoTickets: List<LottoTicket>) {
        lottoTickets.forEach { ticket -> println(ticket.numbers.map { it.number }) }
    }

    fun renderTicketCount(ticketCount: Int, manualCount: Int) {
        println("수동으로 ${manualCount}장, 자동으로 ${ticketCount - manualCount}개를 구매했습니다.")
    }

    fun renderResults(results: Map<Prize, Int>) {
        println("당첨 통계")
        println("---------")

        Prize.values().forEach {
            println("${it.matched}개 일치${if (it == Prize.SECOND) ", 보너스 볼 일치" else ""} (${it.prize}원) - ${results[it] ?: 0}개")
        }
    }

    fun renderProfit(profit: Double) {
        println("총 수익률은 ${String.format("%.2f", profit)}입니다.")
    }
}
