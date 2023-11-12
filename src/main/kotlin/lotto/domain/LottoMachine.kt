package lotto.domain

class LottoMachine private constructor(
    val lottoCount: LottoCount,
    lottoNumberGenerator: LottoNumberGenerator,
) {

    private val _lottos: MutableList<Lotto> = mutableListOf()
    val lottos: List<Lotto>
        get() = _lottos

    init {
        repeat(lottoCount.value) {
            val lotto = Lotto.createFromGenerator(lottoNumberGenerator)
            _lottos.add(lotto)
        }
    }

    fun getLottoTotalPrice(): LottoPrice {
        return LottoPrice.getTotalPrice(lottoCount)
    }

    fun getResult(winningLotto: WinningLotto, buyingPrice: LottoBuyingPrice): LottoMatchResult {
        val matchCountByRank = getMatchCountByRank(winningLotto)
        val lottoResult = LottoResult(matchCountByRank)
        val earningRate = lottoResult.calculateEarningRate(buyingPrice)
        return LottoMatchResult(lottoResult.matchCountByRank, earningRate)
    }

    private fun getMatchCountByRank(winningLotto: WinningLotto): Map<LottoRank, Int> =
        lottos.map { lotto -> createLottoRank(lotto, winningLotto) }
            .groupingBy { it }
            .fold(INIT_MATCH_COUNT) { count, _ -> count + 1 }

    private fun createLottoRank(
        lotto: Lotto,
        winningLotto: WinningLotto,
    ): LottoRank {
        val hasBonusBall = lotto.hasBonusBall(winningLotto.bonusNumber)
        val matchCount = lotto.calculateMatchCount(winningLotto, hasBonusBall)
        return LottoRank.from(matchCount, hasBonusBall)
    }

    companion object {
        private const val INIT_MATCH_COUNT = 0

        fun of(lottoCount: Int, lottoNumberGenerator: LottoNumberGenerator): LottoMachine = LottoMachine(
            lottoCount = LottoCount(lottoCount),
            lottoNumberGenerator = lottoNumberGenerator
        )
    }
}
