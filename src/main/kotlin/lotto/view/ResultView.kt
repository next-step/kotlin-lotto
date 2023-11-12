package lotto.view

import lotto.LottoMachine
import lotto.LottoPrize

object ResultView {
    fun printWinningStatistics(winningResult: Map<Int, Int>) {
        println("당첨 통계")
        println("---------")

        val winningResult = buildString {
            for (matchingNumbers in 3..6) {
                val count = winningResult[matchingNumbers] ?: 0
                val prize = LottoPrize.getPrize(matchingNumbers)
                appendLine("$matchingNumbers 개 일치 ($prize)원- $count 개")
            }
        }
        println(winningResult)
    }

    fun printTotalProfitRate(totalPrize: Int, amount : Int) {
        val profitRate = LottoMachine.calculateTotalEarning(totalPrize, amount)
        println("총 수익률은 $profitRate 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }

}
