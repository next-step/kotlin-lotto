package lotto.domain.generator

import lotto.domain.Lotto

class LottoAutoStrategy : LottoGeneratorStrategy {

    private val lottoNumbers: List<Int> by lazy(
        (LOTTO_FIRST_NUMBER..LOTTO_LAST_NUMBER)::toList
    )

    override fun generate(lottoCount: Int): List<Lotto> {
        return (0 until lottoCount)
            .map { generateLottoNumbers() }
            .map { Lotto(it) }
            .toList()
    }

    private fun generateLottoNumbers(): List<Int> {
        return lottoNumbers
            .shuffled()
            .subList(LOTTO_FIRST_INDEX, LOTTO_LAST_INDEX)
            .sorted()
            .toList()
    }

    companion object {
        private const val LOTTO_FIRST_NUMBER = 1
        private const val LOTTO_LAST_NUMBER = 45
        private const val LOTTO_FIRST_INDEX = 0
        private const val LOTTO_LAST_INDEX = 6
    }
}
