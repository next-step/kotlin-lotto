package lotto

import lotto.business.LottoBookingSystem
import lotto.business.LottoNumber
import lotto.business.LottoTicketCounter
import lotto.business.LottoTicketGenerator
import lotto.business.Player
import lotto.business.ReceivedAmount
import lotto.business.WinningLottoTicket
import lotto.view.LotteryStatisticsPrinter
import lotto.view.LottoInputHandler
import lotto.view.LottoPurchaseSummaryPrinter

object LottoGameManager {
    fun run() {
        val lottoTicketCounter = LottoTicketCounter(ReceivedAmount(LottoInputHandler.inputPurchaseAmount()))
        val player = Player()
        generateTickets(LottoBookingSystem(), player, lottoTicketCounter)
        val winningLottoTicket = generateWinningLottoTicket()
        printLotteryStatistics(winningLottoTicket, player, lottoTicketCounter)
    }

    private fun generateTickets(
        lottoBookingSystem: LottoBookingSystem,
        player: Player,
        lottoTicketCounter: LottoTicketCounter
    ) {
        generateManualTickets(lottoTicketCounter, player, lottoBookingSystem)
        generateAutoTickets(lottoBookingSystem, lottoTicketCounter, player)
    }

    private fun generateManualTickets(
        lottoTicketCounter: LottoTicketCounter,
        player: Player,
        lottoBookingSystem: LottoBookingSystem
    ) {
        val manualTicketCount = LottoInputHandler.inputManualTicketCount()
        val manualNumbers = LottoInputHandler.inputManualNumbers(manualTicketCount)
        player.addTickets(lottoBookingSystem.generateManualTickets(manualNumbers))
        lottoTicketCounter.decreasePurchasableCount(manualTicketCount)
    }

    private fun generateAutoTickets(
        lottoBookingSystem: LottoBookingSystem,
        lottoTicketCounter: LottoTicketCounter,
        player: Player
    ) {
        val lottoTickets = lottoBookingSystem.generateMultipleTickets(lottoTicketCounter.purchasableCount)
        player.addTickets(lottoTickets)
        val manualTicketCount = lottoTicketCounter.usedTicketCount
        lottoTicketCounter.decreasePurchasableCount(lottoTicketCounter.purchasableCount)
        LottoPurchaseSummaryPrinter.print(manualTicketCount, player.tickets)
    }

    private fun generateWinningLottoTicket(): WinningLottoTicket {
        val lottoNumbers = LottoInputHandler.inputWinningNumbers()
        val firstWinningTicket = LottoTicketGenerator.generate(lottoNumbers)
        val bonusNumber = LottoNumber(LottoInputHandler.inputBonusNumber())
        return WinningLottoTicket(firstWinningTicket, bonusNumber)
    }

    private fun printLotteryStatistics(
        winningLottoTicket: WinningLottoTicket,
        player: Player,
        lottoTicketCounter: LottoTicketCounter
    ) {
        val prizeResults = winningLottoTicket.compilePrizeResults(player.tickets)
        val profitRate = prizeResults.calculateProfitRate(lottoTicketCounter.receivedAmount)
        LotteryStatisticsPrinter.print(prizeResults, profitRate)
    }
}

fun main() {
    LottoGameManager.run()
}
