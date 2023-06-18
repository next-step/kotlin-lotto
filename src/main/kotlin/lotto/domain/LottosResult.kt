package lotto.domain

import java.text.DecimalFormat

typealias WinningResults = Map<LottoRank, Int>

class LottosResult(
    val totalCost: Int,
    val winningResults: WinningResults,
) {
    private val totalWinningMoney: Int
    val returnOfRate: Double

    init {
        validateTotalCostIsPostivieZero(totalCost)

        totalWinningMoney = winningResults
            .map { (rank, count) -> rank.winningMoney * count }
            .sum()
        returnOfRate = (totalWinningMoney.toDouble() / totalCost).round()
    }

    private fun validateTotalCostIsPostivieZero(totalCost: Int) {
        require(totalCost >= 0) {
            "총 구매 비용은 0보다 커야 합니다."
        }
    }

    private fun Double.round(decimals: Int = 2): Double = DecimalFormat("#.${"#".repeat(decimals)}")
        .also { df -> df.roundingMode = java.math.RoundingMode.DOWN }
        .format(this).toDouble()
}
