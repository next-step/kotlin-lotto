package lotto

import lotto.ui.LottoTicketList
import lotto.ui.PaymentInput
import lotto.ui.PurchaseCount
import lotto.ui.WinningNumberInput

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
    }
}
