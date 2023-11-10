package lotto.domain

import lotto.util.NumberGenerator

class LottoMachine private constructor(
    val lottoCount: LottoCount,
    lottoNumberGenerator: NumberGenerator,
) {

    private val _lottos: MutableList<Lotto> = mutableListOf()
    val lottos: List<Lotto>
        get() = _lottos

    init {
        repeat(lottoCount.value) {
            val lotto = Lotto.from(lottoNumberGenerator)
            _lottos.add(lotto)
        }
    }

    fun getLottoTotalPrice(): Price {
        return Price(lottoCount.times(Lotto.LOTTO_PRICE))
    }

    fun getResult(winningLotto: Lotto, buyingPrice: LottoBuyingPrice): LottoMatchResult {
        val matchCountByRank = getMatchCountByRank(winningLotto)
        val lottoResult = LottoResult(matchCountByRank)
        val earningRate = lottoResult.calculateEarningRate(buyingPrice)
        return LottoMatchResult(lottoResult.matchCountByRank, earningRate)
    }

    private fun getMatchCountByRank(winningLotto: Lotto): Map<LottoRank, Int> =
        lottos.map { it.calculateMatchCount(winningLotto) }
            .groupingBy { LottoRank.from(it) }
            .fold(INIT_MATCH_COUNT) { count, _ -> count + 1 }

    companion object {
        private const val INIT_MATCH_COUNT = 0

        fun of(lottoCount: Int, numberGenerator: NumberGenerator): LottoMachine = LottoMachine(
            lottoCount = LottoCount(lottoCount),
            lottoNumberGenerator = numberGenerator
        )
    }
}
