package lotto.view

import lotto.domain.Lottos
import lotto.domain.enum.Priority

object Screen {
    fun displayTicketInfo(lottos: Lottos, manualLottoAmount: Int) {
        displayTicketAmount(lottos.tickets.size, manualLottoAmount)
        displayTicketNumbers(lottos)
    }

    private fun displayTicketAmount(manualLottoAmount: Int, authLottoAmount: Int) {
        println("수동으로 ${manualLottoAmount}장, 자동으로 ${authLottoAmount}개를 구매했습니다.")
    }

    private fun displayTicketNumbers(lottos: Lottos) {
        for (ticket in lottos.tickets) {
            println("${ticket.lottoNumbers.map { it.number }}")
        }
    }

    fun display(
        statistics: Map<Priority, Int>,
        returnRate: Double
    ) {
        displayStatistics(statistics)
        displayReturnRate(returnRate)
    }

    private fun displayStatistics(statistics: Map<Priority, Int>) {
        println("당첨 통계")
        println("---------")

        for ((priority, count) in statistics) {
            displayStatistic(priority.matchCount, count)
        }
    }

    private fun displayStatistic(matchNumber: Int, count: Int) {
        println("${matchNumber}개 일치 (${Priority.getPrice(matchNumber)}원)- ${count}개")
    }

    private fun displayReturnRate(returnRate: Double) {
        println("총 수익률은 ${String.format("%.2f", returnRate)}입니다.")
    }
}
