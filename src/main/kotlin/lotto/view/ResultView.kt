package lotto.view

import lotto.domain.Lotto
import lotto.domain.WinningPrize
import lotto.domain.WinningStatistics

object ResultView {
    fun displayLottoTicketCount(ticketCount: Int) {
        println("${ticketCount}개를 구매했습니다.")
    }

    fun printAutoGenerateLotto(lottos: List<Lotto>) {
        val lottoResults = lottos.joinToString(separator = "\n") { lottoString(it) }
        println(lottoResults)
    }

    fun printWinningStatistics(statistics: WinningStatistics) {
        println("\n당첨 통계")
        println("---------")

        printMatcherResult(statistics)
        printWinningRateResult(statistics)
    }

    private fun printMatcherResult(statistics: WinningStatistics) {
        (3..6).forEach { matchCount ->
            val count = statistics.matchCount[matchCount] ?: 0
            val prize = WinningPrize.findByMatchCount(matchCount)
            println("$matchCount 개 일치 (${prize}원)- ${count}개")
        }
    }

    private fun printWinningRateResult(statistics: WinningStatistics) {
        val winningRateFormatted = "%.2f".format(statistics.rate)
        println("총 수익률은 ${winningRateFormatted}입니다.")
    }

    private fun lottoString(lotto: Lotto) =
        lotto.numbers.joinToString(separator = ", ", prefix = "[", postfix = "]") {
            it.value.toString()
                .padStart(2, ' ')
        }
}
