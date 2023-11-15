package lotto

import lotto.business.LottoBookingSystem
import lotto.business.LottoNumber
import lotto.business.LottoTicket
import lotto.business.LottoTicketExtractor
import lotto.business.Player
import lotto.business.ReceivedAmount
import lotto.business.WinningLottoTicket
import lotto.view.LotteryStatisticsPrinter
import lotto.view.LottoInputHandler
import lotto.view.LottoPurchaseSummaryPrinter

object LottoGameManager {
    fun run() {
        val lottoBookingSystem = LottoBookingSystem()
        val (receivedAmount, player) = receiveAmount()
        val lottoTickets = generateTickets(lottoBookingSystem, player)
        val winningLottoTicket = generateWinningLottoTicket()
        printLotteryStatistics(winningLottoTicket, lottoTickets, receivedAmount)
    }

    private fun receiveAmount(): Pair<ReceivedAmount, Player> {
        val receivedAmount = ReceivedAmount(LottoInputHandler.inputPurchaseAmount())
        val player = Player(purchasedCount = receivedAmount.getTicketCount())
        return Pair(receivedAmount, player)
    }

    private fun generateTickets(
        lottoBookingSystem: LottoBookingSystem,
        player: Player
    ): List<LottoTicket> {
        val manualTicketCount = LottoInputHandler.inputManualTicketCount()
        val manualTickets = lottoBookingSystem.generateManualTickets(manualTicketCount, player)
        player.addTickets(manualTickets)
        val lottoTickets = lottoBookingSystem.generateMultipleTickets(player)
        LottoPurchaseSummaryPrinter.print(manualTicketCount, lottoTickets)
        return lottoTickets
    }

    private fun generateWinningLottoTicket(): WinningLottoTicket {
        val lottoNumbersString = LottoInputHandler.inputWinningNumbers()
        val firstWinningTicket = LottoTicketExtractor.extractLottoTicket(lottoNumbersString)
        val bonusNumber = LottoNumber(LottoInputHandler.inputBonusNumber())
        return WinningLottoTicket(firstWinningTicket, bonusNumber)
    }

    private fun printLotteryStatistics(
        winningLottoTicket: WinningLottoTicket,
        lottoTickets: List<LottoTicket>,
        receivedAmount: ReceivedAmount
    ) {
        val prizeResults = winningLottoTicket.compilePrizeResults(lottoTickets)
        val profitRate = prizeResults.calculateProfitRate(receivedAmount)
        LotteryStatisticsPrinter.print(prizeResults, profitRate)
    }
}

fun main() {
    LottoGameManager.run()
}
