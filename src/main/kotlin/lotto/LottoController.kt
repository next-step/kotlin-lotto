package lotto

import lotto.domain.ProfitAnalyzer
import lotto.domain.lottery.LotteryMachine
import lotto.domain.lottery.WinnerLottery
import lotto.ui.InputView
import lotto.ui.OutputView

object LottoController {
    fun start() {
        val purchaseAmount = InputView.getPurchaseAmount()
        val lotteryTicket = LotteryMachine.issueLotteryTicket(purchaseAmount)

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
}

fun main() {
    LottoController.start()
}
