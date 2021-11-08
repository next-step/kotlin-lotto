package lotto.domain

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
        val numbers = LOTTO_NUMBERS.shuffled().take(LOTTO_NUMBERS_COUNT)
        return Lotto(numbers)
    }

    companion object {
        private val LOTTO_NUMBERS = (1..45).map { LottoNumber(it) }
        private const val LOTTO_NUMBERS_COUNT = 6
        private const val NOT_ENOUGH_MONEY = "금액이 부족합니다."
    }
}
