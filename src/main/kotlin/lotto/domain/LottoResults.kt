package lotto.domain

class LottoResults(
    private val results: List<LottoResult>,
) : List<LottoResults.LottoResult> by results {
    fun calculateRateOfReturn(): Double {
        return calculateEarningMoney().toDouble() / calculateBuyingMoney()
    }

    fun calculateBuyingMoney(): Int {
        return buyingLottoCount() * LOTTO_COST
    }

    fun buyingLottoCount() = this.sumOf { it.count }

    fun calculateEarningMoney(): Int {
        return this.sumOf { it.rank.winningMoney * it.count }
    }

    fun isProfitable(): Boolean {
        return calculateRateOfReturn() > 1.0
    }

    fun getWiningResults(): List<LottoResult> {
        return this.filter { it.rank.isWinning() }
    }

    data class LottoResult(
        val rank: LottoRank,
        val count: Int,
    ) {
        companion object {
            fun from(result: Map<LottoRank, Int>): List<LottoResult> {
                return LottoRank.entries
                    .map { LottoResult(it, result.getOrDefault(it, 0)) }
            }
        }
    }
}
