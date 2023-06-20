package lotto.controller

import lotto.domain.LottoNumbers
import lotto.domain.Lottos
import lotto.domain.numberGenerator.FixedNumberGenerator
import lotto.view.InputView
import lotto.view.ResultView

class LottoGame(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val lottoFactory: LottoFactory
) {
    fun start() {
        val input = inputView.readMoney()
        val lottos = lottoFactory.createLottos(input)

        val bonusNumber = inputView.readBonusNumber()
        resultView.printLottoInfo(lottos)
        val winningNumbers = getWinningNumbers(bonusNumber)
        val matchResult = calculateMatchResult(lottos, winningNumbers)
        printResults(matchResult, input)
    }

    private fun getWinningNumbers(bonusNumber: Int): WinningNumbers {
        val winningNumberGenerator = FixedNumberGenerator(inputView.readWinningNumbers())
        return WinningNumbers.of(LottoNumbers(winningNumberGenerator), bonusNumber)
    }

    private fun calculateMatchResult(lottos: Lottos, winningNumbers: WinningNumbers): MatchResult {
        return winningNumbers.calculateMatchResult(lottos)
    }

    private fun printResults(matchResult: MatchResult, money: Int) {
        resultView.printStatistics(matchResult, money)
    }
}
