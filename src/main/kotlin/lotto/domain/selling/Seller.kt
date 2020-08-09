package lotto.domain.selling

import lotto.domain.LottoTicket
import lotto.domain.LottoType

class Seller {

    fun processPayment(payment: Payment, numbers: String = "") =
        PaymentResult(payment.money, issueLottoTickets(payment, numbers), calculateChange(payment))

    fun isAcceptable(money: String): Boolean {
        val input = money.toIntOrNull()
        return input != null && input >= LOTTO_PRICE
    }

    private fun issueLottoTickets(payment: Payment, numbers: String = ""): List<LottoTicket> {
        val count = calculateLottoCount(payment)
        val generator = LottoType.generatorOf(payment.lottoType, numbers)
        return List(count) { generator.execute() }
    }

    private fun calculateLottoCount(payment: Payment) = payment.money / LOTTO_PRICE

    private fun calculateChange(payment: Payment) = payment.money % LOTTO_PRICE

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
