package view

import domain.money.Money
import domain.statistics.WinningCategory
import domain.statistics.WinningStatistics

class WinningStatisticsView {
    fun print(statistics: WinningStatistics, lottoPrice: Money) {
        println("당첨 통계\n---------")
        printCountsMatchedForAllCategories(statistics)
        println("총 수익률은 ${statistics.calculateRatioOfIncomeToExpenditure(lottoPrice)}입니다.")
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
