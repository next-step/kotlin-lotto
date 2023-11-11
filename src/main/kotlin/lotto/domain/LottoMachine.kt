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

    fun getLottoTotalPrice(): LottoPrice {
        return LottoPrice.getTotalPrice(lottoCount)
    }

    fun getResult(winningLotto: Lotto, buyingPrice: LottoBuyingPrice, bonusBall: LottoNumber): LottoMatchResult {
        validateBonusBall(winningLotto, bonusBall)
        val matchCountByRank = getMatchCountByRank(winningLotto, bonusBall)
        val lottoResult = LottoResult(matchCountByRank)
        val earningRate = lottoResult.calculateEarningRate(buyingPrice)
        return LottoMatchResult(lottoResult.matchCountByRank, earningRate)
    }

    private fun validateBonusBall(winningLotto: Lotto, bonusBall: LottoNumber) {
        require(winningLotto.hasBonusBall(bonusBall).not()) {
            "보너스 볼은 당첨 번호와 중복될 수 없습니다."
        }
    }

    private fun getMatchCountByRank(winningLotto: Lotto, bonusBall: LottoNumber): Map<LottoRank, Int> =
        lottos.map { lotto -> createLottoRank(lotto, winningLotto, bonusBall) }
            .groupingBy { it }
            .fold(INIT_MATCH_COUNT) { count, _ -> count + 1 }

    private fun createLottoRank(
        lotto: Lotto,
        winningLotto: Lotto,
        bonusBall: LottoNumber,
    ): LottoRank {
        val matchCount = lotto.calculateMatchCount(winningLotto, bonusBall)
        val hasBonusBall = lotto.hasBonusBall(bonusBall)
        return LottoRank.from(matchCount, hasBonusBall)
    }

    companion object {
        private const val INIT_MATCH_COUNT = 0

        fun of(lottoCount: Int, numberGenerator: NumberGenerator): LottoMachine = LottoMachine(
            lottoCount = LottoCount(lottoCount),
            lottoNumberGenerator = numberGenerator
        )
    }
}
