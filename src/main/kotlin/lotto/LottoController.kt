package lotto

import lotto.domain.LotteryMachine
import lotto.domain.ProfitAnalyzer
import lotto.ui.InputView
import lotto.ui.OutputView

object LottoController {
    fun start() {
        val purchaseAmount = InputView.getPurchaseAmount()
        val lotteryTicket = LotteryMachine.issueLotteryTicket(purchaseAmount)

        if (lotteryTicket.isEmpty()) return

        OutputView.showLotteryTicket(lotteryTicket)
        val lastWeekWinnerLottery = InputView.getLastWeekWinnerNumbers()

        val statics = ProfitAnalyzer.getStaticsOnPrizeMoney(lotteryTicket, lastWeekWinnerLottery)
        val profitRate = ProfitAnalyzer.getProfitRate(statics, purchaseAmount)

        OutputView.showStatics(statics)
        OutputView.showProfitRate(profitRate)
    }
}

fun main() {
    LottoController.start()
}
