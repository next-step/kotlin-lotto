package lotto.view

import lotto.domain.StatisticalResultExtractor
import lotto.domain.WinningAmount

object OutputView {
    fun printOutput(statisticalResultExtractor: StatisticalResultExtractor, ticketCount: Int) {
        println("당첨 통계")
        println("---------")

        WinningAmount.findWinningPrize().forEach { winningAmount ->
            val matchCount = statisticalResultExtractor.getMatchCount(winningAmount)
            print("${winningAmount.count} 개 일치")
            if (winningAmount.isBonusBallMatched) {
                print(", 보너스 볼 일치")
            }
            println(" (${winningAmount.amount})- $matchCount")
        }

        val totalRateOfReturn = statisticalResultExtractor.getTotalRateOfReturn(ticketCount)
        println("총 수익률은 $totalRateOfReturn 입니다.")
    }
}
