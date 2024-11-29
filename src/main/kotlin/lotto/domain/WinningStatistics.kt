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

    fun getDescriptions(): List<String> {
        return statistics.map { (category, count) ->
            "${getCategoryDescription(category)} (${category.prize}원)- ${count}개"
        }
    }

    private fun getCategoryDescription(category: WinningCategory): String {
        return when (category) {
            WinningCategory.SECOND -> "${category.matchCount}개 일치, 보너스 볼 일치"
            else -> "${category.matchCount}개 일치"
        }
    }
}
