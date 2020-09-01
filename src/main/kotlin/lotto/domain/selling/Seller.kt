package lotto.domain.selling

import lotto.domain.generator.AutoLottoGenerator
import lotto.domain.lotto.LottoTicket

class Seller {

    fun processPayment(payment: Payment) =
        PaymentResult(payment.money, calculateChange(payment), issueLottoTickets(payment))

    fun isAcceptable(money: Int): Boolean = money >= LOTTO_PRICE

    private fun issueLottoTickets(payment: Payment): List<LottoTicket> {
        val count = calculateLottoCount(payment)
        return payment.manualLottoTickets + List(count) { AutoLottoGenerator.execute() }.filterNotNull()
    }

    private fun calculateLottoCount(payment: Payment) = payment.money / LOTTO_PRICE - payment.manualCount

    private fun calculateChange(payment: Payment) = payment.money % LOTTO_PRICE

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
