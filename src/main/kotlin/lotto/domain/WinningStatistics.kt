package lotto.domain

class WinningStatistics(winningCategories: List<WinningCategory>) {
    private val statistics: Map<WinningCategory, Int> = winningCategories.groupingBy { it }.eachCount()

    fun getStatistics(): Map<WinningCategory, Int> = statistics

    fun calculateTotalPrize(): Int {
        return statistics.entries.sumOf { (category, count) ->
            category.prize * count
        }
    }

    fun calculateProfitRate(purchaseAmount: PurchaseAmount): Double {
        val totalPrize = calculateTotalPrize()
        return totalPrize.toDouble() / purchaseAmount.getValue()
    }
}
