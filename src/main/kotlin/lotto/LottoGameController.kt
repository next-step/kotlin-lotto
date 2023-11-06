package lotto

import lotto.business.LotteryStatisticsGenerator
import lotto.business.LottoTicketGenerator
import lotto.business.LottoTicketManager
import lotto.business.LottoWinningNumbersExtractor
import lotto.business.ReceivedAmount
import lotto.business.TicketBookingSystem
import lotto.view.LotteryStatisticsPrinter
import lotto.view.LottoInputHandler
import lotto.view.LottoPurchaseSummaryPrinter

class LottoGameController(
    private val lottoWinningNumbersExtractor: LottoWinningNumbersExtractor,
    private val lottoTicketManager: LottoTicketManager,
    private val lotteryStatisticsGenerator: LotteryStatisticsGenerator
) {
    fun run() {
        val receivedAmount = ReceivedAmount(LottoInputHandler.inputPurchaseAmount())
        val lottoTickets = lottoTicketManager.buyLotto(receivedAmount)
        LottoPurchaseSummaryPrinter.print(lottoTickets)
        val winningNumbers = lottoWinningNumbersExtractor.extract(LottoInputHandler.inputWinningNumbers())
        val prizeResults = lottoTicketManager.compilePrizeResults(winningNumbers)
        val profitRate = lotteryStatisticsGenerator.calculateProfitRate(receivedAmount, prizeResults)
        LotteryStatisticsPrinter.print(prizeResults, profitRate)
    }
}

fun main() {
    val lottoGameController = LottoGameController(
        lottoWinningNumbersExtractor = LottoWinningNumbersExtractor(),
        lottoTicketManager = LottoTicketManager(ticketBookingSystem = TicketBookingSystem(LottoTicketGenerator())),
        lotteryStatisticsGenerator = LotteryStatisticsGenerator()
    )
    lottoGameController.run()
}
