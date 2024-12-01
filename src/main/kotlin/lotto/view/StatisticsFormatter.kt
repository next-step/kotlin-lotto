package lotto.view

import lotto.domain.WinningCategory
import lotto.domain.WinningStatistics

object StatisticsFormatter {
    fun formatDescriptions(statistics: WinningStatistics): List<String> {
        return statistics.getStatistics().map { (category, count) ->
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
