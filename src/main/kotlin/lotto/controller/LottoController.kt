package lotto.controller

import lotto.domain.Buyer
import lotto.domain.ProfitCalculator
import lotto.ui.CashInputView
import lotto.ui.LottoNumView
import lotto.ui.StatisticsView
import lotto.ui.WinningInputView

object LottoController {
    fun run() {
        val buyer = Buyer()

        val inputPrice = CashInputView.askPurchasePrice()
        val lotteryTickets = buyer.buyLotteryTickets(inputPrice)

        CashInputView.printTicketNumber(lotteryTickets.size)
        LottoNumView.printTickets(lotteryTickets)

        val winningNumbers = WinningInputView.askWinningNumbers()
        val lotteryStatistics = buyer.createWinningStatics(winningNumbers)
        val profitRatio = ProfitCalculator.calculateRatio(inputPrice, lotteryStatistics)

        StatisticsView.printLotteryStatistics(lotteryStatistics)
        StatisticsView.printProfitRatio(profitRatio)
    }
}
