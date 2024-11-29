package lotto.domain

class WinningStatistics(
    private val statistics: Map<WinningCategory, Int>,
) {
    fun getStatistics(): Map<WinningCategory, Int> = statistics

    fun calculateTotalPrize(): Int {
        return statistics.entries.sumOf { (category, count) ->
            category.prize * count
        }
    }
}
