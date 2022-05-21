package lotto.ui

import lotto.domain.LottoBundle
import lotto.domain.WinningPlace.FIRST
import lotto.domain.WinningPlace.FOURTH
import lotto.domain.WinningPlace.SECOND
import lotto.domain.WinningPlace.THIRD
import lotto.domain.WinningResult

object OutputView {

    fun showLottoBundle(lottoBundle: LottoBundle) {
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
        println("${FOURTH.requiredMatchingCount}개 일치 (${FOURTH.reward}원) - ${winningResult.fourth}")
        println("${THIRD.requiredMatchingCount}개 일치 (${THIRD.reward}원) - ${winningResult.third}")
        println("${SECOND.requiredMatchingCount}개 일치 (${SECOND.reward}원) - ${winningResult.second}")
        println("${FIRST.requiredMatchingCount}개 일치 (${FIRST.reward}원) - ${winningResult.first}")
    }

    private fun printRateOfReturn(rateOfReturn: Double) {
        println("총 수익률은 ${String.format("%.2f", rateOfReturn)}입니다.")
    }
}
