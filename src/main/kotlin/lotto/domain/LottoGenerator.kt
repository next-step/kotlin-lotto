package lotto.domain

import lotto.domain.money.Money

class LottoGenerator(val lottoPrice: Money) {

    fun generate(paidPrice: Money): List<Lotto> {
        val numberOfLottoToGenerate = paidPrice / lottoPrice
        return (1..numberOfLottoToGenerate).map { createLotto() }
    }

    private fun createLotto(): Lotto {
        val numbers = NUMBER_POOL.shuffled().slice(NUMBERS_RANGE)
        return Lotto(numbers)
    }

    companion object {
        private val NUMBERS_RANGE = (0..5)
        private val NUMBER_POOL = (1..45).toList()
    }
}
