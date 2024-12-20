package lotto.view

import Lottos
import lotto.domain.Rank
import lotto.domain.WinningResult

class ResultView {
    fun printPurchaseResult(
        manualCount: Int,
        lottos: Lottos,
    ) {
        val autoCount = lottos.size - manualCount
        println("\n수동으로 ${manualCount}장, 자동으로 ${autoCount}장을 구매했습니다.")
        lottos.lottos.forEach { println(it.numbers.map { num -> num.number }) }
    }

    fun printWinningStatistics(winningResult: WinningResult) {
        Rank.entries
            .filter { it != Rank.NONE }
            .forEach { rank ->
                val count = winningResult.getWinningCount(rank)
                println("${rank.matchCount}개 일치 (${rank.prize}원) - ${count}개")
            }
    }

    fun printProfitRate(profitRate: Double) {
        println("총 수익률은 ${String.format("%.2f", profitRate)} %입니다.")
    }
}
