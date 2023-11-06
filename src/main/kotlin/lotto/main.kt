package lotto

import lotto.domain.LottoConstants
import lotto.domain.LottoMachine
import lotto.dto.LottoMatchResult
import lotto.dto.LottoRevenueCalculator
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val lottoMachine = LottoMachine(LottoConstants.TICKET_PRICE)
    val amount = InputView.getAmount()
    val tickets = lottoMachine.generateTickets(amount)
    ResultView.showTickets(tickets)
    val winningNumbers = InputView.getWinningNumbers()
    val matchResult = LottoMatchResult(tickets, winningNumbers)
    val revenueCalculator = LottoRevenueCalculator(matchResult)
    val purchaseAmount = tickets.size * LottoConstants.TICKET_PRICE.toDouble()
    ResultView.showStatisticsAndReturnRate(matchResult, revenueCalculator, purchaseAmount)
}
