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
import lotto.dto.LotteryPapers
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

        val manualBuyNumber = inputView.getManualBuyAmount()

        val manualBuyLotteryPaper = inputView.getManualBuyNumber(manualBuyNumber)

        return LottoOrder(purchasingAmount, manualBuyLotteryPaper)
    }

    private fun purchaseLotto(lottoOrder: LottoOrder, lottoMachine: LottoMachine): LotteryPapers {
        val purchasedLotteryPapers = lottoMachine.buyLottoTicket(lottoOrder)
        resultView.printNumberOfLottoTicket(purchasedLotteryPapers.lotteryPaperList.size)
        return purchasedLotteryPapers
    }

    private fun printLottoNumbers(lotteryPapers: LotteryPapers) {
        resultView.printLottoNumbers(lotteryPapers)
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
        lotteryPapers: LotteryPapers
    ): LottoMatchResult {
        val lottoMatcher = LottoMatcher()
        return lottoMatcher.countLottoWinner(winningNumber, lotteryPapers)
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
