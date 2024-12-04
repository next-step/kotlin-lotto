package lotto.domain

import lotto.stretagy.LottoNumberListGenerator

class Cashier(
    private val amount: Int,
    private val lottoNumberListGenerator: LottoNumberListGenerator,
) {
    fun purchaseLotto(): List<Lotto> {
        require(amount >= LOTTO_PRICE)
        val numberOfLotto = calculateNumberOfLotto(amount)
        return List(numberOfLotto) { Lotto(lottoNumberListGenerator.generate()) }
    }

    companion object {
        private const val LOTTO_PRICE = 1000

        private fun calculateNumberOfLotto(amount: Int): Int {
            return amount / LOTTO_PRICE
        }
    }
}
