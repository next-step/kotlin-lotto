package lotto.model

import lotto.model.Lotto.Companion.LOTTO_NUMBER_COUNT

object RandomLottoGenerator {
    private const val MIN_PAYMENT_PRICE = 0
    private const val LOTTO_PRICE = 1000

    fun generateLottos(paymentPrice: Int): Lottos {
        val lottos = List(paymentPrice.coerceAtLeast(MIN_PAYMENT_PRICE) / LOTTO_PRICE) {
            generateLotto()
        }

        return Lottos(lottos)
    }

    private fun generateLotto(): Lotto {
        val shuffledNumbers = LottoNumber.LOTTO_NUMBERS.shuffled()
            .subList(0, LOTTO_NUMBER_COUNT)
            .sortedBy { it.number }

        return Lotto(shuffledNumbers)
    }
}
