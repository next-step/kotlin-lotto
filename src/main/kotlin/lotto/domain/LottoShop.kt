package lotto.domain

class LottoShop(
    private val lottoGenerator: LottoGenerator
) {
    fun buyLotto(inputPayment: Int): List<Lotto> {
        val lottoCount = calculateLottoCount(inputPayment)
        return lottoGenerator.generate(lottoCount)
    }

    private fun calculateLottoCount(payment: Int): Int {
        return payment / LOTTO_PRICE
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
