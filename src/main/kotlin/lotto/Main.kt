package lotto

import lotto.domain.Lotto
import lotto.view.InputView
import lotto.view.OutputView

class Main {

    fun play() {
        val inputView = InputView()
        val outputView = OutputView()
        val lotto = Lotto(inputView.getPurchaseFee())
        val tickets = lotto.purchaseTicket()
        outputView.printTicketPurchaseCount(lotto.getCount())
        outputView.printTicketsInfo(tickets)
        val winNumbers = inputView.getWinNumbers()
    }
}
