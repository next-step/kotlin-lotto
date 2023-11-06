package lotto

import lotto.business.LottoTicketManager
import lotto.business.LottoWinningNumbersExtractor
import lotto.business.ReceivedAmount
import lotto.view.LotteryStatisticsPrinter
import lotto.view.LottoInputHandler
import lotto.view.LottoPurchaseSummaryPrinter

class LottoGameController(
    private val lottoTicketManager: LottoTicketManager
) {
    fun run() {
        val receivedAmount = ReceivedAmount(LottoInputHandler.inputPurchaseAmount())
        val lottoTickets = lottoTicketManager.buyLotto(receivedAmount)
        LottoPurchaseSummaryPrinter.print(lottoTickets)
        val winningNumbers = LottoWinningNumbersExtractor.extract(LottoInputHandler.inputWinningNumbers())
        val prizeResults = winningNumbers.compilePrizeResults(lottoTickets)
        val profitRate = prizeResults.calculateProfitRate(receivedAmount)
        LotteryStatisticsPrinter.print(prizeResults, profitRate)
    }
}

fun main() {
    val lottoGameController = LottoGameController(
        lottoTicketManager = LottoTicketManager()
    )
    lottoGameController.run()
}
