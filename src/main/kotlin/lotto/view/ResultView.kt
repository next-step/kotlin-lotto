package lotto.view

import lotto.domain.Lotto
import lotto.domain.WinningCategory

object ResultView {
    fun printPurchaseInfo(tickets: List<Lotto>) {
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach { println(it.getNumbers()) }
    }

    fun printStatistics(
        statistics: Map<WinningCategory, Int>,
        totalPrize: Int,
        purchaseAmount: Int,
    ) {
        println("당첨 통계")
        println("---------")
        statistics.forEach { (category, count) ->
            println("${category.matchCount}개 일치 (${category.prize}원)- ${count}개")
        }
        val profitRate = if (purchaseAmount > 0) totalPrize.toDouble() / purchaseAmount else 0.0
        println("총 수익률: ${"%.2f".format(profitRate)}")
    }
}
