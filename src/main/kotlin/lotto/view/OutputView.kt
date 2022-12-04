package lotto.view

import lotto.StatisticalResultExtractor
import lotto.domain.WinningAmount

object OutputView {
    fun printOutput(statisticalResultExtractor: StatisticalResultExtractor, ticketCount: Int) {
        println("당첨 통계")
        println("---------")

        (3..6).forEach { key ->
            val matchCount = statisticalResultExtractor.getMatchCount(key)
            println("$key 개 일치 (${WinningAmount.from(key).amount})- $matchCount")
        }

        val totalRateOfReturn = statisticalResultExtractor.getTotalRateOfReturn(ticketCount)
        println("총 수익률은 $totalRateOfReturn 입니다.")
    }
}
