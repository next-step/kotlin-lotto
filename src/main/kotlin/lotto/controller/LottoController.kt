package lotto.controller

import lotto.domain.LotteryPaper
import lotto.domain.LotteryPaperFactory
import lotto.domain.LottoMachine
import lotto.domain.LottoMatcher
import lotto.domain.LottoNumber
import lotto.domain.RandomLottoNumberGenerationStrategy
import lotto.domain.WinningNumber
import lotto.domain.YieldCalculator
import lotto.dto.LottoMatchResult
import lotto.dto.LottoOrder
import lotto.dto.PurchasedLotteryPapers
import lotto.ui.InputView
import lotto.ui.ResultView

class LottoController(
    val inputView: InputView,
    val resultView: ResultView,
) {

    fun start() {
        val lottoOrder = getLottoOrder()
        val lottoMachine = LottoMachine(LotteryPaperFactory(RandomLottoNumberGenerationStrategy()))
        val purchasedLotteryPapers = purchaseLotto(lottoOrder, lottoMachine)

        printLottoNumbers(purchasedLotteryPapers)

        val winningNumber = generateWinningNumber()
        val lottoMatchResponse = matchLottoNumber(winningNumber, purchasedLotteryPapers)

        printLottoMatch(lottoMatchResponse)
        printYield(lottoOrder.purchasingAmount, lottoMatchResponse)
    }

    private fun getLottoOrder(): LottoOrder {
        val purchasingAmount = inputView.getPurchasingAmount()
        resultView.printNextLine()

        val manualBuyNumber = inputView.getManualBuyAmount()
        resultView.printNextLine()

        val manualBuyLotteryPaper = inputView.getManualBuyNumber(manualBuyNumber)
        resultView.printNextLine()

        return LottoOrder(purchasingAmount, manualBuyLotteryPaper)
    }

    private fun purchaseLotto(lottoOrder: LottoOrder, lottoMachine: LottoMachine): PurchasedLotteryPapers {
        val purchasedLotteryPapers = lottoMachine.buyLottoTicket(lottoOrder)
        resultView.printNumberOfLottoTicket(purchasedLotteryPapers.lotteryPaperList.size)
        return purchasedLotteryPapers
    }

    private fun printLottoNumbers(purchasedLotteryPapers: PurchasedLotteryPapers) {
        resultView.printLottoNumbers(purchasedLotteryPapers)
    }

    private fun generateWinningNumber(): WinningNumber {
        val winningNumberList = LotteryPaper(inputView.getWinningNumber())
        val generatedBonusNumber = generateBonusNumber()
        return WinningNumber(winningNumberList, generatedBonusNumber)
    }

    private fun generateBonusNumber(): LottoNumber {
        return inputView.getBonusNumber()
    }

    private fun matchLottoNumber(
        winningNumber: WinningNumber,
        purchasedLotteryPapers: PurchasedLotteryPapers
    ): LottoMatchResult {
        val lottoMatcher = LottoMatcher()
        return lottoMatcher.countLottoWinner(winningNumber, purchasedLotteryPapers)
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
