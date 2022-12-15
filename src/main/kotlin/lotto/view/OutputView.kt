package lotto.view

import lotto.domain.StatisticalResultExtractor
import lotto.domain.WinningAmount

object OutputView {
    private const val OUTPUT_START_NUMBER = 3
    private const val OUTPUT_END_NUMBER = 6
    fun printOutput(statisticalResultExtractor: StatisticalResultExtractor, ticketCount: Int) {

        println("당첨 통계")
        println("---------")

        (OUTPUT_START_NUMBER..OUTPUT_END_NUMBER).forEach { key ->
            val matchCount = statisticalResultExtractor.getMatchCount(key)
            println("$key 개 일치 (${WinningAmount.from(key).amount})- $matchCount")
        }

        val totalRateOfReturn = statisticalResultExtractor.getTotalRateOfReturn(ticketCount)
        println("총 수익률은 $totalRateOfReturn 입니다.")
    }
}
