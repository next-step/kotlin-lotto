package lotto

import lotto.business.LottoBookingSystem
import lotto.business.LottoNumber
import lotto.business.LottoTicketGenerator
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
        require(player.purchasableCount >= manualTicketCount) { throw IllegalArgumentException("더 이상 로또를 구매할 수 없습니다.") }
        val manualNumbers = LottoInputHandler.inputManualNumbers(manualTicketCount)
        player.addTickets(lottoBookingSystem.generateManualTickets(manualNumbers))
        val lottoTickets = lottoBookingSystem.generateMultipleTickets(player.purchasableCount)
        player.addTickets(lottoTickets)
        LottoPurchaseSummaryPrinter.print(manualTicketCount, lottoTickets)
    }

    private fun generateWinningLottoTicket(): WinningLottoTicket {
        val lottoNumbers = LottoInputHandler.inputWinningNumbers()
        val firstWinningTicket = LottoTicketGenerator.generate(lottoNumbers)
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
