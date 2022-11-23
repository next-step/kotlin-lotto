package lotto

import lotto.domain.Lotto
import lotto.domain.Winner
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val lotto = Lotto()
    lotto.setCountByPurchaseFee(inputView.getPurchaseFee())
    val tickets = lotto.purchaseTicket()
    outputView.printTicketPurchaseCount(lotto.getCount())
    outputView.printTicketsInfo(tickets)
    outputView.printWinner()
    val winner = Winner(inputView.getWinNumbers())
    outputView.printStatistics(winner.checkNumberMatch(tickets))
}
