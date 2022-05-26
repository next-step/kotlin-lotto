package lotto.ui

import lotto.domain.Lotto
import lotto.domain.Price

object LotteryStatisticView {

    fun display(priceGroupedLotteries: Map<Price, List<Lotto>>, earningRate: Float) {
        println("당첨 통계")
        println("---------")

        printPriceGroupedLotteries(priceGroupedLotteries)

        printEarningRate(earningRate)
    }

    private fun printPriceGroupedLotteries(priceGroupedLotteries: Map<Price, List<Lotto>>) {
        println("3개 일치 (5000원)- ${priceGroupedLotteries[Price.FOURTH]?.count() ?: 0}개")
        println("4개 일치 (50000원)- ${priceGroupedLotteries[Price.THIRD]?.count() ?: 0}개")
        println("5개 일치 (1500000원)- ${priceGroupedLotteries[Price.SECOND]?.count() ?: 0}개")
        println("6개 일치 (1500000원)- ${priceGroupedLotteries[Price.FIRST]?.count() ?: 0}개")
    }

    private fun printEarningRate(earningRate: Float) {
        print("총 수익률은 ${String.format("%.2f" ,earningRate)}입니다. ")
        when {
            earningRate > 1 -> println("(익절)")
            earningRate < 1 -> println("(손절)")
            else -> println("(손익분기점)")
        }
    }
}
