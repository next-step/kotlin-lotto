package lotto.domain

import lotto.stretagy.LottoNumberListGenerator

class Cashier {
    companion object {
        private const val LOTTO_PRICE = 1000

        fun purchaseLotto(
            amount: Int,
            lottoNumberListGenerator: LottoNumberListGenerator,
        ): List<Lotto> {
            require(amount >= LOTTO_PRICE)
            val numberOfLotto = calculateNumberOfLotto(amount)
            return List(numberOfLotto) { Lotto.createLotto(lottoNumberListGenerator.generate()) }
        }

        private fun calculateNumberOfLotto(amount: Int): Int {
            return amount / LOTTO_PRICE
        }
    }
}
