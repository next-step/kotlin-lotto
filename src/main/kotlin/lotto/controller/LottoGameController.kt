package lotto.controller

import lotto.domain.LottoConstants
import lotto.domain.LottoMachine
import lotto.domain.LottoResultEvaluator
import lotto.domain.LottoRevenueCalculator
import lotto.domain.LottoTicket
import lotto.dto.LottoMatchResult
import lotto.dto.LottoTicketsResult
import lotto.dto.ManualLottoTickets
import lotto.dto.ManualTicketsInfo
import lotto.dto.PurchaseAmount
import lotto.dto.WinningInfo
import lotto.view.ResultView

class LottoGameController {
    fun run() {
        val purchaseAmount = requestPurchaseAmount()
        val manualTicketsInfo = requestManualTicketsInfo()
        val tickets = generateTickets(purchaseAmount, manualTicketsInfo)
        displayTickets(tickets)

        val winningInfo = requestWinningInfo()
        val matchResult = calculateMatchResult(tickets, winningInfo)
        displayMatchResult(matchResult)

        val returnRate = calculateReturnRate(matchResult, purchaseAmount)
        displayReturnRate(returnRate)
    }

    private fun requestPurchaseAmount(): PurchaseAmount {
        return InputView.requestAmount()
    }

    private fun requestManualTicketsInfo(): ManualTicketsInfo {
        val manualTicketCount = InputView.requestManualTicketCount()
        val manualNumbers = InputView.requestManualNumbers(manualTicketCount)
        return ManualTicketsInfo(manualTicketCount, manualNumbers)
    }

    private fun generateTickets(amount: PurchaseAmount, manualTicketsInfo: ManualTicketsInfo): LottoTicketsResult {
        val manualLottoTickets = convertToManualLottoTickets(manualTicketsInfo)
        return LottoMachine(LottoConstants.TICKET_PRICE).generateTickets(amount.amount, manualLottoTickets)
    }

    private fun displayTickets(tickets: LottoTicketsResult) {
        ResultView.showTickets(tickets)
    }

    private fun convertToManualLottoTickets(manualTicketsInfo: ManualTicketsInfo): ManualLottoTickets {
        val manualTickets = manualTicketsInfo.ticketsNumbers.map { LottoTicket.from(it.numbers) }
        return ManualLottoTickets(manualTickets)
    }

    private fun requestWinningInfo(): WinningInfo {
        val winningNumbers = InputView.requestWinningNumbers()
        val bonusBall = InputView.requestBonusBall()
        return WinningInfo(winningNumbers, bonusBall)
    }

    private fun calculateMatchResult(tickets: LottoTicketsResult, winningInfo: WinningInfo): LottoMatchResult {
        val evaluator = LottoResultEvaluator(LottoTicket.from(winningInfo.winningNumbers.toList()), winningInfo.bonusBall)
        return evaluator.evaluate(tickets.tickets)
    }

    private fun displayMatchResult(matchResult: LottoMatchResult) {
        ResultView.showStatistics(matchResult)
    }

    private fun calculateReturnRate(matchResult: LottoMatchResult, amount: PurchaseAmount): Double {
        val revenueCalculator = LottoRevenueCalculator(matchResult)
        return revenueCalculator.calculateReturnRate(amount.amount.toDouble())
    }

    private fun displayReturnRate(returnRate: Double) {
        ResultView.showReturnRate(returnRate)
    }
}
