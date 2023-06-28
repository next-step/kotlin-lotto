package lotto.controller

import lotto.domain.LotteryPaper
import lotto.domain.Lotto
import lotto.domain.LottoMatcher
import lotto.domain.YieldCalculator
import lotto.dto.LottoMatchResult
import lotto.dto.PurchasedLotteryPapers
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

    private fun purchaseLotto(purchasingAmount: Int): PurchasedLotteryPapers {
        val lotto = Lotto()
        val numberOfLottoTicket = lotto.buyLottoTicket(purchasingAmount)
        resultView.printNumberOfLottoTicket(numberOfLottoTicket)
        lotto.generateLottoNumbers(numberOfLottoTicket)
        return lotto.lotteryPapers.getPurchasedLotteryPapers()
    }

    private fun printLottoNumbers(purchasedLotteryPapers: PurchasedLotteryPapers) {
        resultView.printLottoNumbers(purchasedLotteryPapers)
    }

    private fun generateWinningNumber(): LotteryPaper {
        val winningNumberList = inputView.getWinningNumber()
        return LotteryPaper(winningNumberList)
    }

    private fun matchLottoNumber(
        winningNumber: LotteryPaper,
        purchasedLotteryPapers: PurchasedLotteryPapers
    ): LottoMatchResult {
        val lottoMatcher = LottoMatcher()
        return lottoMatcher.countLottoWinner(winningNumber, purchasedLotteryPapers)
    }

    private fun printLottoMatch(lottoMatchResult: LottoMatchResult) {
        val matchLottoResult = lottoMatchResult.matchLottoResult
        resultView.printMatchLottoNumber(matchLottoResult)
    }

    private fun printYield(capital: Int, lottoMatchResult: LottoMatchResult) {
        val yieldCalculator = YieldCalculator()
        val yield = yieldCalculator.calulateYield(capital, lottoMatchResult)
        resultView.printYield(yield)
    }
}
