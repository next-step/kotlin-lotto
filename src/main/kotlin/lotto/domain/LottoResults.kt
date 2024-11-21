package lotto.domain

data class LottoResults(
    val results: List<LottoResult>,
) : List<LottoResults.LottoResult> by results {

    val isProfitable = calculateRateOfReturn() > 1.0

    fun calculateRateOfReturn(): Double {
        return calculateEarningMoney().toDouble() / calculateBuyingMoney()
    }

    fun calculateBuyingMoney(): Int {
        return buyingLottoCount() * LottoMoney.LOTTO_COST
    }

    fun buyingLottoCount() = this.sumOf { it.count }

    fun calculateEarningMoney(): Int {
        return this.sumOf { it.rank.winningMoney * it.count }
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
