package lotto.io

import lotto.domain.Lotto

object ResultView {
    val winningAmounts = longArrayOf(5000L, 50000L, 1500000L, 2000000000L)
    fun printLottos(lottos: List<Lotto>) {
        println("${lottos.size}개 구매했습니다")
        lottos.forEach { lotto -> println(lotto) }
    }

    fun printResult(result: Map<Int, Int>, purchaseAmount: Int) {
        var total = 0L
        for (i in 3..6) {
            println("${i}개 일치 (${winningAmounts[i - 3]}원)- ${result.getOrDefault(i, 0)}")
            total += winningAmounts[i - 3] * result.getOrDefault(i, 0)
        }
        println("총 수익률은 ${total.toDouble() / purchaseAmount}입니다")
    }
}
