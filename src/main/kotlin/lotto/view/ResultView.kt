package lotto.view

import WinningResult
import lotto.Lotto
import lotto.Rank

class ResultView {
    fun printPurchaseResult(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { println(it.sortedList()) }
    }

    fun printWinningStatistics(winningResult: WinningResult) {
        Rank.entries
            .filter { it != Rank.NONE }
            .forEach { rank ->
                val count = winningResult.getWinningCount(rank.matchCount)
                println("${rank.matchCount}개 일치 (${rank.prize}원) - ${count}개")
            }
    }

    fun printProfitRate(profitRate: Double) {
        println("총 수익률은 ${String.format("%.2f", profitRate)} %입니다.")
    }
}
