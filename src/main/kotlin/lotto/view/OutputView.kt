package lotto.view

import lotto.model.Lotto
import lotto.model.LottoPrize
import lotto.model.Lottos
import lotto.model.WinningNumbers
import lotto.model.WinningResult
import java.util.Comparator.comparingInt

object OutputView {
    fun printDetails(lottos: Lottos) {
        println("${lottos.size}개를 구매했습니다.")
        printLottos(lottos)
        println()
    }

    private fun printLottos(lottos: Lottos) {
        lottos.forEach { printLotto(it) }
    }

    private fun printLotto(lotto: Lotto) {
        val numberValueList = lotto.sortedWith(comparingInt { it.value }).map { it.value }
        println(numberValueList)
    }

    fun printResult(lottos: Lottos, winningNumbers: WinningNumbers) {
        println()
        println("당첨 통계")
        println("---------")

        printPrizeDetails(lottos, winningNumbers)
        printReturnRatio(lottos, winningNumbers)
    }

    private fun printReturnRatio(
        lottos: Lottos,
        winningNumbers: WinningNumbers
    ) {
        val returnRatio = WinningResult(lottos, winningNumbers).getReturnRatio()
        println("총 수익률은 ${returnRatio}입니다.")
    }

    private fun printPrizeDetails(
        lottos: Lottos,
        winningNumbers: WinningNumbers
    ) {
        val lottoPrizes = lottos.prizesFor(winningNumbers)

        printPrizeCount(lottoPrizes, LottoPrize.FOURTH)
        printPrizeCount(lottoPrizes, LottoPrize.THIRD)
        printPrizeCount(lottoPrizes, LottoPrize.SECOND)
        printPrizeCount(lottoPrizes, LottoPrize.FIRST)
    }

    private fun printPrizeCount(lottoPrizes: List<LottoPrize>, target: LottoPrize) {
        val count = lottoPrizes.count { it == target }
        println("${target.matchCount}개 일치 (${target.prize}원) - ${count}개")
    }
}
