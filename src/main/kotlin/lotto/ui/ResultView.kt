package lotto.ui

import lotto.domain.dto.WinningResults

object ResultView {
    fun show(winningResults: WinningResults, money: Int) {
        winningResults.printResult()
        winningResults.printRateOfReturn(money)
    }
}
