package lotto.controller

import lotto.domain.LottoMachine
import lotto.domain.LottoMatcher
import lotto.domain.LottoResult
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun run() {
        val purchaseAmount = inputView.requestPurchaseAmount()
        val lottoTickets = LottoMachine().buyTickets(purchaseAmount)
        outputView.printTickets(lottoTickets)

        val winningNumbers = inputView.requestWinningNumbers()
        val lottoResult = LottoMatcher(winningNumbers).getMatchingResult(lottoTickets)

        val profitRate = lottoResult.calculateProfitRate(purchaseAmount)
        printLottoResult(lottoResult, profitRate)
    }

    private fun printLottoResult(lottoResult: LottoResult, profitRate: Double) {
        outputView.printWinningStatistics(lottoResult)
        outputView.printProfitRate(profitRate)
    }
}