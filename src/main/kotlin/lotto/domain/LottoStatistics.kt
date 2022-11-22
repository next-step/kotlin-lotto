package lotto.domain

class LottoStatistics(
    private val winningLotto: Lotto
) {

    fun getWinningStatistics(lottoList: List<Lotto>): List<LottoMatch> {
        val lottoMatchResult = LottoMatchResult()
        lottoList.forEach { lotto ->
            val matchCount = winningLotto.getMatchCount(lotto)
            lottoMatchResult.setMatchResult(matchCount)
        }
        return lottoMatchResult.getMatchResult()
    }

    fun getProfit(totalPrice: Long, lottMatchList: List<LottoMatch>): Double {
        // 총 이득
        val totalReward = lottMatchList.sumOf { lottoMatch ->
            lottoMatch.matchCount * lottoMatch.reward
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
