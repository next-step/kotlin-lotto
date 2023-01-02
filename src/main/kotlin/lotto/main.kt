package lotto

import lotto.domain.IssuanceTickets
import lotto.domain.Lotto
import lotto.domain.Money
import lotto.domain.Winner
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val money = Money(InputView.getPurchaseFee())

    val manualCount = InputView.getManualCount()
    val manualTicket = InputView.getManualNumbers(manualCount)

    val lotto = Lotto(money.getPurchaseFee())
    val tickets = lotto.purchaseTicket(manualTicket)

    OutputView.printTicketPurchaseCountAndTicketsInfo(lotto.getCount(), manualCount, tickets)

    val matchInfo = Winner(InputView.getWinNumbers(), InputView.getBonusNumbers())
        .checkNumberMatch(IssuanceTickets(tickets))

    OutputView.printStatisticsAndRevenueRate(matchInfo, money)
}
