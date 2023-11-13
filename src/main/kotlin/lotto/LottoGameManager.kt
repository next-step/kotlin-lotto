package lotto

import lotto.business.LottoBookingSystem
import lotto.business.LottoNumber
import lotto.business.LottoTicketExtractor
import lotto.business.ReceivedAmount
import lotto.business.WinningLottoTicket
import lotto.view.LotteryStatisticsPrinter
import lotto.view.LottoInputHandler
import lotto.view.LottoPurchaseSummaryPrinter

object LottoGameManager {
    fun run() {
        val lottoBookingSystem = LottoBookingSystem()
        val receivedAmount = ReceivedAmount(LottoInputHandler.inputPurchaseAmount())
        val lottoTickets = lottoBookingSystem.generateMultipleTickets(receivedAmount.getTicketCount())
        LottoPurchaseSummaryPrinter.print(lottoTickets)
        val lottoNumbersString = LottoInputHandler.inputWinningNumbers()
        val firstWinningTicket = LottoTicketExtractor.extractLottoTicket(lottoNumbersString)
        val bonusNumber = LottoNumber(LottoInputHandler.inputBonusNumber())
        val winningLottoTicket = WinningLottoTicket(firstWinningTicket, bonusNumber)
        val prizeResults = winningLottoTicket.compilePrizeResults(lottoTickets)
        val profitRate = prizeResults.calculateProfitRate(receivedAmount)
        LotteryStatisticsPrinter.print(prizeResults, profitRate)
    }
}

fun main() {
    LottoGameManager.run()
}
