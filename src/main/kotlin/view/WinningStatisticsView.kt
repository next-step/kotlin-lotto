package view

import domain.statistics.WinningCategory
import domain.statistics.WinningStatistics

class WinningStatisticsView {
    fun print(statistics: WinningStatistics) {
        println("당첨 통계\n---------")
        printCountsMatchedForAllCategories(statistics)
    }

    private fun printCountsMatchedForAllCategories(statistics: WinningStatistics) {
        WinningCategory.values().forEach { category ->
            printCountMatched(statistics, category)
        }
    }

    private fun printCountMatched(statistics: WinningStatistics, category: WinningCategory) {
        println("${category.numberOfMatched}개 일치 (${category.prize.value}원)- ${statistics.countLottoBy(category)}개")
    }
}
