package lotto.controller

import lotto.domain.LottoNumbers
import lotto.domain.Lottos
import lotto.domain.numberGenerator.FixedLottoNumberGenerator
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
        val totalLottoCount = input / LottoFactory.PER_LOTTO_PRICE
        val randomLottoCount = totalLottoCount - manualLottoNumbers.size
        val ticket = LottoTicket(manualLottoNumbers, randomLottoCount)

        val lottos = lottoShop.purchaseLottos(ticket)
        displayLottoInfo(lottos, manualLottoNumbers.size)
        val winningNumbers = readWinningNumbers()
        displayMatchResults(lottos, winningNumbers, input)
    }

    private fun readManualLottoNumbers(): List<List<Int>> {
        val manualLottoCount = inputView.readManualLottoCount()
        return inputView.readManualLottoNumbers(manualLottoCount)
    }

    private fun displayLottoInfo(lottos: Lottos, manualLottoCount: Int) {
        resultView.printLottoCount(manualLottoCount, lottos.getSize() - manualLottoCount)
        resultView.printLottoInfo(lottos)
    }

    private fun readWinningNumbers(): WinningNumbers {
        val winningNumberGenerator = FixedLottoNumberGenerator(inputView.readWinningNumbers())
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
