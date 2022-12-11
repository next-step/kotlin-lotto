package lotto

import lotto.domain.IssuanceTickets
import lotto.domain.Lotto
import lotto.domain.Money
import lotto.domain.Winner
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val money = Money(InputView.getPurchaseFee())
    val lotto = Lotto(money.getPurchaseFee())
    val tickets = lotto.purchaseTicket()

    OutputView.printTicketPurchaseCountAndTicketsInfo(lotto.getCount(), tickets)

    val matchInfo = Winner(InputView.getWinNumbers()).checkNumberMatch(IssuanceTickets(tickets))

    OutputView.printStatisticsAndRevenueRate(matchInfo, money)
}
