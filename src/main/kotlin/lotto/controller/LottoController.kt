package lotto.controller

import lotto.data.LotteryTicketNumbers
import lotto.domain.LotteryTickets
import lotto.domain.ProfitCalculator
import lotto.ui.CashInputView
import lotto.ui.LottoNumView
import lotto.ui.StatisticsView
import lotto.ui.WinningInputView

object LottoController {
    fun run() {
        val inputPrice = CashInputView.askPurchasePrice()
        CashInputView.printTicketNumber(inputPrice)

        val lotteryTickets = LotteryTickets(inputPrice)

        LottoNumView.printLottoNumbers(LotteryTicketNumbers.from(lotteryTickets))
        val winningNumbers = WinningInputView.askWinningNumbers()

        val lotteryStatistics = lotteryTickets.createWinningStatics(winningNumbers)
        val profitRatio = ProfitCalculator.calculateRatio(inputPrice, lotteryStatistics)

        StatisticsView.printLotteryStatistics(lotteryStatistics)
        StatisticsView.printProfitRatio(profitRatio)
    }
}
