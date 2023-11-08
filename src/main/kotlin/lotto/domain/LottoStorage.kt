package lotto.domain

import lotto.util.NumberGenerator

class LottoStorage(
    val buyingPrice: LottoBuyingPrice,
    lottoNumberGenerator: NumberGenerator,
) {

    private val _lottos: MutableList<Lotto> = mutableListOf()
    val lottos: List<Lotto>
        get() = _lottos

    init {
        val lottoCount = buyingPrice.divide(LOTTO_PRICE)
        for (i in 0 until lottoCount) {
            val lottoNumbers = lottoNumberGenerator.generate(Lotto.LOTTO_COUNT)
            val lotto = Lotto(lottoNumbers)
            _lottos.add(lotto)
        }
    }

    fun getChange(): Int {
        val lottoCount = lottos.size
        return buyingPrice.minus(lottoCount.times(LOTTO_PRICE))
    }

    fun getLottoCount(): Int {
        return lottos.size
    }

    fun getResult(winningLotto: Lotto): LottoResult {
        val lottoResult = LottoResult()
        lottos.forEach {
            val matchCount = it.matchCount(winningLotto)
            lottoResult.add(matchCount)
        }
        return lottoResult
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
