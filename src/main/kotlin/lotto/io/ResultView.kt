package lotto.io

import lotto.domain.Lotto

object ResultView {
    private const val LOTTO_COUNT_MESSAGE = "%d개 구매했습니다"
    private const val WINNING_PRIZE_MESSAGE = "%d개 일치 (%d원)- %d개"
    private const val TOTAL_PRIZE_MESSAGE = "총 수익률은 %.2f입니다"
    private const val RESULT_MESSAGE = "\n당첨 통계\n---------"

    fun printLottos(lottos: List<Lotto>) {
        println(LOTTO_COUNT_MESSAGE.format(lottos.size))
        lottos.forEach { lotto -> println(lotto) }
        println()
    }

    fun printResult(result: Map<Lotto.WinningPrize, Int>, purchaseAmount: Int) {
        println(RESULT_MESSAGE)
        var total = 0L
        for (winningAmount in Lotto.WinningPrize.values()) {
            val count = result.getOrDefault(winningAmount, 0)
            total += winningAmount.prize * count
            println(WINNING_PRIZE_MESSAGE.format(winningAmount.count, winningAmount.prize, count))
        }

        println(TOTAL_PRIZE_MESSAGE.format(total.toDouble() / purchaseAmount))
    }
}
