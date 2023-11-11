package lotto

import lotto.business.LottoBookingSystem
import lotto.business.LottoWinningTicketExtractor
import lotto.business.ReceivedAmount
import lotto.view.LotteryStatisticsPrinter
import lotto.view.LottoInputHandler
import lotto.view.LottoPurchaseSummaryPrinter

object LottoGameManager {
    fun run(lottoBookingSystem: LottoBookingSystem) {
        val receivedAmount = ReceivedAmount(LottoInputHandler.inputPurchaseAmount())
        val lottoTickets = lottoBookingSystem.generateMultipleTickets(receivedAmount.getTicketCount())
        LottoPurchaseSummaryPrinter.print(lottoTickets)
        val winningNumbers = LottoWinningTicketExtractor.extract(LottoInputHandler.inputWinningNumbers())
        val prizeResults = winningNumbers.compilePrizeResults(lottoTickets)
        val profitRate = prizeResults.calculateProfitRate(receivedAmount)
        LotteryStatisticsPrinter.print(prizeResults, profitRate)
    }
}

fun main() {
    val lottoBookingSystem = LottoBookingSystem()
    LottoGameManager.run(lottoBookingSystem)
}
