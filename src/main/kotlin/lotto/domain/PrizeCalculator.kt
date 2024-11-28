package lotto.domain

class PrizeCalculator {
    fun calculateTotalPrize(statistics: Map<WinningCategory, Int>): Int {
        return statistics.entries.sumOf { (category, count) ->
            category.prize * count
        }
    }
}
