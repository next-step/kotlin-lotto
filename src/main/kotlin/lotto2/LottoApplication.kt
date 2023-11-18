package lotto2

import lotto2.application.LottoResultAnalyticsApplication
import lotto2.application.LottoShop
import lotto2.domain.LottoNumbers
import lotto2.domain.LottoRanking
import lotto2.ui.ConsoleView

fun main() {
    ConsoleView.Input.printPurchaseAmountPrompt()
    val purchaseAmount = ConsoleView.Input.getPurchaseAmount()

    val lottoTickets = LottoShop.buyLottoTickets(purchaseAmount)
    ConsoleView.Output.printLottoGameResults(lottoTickets)

    ConsoleView.Input.printWinningNumbersPrompt()
    val lastLottoWinningNumbers = LottoNumbers(ConsoleView.Input.getLottoWinningNumbers())

    ConsoleView.Input.printBonusNumbersPrompt()
    val lastLottoBonusNumber = ConsoleView.Input.getLottoBonusNumber()

    val rankingsCount: Map<LottoRanking, Int> =
        lottoTickets.getRankingsCount(lastLottoWinningNumbers, lastLottoBonusNumber)

    val winningStatistics = LottoResultAnalyticsApplication.getWinningStatistics(rankingsCount)
    ConsoleView.Output.printWinningStatistics(winningStatistics)

    val totalInvestment = lottoTickets.size() * LottoShop.LOTTO_PRICE
    val profitRate = LottoResultAnalyticsApplication.getProfitRate(rankingsCount, totalInvestment)
    ConsoleView.Output.printProfitRate(profitRate)
}
