package lotto.app

import lotto.domain.LottoGame
import lotto.domain.LottoStatistics
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val tickets = LottoGame.generateTickets(purchaseAmount)
    ResultView.printPurchaseInfo(tickets)

    val winningNumbers = InputView.getWinningNumbers()
    val statistics = LottoStatistics.calculate(tickets, winningNumbers)
    val totalPrize = LottoStatistics.calculateTotalPrize(statistics)
    val profitRate = LottoStatistics.calculateProfit(totalPrize, purchaseAmount)

    ResultView.printStatistics(statistics, profitRate)
}
