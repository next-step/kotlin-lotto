package lotto

import lotto.ui.LottoTicketList
import lotto.ui.PaymentInput
import lotto.ui.PurchaseCount

object LottoGame {
    fun run() {
        val paymentInput = PaymentInput()
        paymentInput.draw()
        val payment = paymentInput.value
        PurchaseCount(payment = payment).draw()
        val lottoTicketBundle = LottoTicketBundle.purchase(payment = payment)
        LottoTicketList(tickets = lottoTicketBundle.getTickets()).draw()
    }
}
