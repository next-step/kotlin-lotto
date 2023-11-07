package lotto.view

import lotto.domain.Prize
import lotto.domain.PurchasedLottos
import lotto.domain.WinningStatistic

object LottoOutputView {
    fun printLottoOutput(purchasedLottos: PurchasedLottos) {
        println("${purchasedLottos.lottos.size}개를 구매했습니다.")

        purchasedLottos.lottos
            .forEach { println(it.numbers) }

        println()
    }

    fun printWinningStatistic(winningStatistic: WinningStatistic) {
        println("\n당첨 통계")
        println("---------")

        val countPerPrize = winningStatistic.countPerPrize

        Prize.values()
            .reversed()
            .forEach { printWinningResult(it, countPerPrize[it]) }

        println("총 수익률은 ${winningStatistic.profitRate}입니다.")
    }

    private fun printWinningResult(prize: Prize, matchedNumberCount: Int?) {
        println("${prize.matchedNumberCount}개 일치 (${prize.winningAmount}원)- ${matchedNumberCount ?: 0}개")
    }
}
