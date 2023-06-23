package lotto.controller

import lotto.domain.LottoNumbers
import lotto.domain.Lottos
import lotto.domain.numberGenerator.FixedLottoLottoNumberGenerator
import lotto.view.InputView
import lotto.view.ResultView

class LottoGame(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val lottoShop: LottoShop
) {
    fun start() {
        val input = inputView.readMoney()
        val manualLottoNumbers = readManualLottoNumbers()
        val lottos = generateLottos(manualLottoNumbers, input)
        displayLottoInfo(lottos, manualLottoNumbers.size)
        val winningNumbers = readWinningNumbers()
        displayMatchResults(lottos, winningNumbers, input)
    }

    private fun readManualLottoNumbers(): List<LottoNumbers> {
        val manualLottoCount = inputView.readManualLottoCount()
        return getManualLottoNumbers(manualLottoCount)
    }

    private fun getManualLottoNumbers(manualLottoCount: Int): List<LottoNumbers> {
        if (manualLottoCount <= 0) {
            return emptyList()
        }

        val manualLottoNumberInput = inputView.readManualLottoNumbers(manualLottoCount)
        return manualLottoNumberInput.map { inputNumbers ->
            val numberGenerator = FixedLottoLottoNumberGenerator(inputNumbers)
            LottoNumbers(numberGenerator.generateNumbers())
        }
    }

    private fun generateLottos(manualLottoNumbers: List<LottoNumbers>, input: Int): Lottos {
        return lottoShop.purchaseLottos(manualLottoNumbers, input)
    }

    private fun displayLottoInfo(lottos: Lottos, manualLottoCount: Int) {
        resultView.printLottoCount(manualLottoCount, lottos.getSize() - manualLottoCount)
        resultView.printLottoInfo(lottos)
    }

    private fun readWinningNumbers(): WinningNumbers {
        val winningNumberGenerator = FixedLottoLottoNumberGenerator(inputView.readWinningNumbers())
        val bonusNumber = inputView.readBonusNumber()
        return WinningNumbers.of(LottoNumbers(winningNumberGenerator.generateNumbers()), bonusNumber)
    }

    private fun displayMatchResults(lottos: Lottos, winningNumbers: WinningNumbers, input: Int) {
        val matchResult = calculateMatchResult(lottos, winningNumbers)
        printResults(matchResult, input)
    }

    private fun calculateMatchResult(lottos: Lottos, winningNumbers: WinningNumbers): MatchResult {
        return winningNumbers.calculateMatchResult(lottos)
    }

    private fun printResults(matchResult: MatchResult, money: Int) {
        resultView.printStatistics(matchResult, money)
    }
}
