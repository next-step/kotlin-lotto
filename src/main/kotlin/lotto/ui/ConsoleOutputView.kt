package lotto.ui

import lotto.ui.dto.LottoNumbersDto
import lotto.ui.dto.LottoStatisticsDto

object ConsoleOutputView {

    fun printTicketCount(ticketCount: Int) {
        println("${ticketCount}개를 구매했습니다.")
    }

    fun printLottoTickets(tickets: LottoNumbersDto) {
        val numbers = tickets.lottoNumbers.joinToString(", ")
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
