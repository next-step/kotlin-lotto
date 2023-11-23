package lottoAuto.domain

import kotlin.math.floor

data class LottoRankCounter(
    val counter: Map<LottoRank, Int>
) {
    fun calcProfit(purchaseAmount: Int): LottoProfit {
        val totalWinningMoney = getTotalWinningMoney()
        val rateOfReturn = calcRateOfReturn(purchaseAmount, totalWinningMoney)
        val profitMessage = LottoProfitMessage.fromRateOfReturn(rateOfReturn).message
        return LottoProfit(rateOfReturn, profitMessage)
    }

    private fun getTotalWinningMoney() = counter
        .map { (lottoRank, count) -> lottoRank.winningMoney * count }
        .sum()

    private fun calcRateOfReturn(purchaseAmount: Int, totalWinningMoney: Int): Double {
        if (purchaseAmount == 0) {
            return 0.00
        }
        val rateOfReturn = totalWinningMoney.toDouble() / purchaseAmount.toDouble()
        return floor(rateOfReturn * 100) / 100
    }
}

fun Map<LottoRank, Int>.toLottoRankCounter(): LottoRankCounter {
    return LottoRankCounter(this)
}
