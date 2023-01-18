package lotto.view

import lotto.model.Lotto
import lotto.model.LottoPrize
import lotto.model.Lottos
import lotto.model.WinningResult
import java.util.Comparator.comparingInt

object OutputView {
    fun printDetails(lottos: Lottos, manualCount: Int) {
        println()
        println("수동으로 ${manualCount}장, 자동으로 ${lottos.size - manualCount}개를 구매했습니다.")
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

    fun printResult(winningResult: WinningResult) {
        println()
        println("당첨 통계")
        println("---------")

        printPrizeDetails(winningResult)
        printPrizeReturnRatio(winningResult)
    }

    private fun printPrizeReturnRatio(winningResult: WinningResult) {
        val returnRatio = winningResult.getReturnRatio()
        println("총 수익률은 ${returnRatio}입니다.")
    }

    private fun printPrizeDetails(winningResult: WinningResult) {
        LottoPrize.values()
            .sortedDescending()
            .filterNot { it == LottoPrize.NONE }
            .forEach { printPrizeCount(winningResult, it) }
    }

    private fun printPrizeCount(winningResult: WinningResult, target: LottoPrize) {
        val count = winningResult.getCountOf(target)
        print("${target.matchCount}개 일치")
        if (target == LottoPrize.SECOND) {
            print(", 보너스 볼 일치")
        }
        println("(${target.winningAmount}원) - ${count}개")
    }
}
