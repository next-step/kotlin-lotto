package lotto.domain

import lotto.domain.money.Money

class LottoGenerator(val lottoPrice: Money) {

    fun generate(paidPrice: Money): List<Lotto> {
        val numberOfLottoToGenerate = getNumberOfLottoToGenerate(lottoPrice, paidPrice)
        return (1..numberOfLottoToGenerate).map { createLotto() }
    }

    private fun getNumberOfLottoToGenerate(lottoPrice: Money, paidPrice: Money): Int {
        require(lottoPrice <= paidPrice) { NOT_ENOUGH_MONEY }
        return paidPrice / lottoPrice
    }

    private fun createLotto(): Lotto {
        val numbers = NUMBER_POOL.shuffled().slice(NUMBERS_RANGE)
        return Lotto(numbers)
    }

    companion object {
        private val NUMBERS_RANGE = (0..5)
        private val NUMBER_POOL = (1..45).toList()
        private const val NOT_ENOUGH_MONEY = "금액이 부족합니다."
    }
}
