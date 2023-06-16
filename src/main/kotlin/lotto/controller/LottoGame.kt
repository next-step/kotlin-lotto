package lotto.controller

import lotto.domain.Lotto
import lotto.view.InputView
import lotto.view.ResultView

class LottoGame(
    private val inputView: InputView,
    private val resultView: ResultView
) {
    fun start() {
        val input = inputView.readMoney()
        val lotto = Lotto.of(input)
        resultView.printLottoInfo(lotto)
        val winningNumbers = WinningNumbers(inputView.readWinningNumbers())
        val matches = LottoMatcher.matchingLotto(lotto, winningNumbers)
        val matchResult = MatchResult(matches)
        resultView.printStatistics(matchResult, lotto.getSize())
    }
}
