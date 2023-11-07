package lotto.domain

import lotto.util.NumberGenerator

class Lottos(
    val buyingPrice: LottoBuyingPrice,
    lottoNumberGenerator: NumberGenerator,
) {

    private val _lottos: MutableList<Lotto> = mutableListOf()

    init {
        val lottoCount = buyingPrice.divide(LOTTO_PRICE)
        for (i in 0 until lottoCount) {
            val lottoNumbers = lottoNumberGenerator.generate(lottoCount)
            val lotto = Lotto(lottoNumbers)
            _lottos.add(lotto)
        }
    }

    fun getChange(): Int {
        val lottoCount = _lottos.size
        return buyingPrice.minus(lottoCount.times(LOTTO_PRICE))
    }

    fun getLottoCount(): Int {
        return _lottos.size
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
