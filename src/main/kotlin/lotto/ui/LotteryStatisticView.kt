package lotto.ui

import lotto.domain.Lotto
import lotto.domain.Price

object LotteryStatisticView {

    fun display(investment: Int, lotteries: List<Lotto>) {
        println("당첨 통계")
        println("---------")

        val result = lotteries.groupBy { it.price }.toMap()
        println("3개 일치 (5000원)- ${result[Price.FOURTH]?.count() ?: 0}개")
        println("4개 일치 (50000원)- ${result[Price.THIRD]?.count() ?: 0}개")
        println("5개 일치 (1500000원)- ${result[Price.SECOND]?.count() ?: 0}개")
        println("6개 일치 (1500000원)- ${result[Price.FIRST]?.count() ?: 0}개")

        printEarningRate(investment, result)
    }

    private fun printEarningRate(investment: Int, priceGroupedLotteries: Map<Price, List<Lotto>>) {
        val profit = priceGroupedLotteries.values.flatten().sumOf { it.winnerPrize() }
        val earningRate = profit.toFloat().div(investment)
        print("총 수익률은 ${String.format("%.2f" ,earningRate)}입니다. ")
        when {
            earningRate > 1 -> println("(익절)")
            earningRate < 1 -> println("(손절)")
            else -> println("(손익분기점)")
        }
    }
}
