package lotto.domain

class Seller {

    fun processOrder(input: Int): PaymentResult {
        val payment = Payment(input)
        val lottoes: List<Lotto> = List(calculateLottoCount(payment)) { Lotto(getGenerator()) }
        return PaymentResult(lottoes, calculateChange(payment))
    }

    private fun getGenerator(type: LottoType = LottoType.AUTO) = when (type) {
        else -> AutoLottoGenerator
    }

    private fun calculateLottoCount(payment: Payment) = payment.money / LOTTO_PRICE

    private fun calculateChange(payment: Payment) = payment.money % LOTTO_PRICE

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
