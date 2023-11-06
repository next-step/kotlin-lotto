package lotto

import lotto.business.LottoBookingSystem
import lotto.business.LottoWinningNumbersExtractor
import lotto.business.ReceivedAmount
import lotto.view.LotteryStatisticsPrinter
import lotto.view.LottoInputHandler
import lotto.view.LottoPurchaseSummaryPrinter

class LottoGameController(
    private val lottoBookingSystem: LottoBookingSystem
) {
    fun run() {
        val receivedAmount = ReceivedAmount(LottoInputHandler.inputPurchaseAmount())
        val lottoTickets = lottoBookingSystem.generateMultipleTickets(receivedAmount.getTicketCount())
        LottoPurchaseSummaryPrinter.print(lottoTickets)
        val winningNumbers = LottoWinningNumbersExtractor.extract(LottoInputHandler.inputWinningNumbers())
        val prizeResults = winningNumbers.compilePrizeResults(lottoTickets)
        val profitRate = prizeResults.calculateProfitRate(receivedAmount)
        LotteryStatisticsPrinter.print(prizeResults, profitRate)
    }
}

fun main() {
    val lottoGameController = LottoGameController(
        lottoBookingSystem = LottoBookingSystem()
    )
    lottoGameController.run()
}
