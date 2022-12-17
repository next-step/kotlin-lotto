package lotto

import lotto.ui.*

object LottoGame {
    fun run() {
        val paymentInput = PaymentInput()
        paymentInput.draw()
        val payment = paymentInput.getPayment()
        val lottoTicketBundle = LottoTicketBundle.purchase(payment = payment)
        PurchaseCount(payment = payment).draw()
        LottoTicketList(tickets = lottoTicketBundle.getTickets()).draw()
        val winningNumberInput = WinningNumberInput()
        winningNumberInput.draw()
        val winningNumber = WinningNumber.from(numbers = winningNumberInput.getNumbers())
        lottoTicketBundle.match(winningNumber = winningNumber)
        val winningTickets = lottoTicketBundle.getWinningTickets()
        WinningStats(tickets = winningTickets).draw()
        ReturnRate(rate = lottoTicketBundle.getReturnRate()).draw()
    }
}
