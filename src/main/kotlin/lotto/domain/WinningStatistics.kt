package lotto.domain

class WinningStatistics(private val statistics: Map<WinningCategory, Int>) {
    fun getStatistics(): Map<WinningCategory, Int> = statistics

    fun calculateTotalPrize(): Int {
        return statistics.entries.sumOf { (category, count) ->
            category.prize * count
        }
    }

    fun calculateProfitRate(purchaseAmount: Int): Double {
        val totalPrize = calculateTotalPrize()
        return if (purchaseAmount > 0) totalPrize.toDouble() / purchaseAmount else 0.0
    }
}
