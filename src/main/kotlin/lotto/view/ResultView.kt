package lotto.view

import lotto.domain.LottoResult
import lotto.domain.Lottos
import lotto.domain.Prize
import kotlin.math.floor

class ResultView {

    fun printBoughtResult(lottos: Lottos) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println(it.numbers)
        }
        println()
    }

    fun printStatistics(result: LottoResult) {
        println("당첨 통계")
        println("---------")
        result.statistics().forEach {
            println("${it.prize.matchCount}개 일치 (${it.prize.money}원)- ${it.count}개")
        }
    }

    fun printProfit(result: LottoResult) {
        val profitPercent = floor(result.profit() * 100) / 100
        print("총 수익률은 ${profitPercent}입니다.")
        print("(기준이 ${PROFIT_PERCENT_STANDARD}이기 때문에 ")
        when {
            profitPercent < PROFIT_PERCENT_STANDARD -> {
                print("결과적으로 손해라는 의미임)")
            }
            profitPercent == PROFIT_PERCENT_STANDARD.toDouble() -> {
                print("결과적으로 동일하다는 의미임)")
            }
            else -> {
                print("결과적으로 이득이라는 의미임)")
            }
        }
    }

    companion object {
        private const val PROFIT_PERCENT_STANDARD = 1
    }
}
