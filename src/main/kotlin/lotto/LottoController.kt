package lotto

import lotto.domain.Money
import lotto.domain.ProfitAnalyzer
import lotto.domain.lottery.LotteryMachine
import lotto.domain.lottery.WinnerLottery
import lotto.domain.result.LotteryPurchaseResults
import lotto.ui.InputView
import lotto.ui.OutputView

object LottoController {
    fun start() {
        val purchaseAmount = InputView.getPurchaseAmount()
        val lotteryPurchaseResults = buyTicket(purchaseAmount)
        printResult(lotteryPurchaseResults, purchaseAmount)
    }

    private fun printResult(
        lotteryPurchaseResults: LotteryPurchaseResults,
        purchaseAmount: Money
    ) {
        OutputView.showLotteryTicketInfo(lotteryPurchaseResults)

        val lotteryTicket = lotteryPurchaseResults.getLotteryTicket()

        if (lotteryTicket.isEmpty()) return

        OutputView.showLotteryTicket(lotteryTicket)
        val lastWeekWinnerNumber = InputView.getLastWeekWinnerNumbers()
        val bonusNumber = InputView.getBonusNumber()
        val lastWeekWinnerLottery = WinnerLottery(lastWeekWinnerNumber, bonusNumber)

        val statics = ProfitAnalyzer.getStaticsOnPrizeMoney(lotteryTicket, lastWeekWinnerLottery)
        val profitRate = ProfitAnalyzer.getProfitRate(statics, purchaseAmount)

        OutputView.showStatics(statics)
        OutputView.showProfitRate(profitRate)
    }

    private fun buyTicket(purchaseAmount: Money): LotteryPurchaseResults {
        val manualTicketCount = InputView.getManualTicketCount()
        val manualLotteries = InputView.getManualNumbers(manualTicketCount)
        val manualPurchaseResult = LotteryMachine.issueManualLotteryTicket(purchaseAmount, manualLotteries)

        val remainMoney = manualPurchaseResult.change
        val autoPurchaseResult = LotteryMachine.issueLotteryTicket(remainMoney)
        return LotteryPurchaseResults(listOf(manualPurchaseResult, autoPurchaseResult))
    }
}

fun main() {
    LottoController.start()
}
