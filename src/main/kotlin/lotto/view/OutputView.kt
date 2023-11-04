package lotto.view

import lotto.domain.Lotto
import lotto.domain.Prize
import lotto.domain.WinningStatistic

object OutputView {
    fun printLottoOutput(purchaseCount: Int, lottos: List<Lotto>) {
        println("${purchaseCount}개를 구매했습니다.")

        lottos.forEach {
            println(it.numbers)
        }
        println()
    }

    fun printWinningStatistic(winningStatistic: WinningStatistic) {
        println("\n당첨 통계")
        println("---------")

        val countPerPrize = winningStatistic.countPerPrize
        printWinningResult(Prize.FOURTH, countPerPrize[Prize.FOURTH])
        printWinningResult(Prize.THIRD, countPerPrize[Prize.THIRD])
        printWinningResult(Prize.SECOND, countPerPrize[Prize.SECOND])
        printWinningResult(Prize.FIRST, countPerPrize[Prize.FIRST])

        println("총 수익률은 ${winningStatistic.profitRate}입니다.")
    }

    private fun printWinningResult(prize: Prize, matchedNumberCount: Int?) {
        println("${prize.matchedNumberCount}개 일치 (${prize.winningAmount}원)- ${matchedNumberCount ?: 0}개")
    }
}
