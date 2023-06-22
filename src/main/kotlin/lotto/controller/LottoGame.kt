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
        val manualLottoCount = inputView.readManualLottoCount()
        val manualLottoNumbers = getManualLottoNumbers(manualLottoCount)

        val lottos = lottoFactory.createLottos(manualLottoNumbers, input)
        resultView.printLottoCount(manualLottoCount, lottos.getSize() - manualLottoCount)
        resultView.printLottoInfo(lottos)
        val winningNumbers = getWinningNumbers()
        val matchResult = calculateMatchResult(lottos, winningNumbers)
        printResults(matchResult, input)
    }

    private fun getManualLottoNumbers(manualLottoCount: Int): List<LottoNumbers> {
        if (manualLottoCount <= 0) {
            return emptyList()
        }

        val manualLottoNumberInput = inputView.readManualLottoNumbers(manualLottoCount)
        return manualLottoNumberInput.map { inputNumbers ->
            val numberGenerator = FixedNumberGenerator(inputNumbers)
            LottoNumbers(numberGenerator.generateNumbers())
        }
    }

    private fun getWinningNumbers(): WinningNumbers {
        val winningNumberGenerator = FixedNumberGenerator(inputView.readWinningNumbers())
        val bonusNumber = inputView.readBonusNumber()
        return WinningNumbers.of(LottoNumbers(winningNumberGenerator.generateNumbers()), bonusNumber)
    }

    private fun calculateMatchResult(lottos: Lottos, winningNumbers: WinningNumbers): MatchResult {
        return winningNumbers.calculateMatchResult(lottos)
    }

    private fun printResults(matchResult: MatchResult, money: Int) {
        resultView.printStatistics(matchResult, money)
    }
}
