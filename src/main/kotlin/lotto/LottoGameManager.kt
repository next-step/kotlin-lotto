package lotto

import lotto.business.LottoBookingSystem
import lotto.business.LottoNumber
import lotto.business.LottoTicketExtractor
import lotto.business.Player
import lotto.business.ReceivedAmount
import lotto.business.WinningLottoTicket
import lotto.view.LotteryStatisticsPrinter
import lotto.view.LottoInputHandler
import lotto.view.LottoPurchaseSummaryPrinter

object LottoGameManager {
    fun run() {
        val player = Player(receivedAmount = ReceivedAmount(LottoInputHandler.inputPurchaseAmount()))
        generateTickets(LottoBookingSystem(), player)
        val winningLottoTicket = generateWinningLottoTicket()
        printLotteryStatistics(winningLottoTicket, player)
    }

    private fun generateTickets(
        lottoBookingSystem: LottoBookingSystem,
        player: Player
    ) {
        val manualTicketCount = LottoInputHandler.inputManualTicketCount()
        player.addTickets(lottoBookingSystem.generateManualTickets(manualTicketCount, player.purchasableCount))
        val lottoTickets = lottoBookingSystem.generateMultipleTickets(player.purchasableCount)
        player.addTickets(lottoTickets)
        LottoPurchaseSummaryPrinter.print(manualTicketCount, lottoTickets)
    }

    private fun generateWinningLottoTicket(): WinningLottoTicket {
        val lottoNumbersString = LottoInputHandler.inputWinningNumbers()
        val firstWinningTicket = LottoTicketExtractor.extractLottoTicket(lottoNumbersString)
        val bonusNumber = LottoNumber(LottoInputHandler.inputBonusNumber())
        return WinningLottoTicket(firstWinningTicket, bonusNumber)
    }

    private fun printLotteryStatistics(
        winningLottoTicket: WinningLottoTicket,
        player: Player
    ) {
        val prizeResults = winningLottoTicket.compilePrizeResults(player.tickets)
        val profitRate = prizeResults.calculateProfitRate(player.receivedAmount)
        LotteryStatisticsPrinter.print(prizeResults, profitRate)
    }
}

fun main() {
    LottoGameManager.run()
}
