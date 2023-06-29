package lotto.controller

import lotto.domain.BonusBall
import lotto.domain.LotteryPaper
import lotto.domain.LottoMatcher
import lotto.domain.LottoShop
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
        val generateBonusBall = generateBonusBall(winningNumber)
        val lottoMatchResponse = matchLottoNumber(winningNumber, lottoResponse, generateBonusBall)

        printLottoMatch(lottoMatchResponse)
        printYield(purchasingAmount, lottoMatchResponse)
    }

    private fun purchaseLotto(purchasingAmount: Int): PurchasedLotteryPapers {
        val lottoShop = LottoShop()
        val numberOfLottoTicket = lottoShop.buyLottoTicket(purchasingAmount)
        resultView.printNumberOfLottoTicket(numberOfLottoTicket)
        lottoShop.generateLottoNumbers(numberOfLottoTicket)
        return lottoShop.getPurchasedLotteryPapers()
    }

    private fun printLottoNumbers(purchasedLotteryPapers: PurchasedLotteryPapers) {
        resultView.printLottoNumbers(purchasedLotteryPapers)
    }

    private fun generateWinningNumber(): LotteryPaper {
        val winningNumberList = inputView.getWinningNumber()
        return LotteryPaper(winningNumberList)
    }

    private fun generateBonusBall(winningNumber: LotteryPaper): BonusBall {
        val inputtedNumber = inputView.getBonusBall()
        return BonusBall(inputtedNumber, winningNumber)
    }

    private fun matchLottoNumber(
        winningNumber: LotteryPaper,
        purchasedLotteryPapers: PurchasedLotteryPapers,
        bonusBall: BonusBall
    ): LottoMatchResult {
        val lottoMatcher = LottoMatcher()
        return lottoMatcher.countLottoWinner(winningNumber, purchasedLotteryPapers, bonusBall)
    }

    private fun printLottoMatch(lottoMatchResult: LottoMatchResult) {
        val matchLottoResult = lottoMatchResult.getMatchLottoResult()
        resultView.printMatchLottoNumber(matchLottoResult)
    }

    private fun printYield(capital: Int, lottoMatchResult: LottoMatchResult) {
        val yieldCalculator = YieldCalculator()
        val yield = yieldCalculator.calculateYield(capital, lottoMatchResult)
        resultView.printYield(yield)
    }
}
