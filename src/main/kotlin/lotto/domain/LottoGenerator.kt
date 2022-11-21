package lotto.domain

import lotto.util.NumberGenerator

class LottoGenerator(
    private val numberGenerator: NumberGenerator
) {
    fun generate(size: Int): List<Lotto> {
        return List(size) { Lotto(randomNumber()) }
    }

    private fun randomNumber(): List<Int> {
        return numberGenerator.random(Lotto.LOTTO_START_NUMBER, Lotto.LOTTO_END_NUMBER, Lotto.LOTTO_NUMBERS_SIZE)
    }
}
