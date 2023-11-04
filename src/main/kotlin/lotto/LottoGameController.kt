package lotto

import lotto.business.LotteryStatisticsGenerator
import lotto.business.LottoTicketGenerator
import lotto.business.LottoTicketManager
import lotto.business.LottoWinningNumbersExtractor
import lotto.business.ReceivedAmount
import lotto.business.TicketBookingSystem
import lotto.view.LotteryStatisticsPrinter
import lotto.view.LottoInputHandler

class LottoGameController(
    private val lottoWinningNumbersExtractor: LottoWinningNumbersExtractor,
    private val lottoTicketManager: LottoTicketManager,
    private val lotteryStatisticsGenerator: LotteryStatisticsGenerator
) {
    fun run() {
        val receivedAmount = ReceivedAmount(LottoInputHandler.inputPurchaseAmount())
        lottoTicketManager.buyLotto(receivedAmount)
        val winningNumbers = lottoWinningNumbersExtractor.extract(LottoInputHandler.inputWinningNumbers())
        val prizeResults = lottoTicketManager.compilePrizeResults(winningNumbers)
        val lotteryStatistics = lotteryStatisticsGenerator.generate(prizeResults)
        val profitRate = lotteryStatisticsGenerator.calculateProfitRate(receivedAmount, prizeResults)
        LotteryStatisticsPrinter.print(lotteryStatistics, profitRate)
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
