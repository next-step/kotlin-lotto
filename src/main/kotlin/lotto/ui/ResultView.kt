package lotto.ui

import lotto.Lotto
import lotto.WinningStatistics

class ResultView {
    fun printPurchaseCount(count: Int) {
        println("${ count }개를 구매했습니다.")
    }

    fun printPurchaseLotteNumbers(lottoList: List<Lotto>) {
        lottoList.forEach { lotto ->
            println("${ lotto.publishNumbers }")
        }
    }

    fun printWinningStatisticsStart() {
        println()
        println("당첨 통계")
        println("---------")
    }

    fun printWinningStatistics(place: WinningStatistics.RANKING, winningCount: Int) {
        println("${ place.winningCount }개 일치 (${ place.winningPrice }원) - ${ winningCount }개")
    }

    fun printWinningStatisticsRate(rate: Float) {
        println("총 수익률은 ${ rate }입니다.(기준이 1이기 때문에 결과적으로 ${ if (rate < 1) "손해" else "이익" }라는 의미임)")
    }
}
