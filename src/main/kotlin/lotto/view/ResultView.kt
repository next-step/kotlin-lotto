package lotto.view

import lotto.domain.LottoStatistics
import lotto.domain.Lottos
import lotto.domain.Money
import kotlin.math.floor

class ResultView {

    fun printBoughtResult(lottos: Lottos) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println(it.numbers)
        }
        println()
    }

    fun printStatistics(statistics: LottoStatistics, profit: Money) {
        println("당첨 통계")
        println("---------")
        statistics.forEach { (prize, count) ->
            println("${prize.matchCount}개 일치 (${prize.money}원)- ${count}개")
        }
        printProfit(profit)
    }

    private fun printProfit(profit: Money) {
        val profitPercent = floor(profit * MAX_PERCENT) / MAX_PERCENT
        print("총 수익률은 ${profitPercent}입니다.")
        print("(기준이 ${PROFIT_PERCENT_STANDARD}이기 때문에 ")
        print(
            when {
                profitPercent < PROFIT_PERCENT_STANDARD -> "결과적으로 손해라는 의미임)"
                profitPercent == PROFIT_PERCENT_STANDARD.toDouble() -> "결과적으로 동일하다는 의미임)"
                else -> "결과적으로 이득이라는 의미임)"
            }
        )
    }

    companion object {
        private const val PROFIT_PERCENT_STANDARD = 1
        private const val MAX_PERCENT: Double = 100.0
    }
}
