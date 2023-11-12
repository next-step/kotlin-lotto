package lotto.view

import lotto.domain.Prize
import lotto.domain.PurchasedLottos
import lotto.domain.WinningStatistic

object LottoOutputView {
    fun printLottoOutput(purchasedLottos: PurchasedLottos, manualLottoCount: Int) {
        println("\n수동으로 ${manualLottoCount}장, 자동으로 ${purchasedLottos.lottos.size - manualLottoCount}개를 구매했습니다.")

        purchasedLottos.lottos
            .forEach { lotto ->
                println(lotto.numbers.map { it.number })
            }

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
        buildString {
            append("${prize.matchedNumberCount}개 일치")
            if (prize === Prize.SECOND) {
                append(", 보너스 볼 일치")
            }
            append(" (${prize.winningAmount}원)- ${matchedNumberCount ?: 0}개")
        }.let(::println)
    }
}
