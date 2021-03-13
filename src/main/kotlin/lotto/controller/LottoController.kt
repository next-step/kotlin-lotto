package lotto.controller

import lotto.data.BuyingData
import lotto.domain.Buyer
import lotto.domain.ProfitCalculator
import lotto.ui.*

object LottoController {
    fun run() {
        val buyer = Buyer()

        val inputPrice = CashInputView.askPurchasePrice()
        val manualNumbersList = ManualNumberInputView.askManualInput()
        val buyingData = BuyingData(inputPrice, manualNumbersList)

        val lotteryTickets = buyer.buyLotteryTickets(buyingData)

        LottoNumView.printTicketNumber(buyingData)
        LottoNumView.printTickets(lotteryTickets)

        val winningNumbers = WinningInputView.askWinningNumbers()
        val lotteryStatistics = buyer.createWinningStatics(winningNumbers)
        val profitRatio = ProfitCalculator.calculateRatio(inputPrice, lotteryStatistics)

        StatisticsView.printLotteryStatistics(lotteryStatistics)
        StatisticsView.printProfitRatio(profitRatio)
    }
}
