package lotto.controller

import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers.Companion.toNumbers
import lotto.domain.LottoResult
import lotto.domain.WinningTicket
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun run() {
        val purchaseAmount = inputView.requestPurchaseAmount()
        val manualLottoNumbers = inputView.requestManualPurchaseCountAndNumbers()
        val lottoTickets = LottoMachine().buyTickets(purchaseAmount, manualLottoNumbers)
        outputView.printTickets(lottoTickets)

        val winningNumbers = inputView.requestWinningNumbers().toNumbers()

        val bonusLottoNumber = LottoNumber(inputView.requestBonusBall())
        val lottoResult = WinningTicket(winningNumbers, bonusLottoNumber).getMatchingResult(lottoTickets)
        val profitRate = lottoResult.calculateProfitRate(purchaseAmount)

        printLottoResult(lottoResult, profitRate)
    }

    private fun printLottoResult(lottoResult: LottoResult, profitRate: Double) {
        outputView.printWinningStatistics(lottoResult)
        outputView.printProfitRate(profitRate)
    }
}
