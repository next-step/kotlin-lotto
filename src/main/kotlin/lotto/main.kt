package lotto

import lotto.domain.LottoConstants
import lotto.domain.LottoMachine
import lotto.domain.LottoTicket
import lotto.dto.LottoMatchResult
import lotto.dto.LottoRevenueCalculator
import lotto.view.ResultView

fun main() {
    val lottoMachine = LottoMachine(LottoConstants.TICKET_PRICE)
    val amount = InputView.requestAmount()
    val manualTicketCount = InputView.requestManualTicketCount()
    val manualNumbers = InputView.requestManualNumbers(manualTicketCount)
    val tickets = lottoMachine.generateTickets(amount, manualNumbers)
    ResultView.showTickets(tickets)
    val winningNumbers = InputView.requestWinningNumbers()
    val bonusBall = InputView.requestBonusBall()
    val winningTicket = LottoTicket(winningNumbers.toList())
    val matchResult = LottoMatchResult(tickets.second, winningTicket, bonusBall)
    ResultView.showStatistics(matchResult)
    val purchaseAmount = tickets.second.size * LottoConstants.TICKET_PRICE.toDouble()
    val revenueCalculator = LottoRevenueCalculator(matchResult)
    val returnRate = revenueCalculator.calculateReturnRate(purchaseAmount)
    ResultView.showReturnRate(returnRate)
}
