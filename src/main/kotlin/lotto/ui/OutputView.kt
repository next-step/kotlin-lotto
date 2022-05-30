package lotto.ui

import lotto.domain.LottoBundle
import lotto.domain.WinningPlace
import lotto.domain.WinningPlace.BLANK
import lotto.domain.WinningPlace.SECOND
import lotto.domain.WinningPlace.values
import lotto.domain.WinningResult

object OutputView {

    fun showPurchasedLottoBundle(numberOfManualLotto: Int, lottoBundle: LottoBundle) {
        println("수동으로 ${numberOfManualLotto}장, 자동으로 ${lottoBundle.size - numberOfManualLotto}장을 구매했습니다")
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
                println("${it.requiredMatchingCount}개 일치${if (isSecondPlace(it)) ", 보너스 볼 일치" else ""}(${it.reward}원) - ${winningResult[it]}개")
            }
    }

    private fun isSecondPlace(winningPlace: WinningPlace): Boolean {
        return winningPlace == SECOND
    }

    private fun printRateOfReturn(rateOfReturn: Double) {
        println("총 수익률은 ${String.format("%.2f", rateOfReturn)}입니다.")
    }
}
