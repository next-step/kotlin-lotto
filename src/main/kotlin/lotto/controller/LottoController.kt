package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoMatcher
import lotto.domain.PrizeLevel
import lotto.domain.WinningNumber
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
        val matchLottoNumber = matchLottoNumber(winningNumber, lottoResponse)

        printLottoMatch(matchLottoNumber)
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

    private fun matchLottoNumber(winningNumber: WinningNumber, lottoResponse: LottoResponse): Map<PrizeLevel, Int> {
        val lottoMatcher = LottoMatcher()
        return lottoMatcher.countLottoWinner(winningNumber, lottoResponse)
    }

    private fun printLottoMatch(matchLottoNumber: Map<PrizeLevel, Int>) {
        resultView.printMatchLottoNumber(matchLottoNumber)
    }
}
