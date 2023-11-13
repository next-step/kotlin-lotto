package lottoAuto.domain

import kotlin.math.floor

object LottoStatsEngine {
    private const val LOTTO_PRICE = 1000

    fun calcNumOfLotto(purchaseAmount: Int): Int {
        return purchaseAmount / LOTTO_PRICE
    }

    fun calcRateOfReturn(purchaseAmount: Int, totalWinningMoney: Int): Double {
        if (purchaseAmount == 0) {
            return 0.00
        }
        val rateOfReturn = totalWinningMoney.toDouble() / purchaseAmount.toDouble()
        return floor(rateOfReturn * 100) / 100
    }

    fun groupByLottoRank(lottoRanks: List<LottoRank>): Map<LottoRank, Int> {
        val lottoRankCountMap = lottoRanks
            .groupingBy { it }
            .eachCount()
        return LottoRank.values().associateWith { lottoRankCountMap.getOrDefault(it, 0) }
    }
}
