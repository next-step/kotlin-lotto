package lotto

import lotto.business.LottoBookingSystem
import lotto.business.LottoNumber
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
        val winningLottoTicket = LottoWinningTicketExtractor.extract(LottoInputHandler.inputWinningNumbers())
        val bonusNumber = LottoNumber(LottoInputHandler.inputBonusNumber())
        winningLottoTicket.validateBonusNumber(bonusNumber)
        val prizeResults = winningLottoTicket.compilePrizeResults(lottoTickets, bonusNumber)
        val profitRate = prizeResults.calculateProfitRate(receivedAmount)
        LotteryStatisticsPrinter.print(prizeResults, profitRate)
    }
}

fun main() {
    val lottoBookingSystem = LottoBookingSystem()
    LottoGameManager.run(lottoBookingSystem)
}
