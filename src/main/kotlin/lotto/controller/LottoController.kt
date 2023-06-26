package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoMatcher
import lotto.domain.WinningNumber
import lotto.domain.YieldCalculator
import lotto.dto.PurchasedLotteryPapers
import lotto.dto.LottoResponse
import lotto.ui.InputView
import lotto.ui.ResultView

class LottoController(
    val inputView: InputView,
    val resultView: ResultView,
) {

    fun start() {
        val purchasingAmount = inputView.getPurchasingAmount()
        val lottoResponse = purchaseLotto(purchasingAmount)

        printLottoNumbers(lottoResponse)

        val winningNumber = generateWinningNumber()
        val lottoMatchResponse = matchLottoNumber(winningNumber, lottoResponse)

        printLottoMatch(lottoMatchResponse)
        printYield(purchasingAmount, lottoMatchResponse)
    }

    private fun purchaseLotto(purchasingAmount: Int): LottoResponse {
        val lotto = Lotto()
        val numberOfLottoTicket = lotto.buyLottoTicket(purchasingAmount)
        resultView.printNumberOfLottoTicket(numberOfLottoTicket)
        lotto.generateLottoNumbers(numberOfLottoTicket)
        return lotto.lotteryPapers.getLottoResponse()
    }

    private fun printLottoNumbers(lottoResponse: LottoResponse) {
        resultView.printLottoNumbers(lottoResponse)
    }

    private fun generateWinningNumber(): WinningNumber {
        val winningNumberList = inputView.getWinningNumber()
        val winningNumber = WinningNumber()
        winningNumber.generateWinningNumber(winningNumberList)
        return winningNumber
    }

    private fun matchLottoNumber(winningNumber: WinningNumber, lottoResponse: LottoResponse): PurchasedLotteryPapers {
        val lottoMatcher = LottoMatcher()
        return lottoMatcher.countLottoWinner(winningNumber, lottoResponse)
    }

    private fun printLottoMatch(purchasedLotteryPapers: PurchasedLotteryPapers) {
        val matchLottoResult = purchasedLotteryPapers.matchLottoResult
        resultView.printMatchLottoNumber(matchLottoResult)
    }

    private fun printYield(capital: Int, purchasedLotteryPapers: PurchasedLotteryPapers) {
        val yieldCalculator = YieldCalculator()
        val yield = yieldCalculator.calulateYield(capital, purchasedLotteryPapers)
        resultView.printYield(yield)
    }
}
