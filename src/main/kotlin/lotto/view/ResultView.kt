package lotto.view

import lotto.domain.Lotto
import lotto.domain.WinningStatistics

object ResultView {

    fun printPurchaseLotties(lotties: List<Lotto>) {
        lotties.forEach { println("${it.numbers}") }
        println()
    }

    fun printStatistics(statistics: WinningStatistics) {
        println("당첨통계")
        println("---------")
        statistics.statistics.keys.forEach {
            println("${it.matchCount}개 일치(${it.winningAmount}원) - ${statistics.statistics[it]}개")
        }
        println("총 수익률은 ${statistics.returnRate}입니다.")
    }

}
