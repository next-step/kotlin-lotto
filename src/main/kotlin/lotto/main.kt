package lotto

import lotto.domain.Lotto
import lotto.domain.Winner
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val lotto = Lotto()
    lotto.setCountByPurchaseFee(InputView.getPurchaseFee())
    val tickets = lotto.purchaseTicket()
    OutputView.printTicketPurchaseCount(lotto.getCount())
    OutputView.printTicketsInfo(tickets)
    val winner = Winner(InputView.getWinNumbers())
    OutputView.printStatistics(winner.checkNumberMatch(tickets))
}
