package lotto.ui

import lotto.ui.dto.LottoTicketsDto
import lotto.ui.dto.LottoStatisticsDto
import lotto.ui.dto.LottoTicketDto

object ConsoleOutputView {

    fun printTicketCount(ticketCount: Int) {
        println("${ticketCount}개를 구매했습니다.")
    }

    fun printLottoTickets(tickets: LottoTicketsDto) {
        tickets.tickets.forEach(::printLottoTicket)
    }

    private fun printLottoTicket(ticket: LottoTicketDto) {
        val numbers = ticket.lottoNumbers.joinToString(", ")
        println("[${numbers}]")
    }

    fun printStatistics(statistics: LottoStatisticsDto) {
        println("당첨 통계\n" + "------------------------")
        statistics.statistics.forEach { (ranking, count) ->
            println("${ranking.count}개 일치 (${ranking.reward}) - ${count}개")
        }
        println("총 수익률은 %.2f입니다.".format(statistics.revenue))
    }
}
