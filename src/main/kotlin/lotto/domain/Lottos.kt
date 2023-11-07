package lotto.domain

import lotto.util.NumberGenerator

class Lottos(
    val buyingPrice: LottoBuyingPrice,
    lottoNumberGenerator: NumberGenerator,
) {

    private val _values: MutableList<Lotto> = mutableListOf()
    val values: List<Lotto>
        get() = _values

    init {
        val lottoCount = buyingPrice.divide(LOTTO_PRICE)
        for (i in 0 until lottoCount) {
            val lottoNumbers = lottoNumberGenerator.generate(lottoCount)
            val lotto = Lotto(lottoNumbers)
            _values.add(lotto)
        }
    }

    fun getChange(): Int {
        val lottoCount = _values.size
        return buyingPrice.minus(lottoCount.times(LOTTO_PRICE))
    }

    fun getLottoCount(): Int {
        return _values.size
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
