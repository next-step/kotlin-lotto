package lotto.domain.selling

import lotto.domain.Lotto
import lotto.domain.LottoType
import lotto.domain.generator.AutoLottoGenerator

class Seller {

    fun processOrder(money: Int): PaymentResult {
        val payment = Payment(money)
        val lottoes: List<Lotto> = List(calculateLottoCount(payment)) { Lotto(getGenerator()) }
        return PaymentResult(money, lottoes, calculateChange(payment))
    }

    fun isAcceptable(money: String): Boolean {
        val input = money.toIntOrNull()
        return input != null && input >= 0
    }

    private fun getGenerator(type: LottoType = LottoType.AUTO) = when (type) {
        else -> AutoLottoGenerator
    }

    private fun calculateLottoCount(payment: Payment) = payment.money / LOTTO_PRICE

    private fun calculateChange(payment: Payment) = payment.money % LOTTO_PRICE

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
