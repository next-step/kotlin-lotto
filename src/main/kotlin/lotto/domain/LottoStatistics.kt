package lotto.domain

import lotto.util.ErrorCode

class LottoStatistics(
    private val winningLotto: Lotto,
    private val bonusLottoNumber: LottoNumber
) {
    init {
        require(!winningLotto.containLottoNumber(bonusLottoNumber)) {
            ErrorCode.BONUS_LOTTO_NUMBER_EXCEPTION.errorMessage
        }
    }

    private fun initLottoMatchMap(): Map<LottoRank, LottoMatch> {
        val lottoMatchMap = mutableMapOf<LottoRank, LottoMatch>()
        LottoRank.values().forEach { lottoRank ->
            lottoMatchMap[lottoRank] =
                LottoMatch(
                    lottoRank
                )
        }
        return lottoMatchMap
    }

    fun getWinningStatistics(lottoList: List<Lotto>): List<LottoMatch> {
        val lottoMatchMap = initLottoMatchMap()

        val lottoMatchResult = LottoMatchResult(lottoMatchMap)
        lottoList.forEach { lotto ->
            val matchCount = winningLotto.getMatchCount(lotto)
            val isBonus = lotto.containLottoNumber(bonusLottoNumber)
            lottoMatchResult.setMatchResult(matchCount, isBonus)
        }
        return lottoMatchResult.getMatchResult()
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
