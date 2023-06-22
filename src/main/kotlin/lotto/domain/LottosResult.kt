package lotto.domain

import java.text.DecimalFormat

typealias WinningResults = Map<LottoRank, Int>

class LottosResult(
    val totalCost: Money,
    val winningResults: WinningResults,
) {
    private val totalWinningMoney: Int
    val returnOfRate: Double

    init {
        totalWinningMoney = winningResults
            .map { (rank, count) -> rank.winningMoney * count }
            .sum()
        returnOfRate = (totalWinningMoney / totalCost.toDouble()).round()
    }

    fun getWinningResultsCount(rank: LottoRank): Int {
        return winningResults[rank] ?: 0
    }

    private fun Double.round(decimals: Int = 2): Double = DecimalFormat("#.${"#".repeat(decimals)}")
        .also { df -> df.roundingMode = java.math.RoundingMode.DOWN }
        .format(this).toDouble()
}
