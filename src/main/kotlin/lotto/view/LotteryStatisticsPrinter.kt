package lotto.view

import lotto.business.LotteryStatistics
import lotto.business.ProfitRate

object LotteryStatisticsPrinter {
    fun print(lotteryStatistics: LotteryStatistics, profitRate: ProfitRate) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (5000원) - ${lotteryStatistics.treeMatchCount}개")
        println("4개 일치 (50000원) - ${lotteryStatistics.fourMatchCount}개")
        println("5개 일치 (1500000원) - ${lotteryStatistics.fiveMatchCount}개")
        println("6개 일치 (2000000000원) - ${lotteryStatistics.sixMatchCount}개")
        println("총 수익률은 ${profitRate.value}입니다.(기준이 1이기 때문에 결과적으로 ${profitRate.evaluateProfitOrLoss()}라는 의미임)")
    }
}
