package lotto.view

import lotto.business.LotteryPrize
import lotto.business.PrizeResults
import lotto.business.ProfitRate

object LotteryStatisticsPrinter {
    fun print(lotteryStatistics: PrizeResults, profitRate: ProfitRate) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (5000원) - ${lotteryStatistics.prizeCountMap[LotteryPrize.THREE_MATCH]}개")
        println("4개 일치 (50000원) - ${lotteryStatistics.prizeCountMap[LotteryPrize.FOUR_MATCH]}개")
        println("5개 일치 (1500000원) - ${lotteryStatistics.prizeCountMap[LotteryPrize.FIVE_MATCH]}개")
        println("6개 일치 (2000000000원) - ${lotteryStatistics.prizeCountMap[LotteryPrize.SIX_MATCH]}개")
        println("총 수익률은 ${profitRate.value}입니다.(기준이 1이기 때문에 결과적으로 ${profitRate.evaluateProfitOrLoss()}라는 의미임)")
    }
}