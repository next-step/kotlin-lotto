package lotto.view

import lotto.domain.Lottery
import lotto.domain.Rank

object ResultView {

    fun printLotteries(lotteries: List<Lottery>) {
        println("${lotteries.size}개를 구매했습니다.")
        lotteries.forEach { lottery ->
            println(lottery)
        }
    }

    fun printStatistics(result: Map<Rank, Int>) {
        println("\n당첨 통계\n---------")
        result.forEach {
            println("${it.key}- ${it.value}개")
        }
    }

    fun printEarningRate(earningRate: Float, isLoss: Boolean) {
        print("총 수익률은 ${earningRate}입니다.")
        if (isLoss) println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)") else println()
    }
}
