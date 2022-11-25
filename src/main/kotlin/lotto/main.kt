package lotto

import lotto.domain.Lotto
import lotto.domain.Money
import lotto.domain.Winner
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val lotto = Lotto()
    val money = Money(InputView.getPurchaseFee())
    lotto.setCountByPurchaseFee(money.getPurchaseFee())
    val tickets = lotto.purchaseTicket()
    OutputView.printTicketPurchaseCount(lotto.getCount())
    OutputView.printTicketsInfo(tickets)
    val winner = Winner(InputView.getWinNumbers())
    val matchInfo = winner.checkNumberMatch(tickets)
    OutputView.printStatistics(matchInfo)
    money.setRevenueRate(matchInfo)
    OutputView.printRevenueRate(money)
}
