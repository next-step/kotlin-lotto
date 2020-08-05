package lotto.domain.selling

import lotto.domain.Lotto
import lotto.domain.LottoType
import lotto.domain.generator.AutoLottoGenerator
import lotto.domain.generator.ManualLottoGenerator

class Seller {

    fun processPayment(payment: Payment, numbers: String = "") =
        PaymentResult(payment.money, issueLottoes(payment, numbers), calculateChange(payment))

    fun isAcceptable(money: String): Boolean {
        val input = money.toIntOrNull()
        return input != null && input >= 0
    }

    private fun issueLottoes(payment: Payment, numbers: String = "") =
        List(calculateLottoCount(payment)) { Lotto(getGenerator(payment.lottoType, numbers)) }

    private fun getGenerator(
        type: LottoType = LottoType.AUTO,
        numbers: String = ""
    ) = when (type) {
        LottoType.MANUAL -> ManualLottoGenerator(numbers)
        else -> AutoLottoGenerator
    }

    private fun calculateLottoCount(payment: Payment) = payment.money / LOTTO_PRICE

    private fun calculateChange(payment: Payment) = payment.money % LOTTO_PRICE

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
