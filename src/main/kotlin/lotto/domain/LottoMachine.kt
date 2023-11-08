package lotto.domain

import lotto.util.NumberGenerator

class LottoMachine(
    val lottoCount: LottoCount,
    lottoNumberGenerator: NumberGenerator,
) {

    private val _lottos: MutableList<Lotto> = mutableListOf()
    val lottos: List<Lotto>
        get() = _lottos

    init {
        repeat(lottoCount.value) {
            val lottoNumbers = lottoNumberGenerator.generate(Lotto.LOTTO_NUMBER_COUNT)
            val lotto = Lotto(lottoNumbers)
            _lottos.add(lotto)
        }
    }

    fun getLottoTotalPrice(): Int {
        return lottoCount.times(Lotto.LOTTO_PRICE)
    }

    fun getResult(winningLotto: Lotto, buyingPrice: LottoBuyingPrice): LottoMatchResult {
        val matchCountByRank = getMatchCountByRank(winningLotto)
        val lottoResult = LottoResult(matchCountByRank)
        val earningRate = lottoResult.calculateEarningRate(buyingPrice)
        return LottoMatchResult(lottoResult.matchCountByRank, earningRate)
    }

    private fun getMatchCountByRank(winningLotto: Lotto): Map<LottoRank, Int> = lottos.map {
        it.calculateMatchCount(winningLotto)
    }.groupingBy {
        LottoRank.from(it)
    }.fold(0) { count, _ -> count + 1 }
}
