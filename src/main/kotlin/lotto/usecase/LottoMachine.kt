package lotto.usecase

import lotto.domain.Lotto

class LottoMachine(
    private val lottoGenerator: LottoGenerator,
) {

    fun buy(purchaseAmount: Int): List<Lotto> {
        val numberOfPurchase = purchaseAmount / LOTTO_PRICE
        val lottos = mutableListOf<Lotto>()

        repeat(numberOfPurchase) {
            val numbers = (MIN_NUMBER..MAX_NUMBER)
                .shuffled()
                .subList(START_INDEX, END_INDEX)
                .sorted()
            val lotto = lottoGenerator.generate(numbers, LOTTO_PRICE)

            lottos.add(lotto)
        }

        return lottos.toList()
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val START_INDEX = 0
        private const val END_INDEX = 6
        private const val LOTTO_PRICE = 1000
    }
}
