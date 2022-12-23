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

        val winningResult = WinningResult.of(lottos, winningNumbers)

        printPrizeDetails(winningResult)
        printPrizeReturnRatio(winningResult)
    }

    private fun printPrizeReturnRatio(winningResult: WinningResult) {
        val returnRatio = winningResult.getReturnRatio()
        println("총 수익률은 ${returnRatio}입니다.")
    }

    private fun printPrizeDetails(winningResult: WinningResult) {
        printPrizeCount(winningResult, LottoPrize.FOURTH)
        printPrizeCount(winningResult, LottoPrize.THIRD)
        printPrizeCount(winningResult, LottoPrize.SECOND)
        printPrizeCount(winningResult, LottoPrize.FIRST)
    }

    private fun printPrizeCount(winningResult: WinningResult, target: LottoPrize) {
        val count = winningResult.getCountOf(target)
        println("${target.matchCount}개 일치 (${target.winningAmount}원) - ${count}개")
    }
}
