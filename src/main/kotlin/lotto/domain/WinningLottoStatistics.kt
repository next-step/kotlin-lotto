package lotto.domain

import lotto.util.ErrorCode

class WinningLottoStatistics(
    private val previousWinningLotto: Lotto,
    private val bonusLottoNumber: LottoNumber
) {
    init {
        require(!previousWinningLotto.containLottoNumber(bonusLottoNumber)) {
            ErrorCode.BONUS_LOTTO_NUMBER_EXCEPTION.errorMessage
        }
    }

    fun getWinningStatistics(lottoList: LottoList): List<LottoMatch> =
        lottoList.compare(previousWinningLotto, bonusLottoNumber)
            .groupBy { it }
            .let { map ->
                val missingMap = getMissingMap(map.keys)
                map.plus(missingMap).minus(LottoRank.MISS)
            }
            .map { lottoMap ->
                LottoMatch(lottoMap.key, lottoMap.value.count().toLong())
            }.sortedBy { it.lottoRank }

    private fun getMissingMap(lottoRanks: Set<LottoRank>): Map<LottoRank, List<LottoRank>> {
        val missingMap = mutableMapOf<LottoRank, List<LottoRank>>()
        val missing = LottoRank.getMissing(lottoRanks)
        missing.map { lottoRank ->
            missingMap[lottoRank] = listOf()
        }
        return missingMap
    }

    fun getProfit(totalPrice: Long, lottMatchList: List<LottoMatch>): Double {
        // 총 이득
        val totalReward = lottMatchList.sumOf { lottoMatch ->
            lottoMatch.getProfit()
        }

        val profit = totalReward / totalPrice.toDouble()

        return (profit * DIGIT_NUMBER).toInt() / DIGIT_NUMBER
    }

    fun isProfitable(profit: Double) = profit >= STANDARD_PROFIT_RATIO

    companion object {
        private const val DIGIT_NUMBER = 100.0
        const val STANDARD_PROFIT_RATIO = 1
    }
}
