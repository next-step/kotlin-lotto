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
        resultView.printLottoInfo(lottos)

        val winningNumbers = getWinningNumbers()
        val matchResult = calculateMatchResult(lottos, winningNumbers)
        printResults(matchResult, input)
    }

    private fun getWinningNumbers(): WinningNumbers {
        val winningNumberGenerator = FixedNumberGenerator(inputView.readWinningNumbers())
        return WinningNumbers(LottoNumbers(winningNumberGenerator))
    }

    private fun calculateMatchResult(lottos: Lottos, winningNumbers: WinningNumbers): MatchResult {
        return winningNumbers.calculateMatchResult(lottos)
    }

    private fun printResults(matchResult: MatchResult, money: Int) {
        val earningRate = matchResult.calculateEarningRate(money)
        resultView.printStatistics(matchResult, earningRate)
    }
}
