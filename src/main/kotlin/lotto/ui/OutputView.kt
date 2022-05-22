package lotto.ui

import lotto.domain.LottoBundle
import lotto.domain.WinningPlace.BLANK
import lotto.domain.WinningPlace.values
import lotto.domain.WinningResult

object OutputView {

    fun showPurchasedLottoBundle(lottoBundle: LottoBundle) {
        println("${lottoBundle.size}개를 구매했습니다")
        println(lottoBundle)
    }

    fun showWinningResult(winningResult: WinningResult) {
        println("당첨 통계")
        println("-------------------")
        printWinning(winningResult)
        printRateOfReturn(winningResult.rateOfReturn)
    }

    private fun printWinning(winningResult: WinningResult) {
        values().filter { it != BLANK }
            .sortedBy { it.reward }
            .forEach {
                println("${it.requiredMatchingCount}개 일치 (${it.reward}원) - ${winningResult[it]}")
            }
    }

    private fun printRateOfReturn(rateOfReturn: Double) {
        println("총 수익률은 ${String.format("%.2f", rateOfReturn)}입니다.")
    }
}
