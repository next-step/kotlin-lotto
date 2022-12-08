package lotto.domain

class LottoShop(
    private val lottoGenerator: LottoGenerator
) {
    fun buyLotto(inputPayment: Payment): List<Lotto> {
        val lottoCount = calculateLottoCount(inputPayment)
        return lottoGenerator.generate(lottoCount)
    }

    private fun calculateLottoCount(payment: Payment): Int {
        return payment.payment / LOTTO_PRICE
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
