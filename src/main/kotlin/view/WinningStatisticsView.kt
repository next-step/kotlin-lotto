package view

import domain.money.Money
import domain.statistics.WinningCategory
import domain.statistics.WinningStatistics

object WinningStatisticsView {
    fun print(statistics: WinningStatistics, lottoPrice: Money) {
        printHeader()
        printCountsMatchedForAllCategories(statistics)
        printRatioOfIncomeToExpenditure(statistics, lottoPrice)
    }

    private fun printHeader() {
        println("당첨 통계\n---------")
    }

    private fun printCountsMatchedForAllCategories(statistics: WinningStatistics) {
        WinningCategory.values().forEach { category ->
            printCountMatched(statistics, category)
        }
    }

    private fun printCountMatched(statistics: WinningStatistics, category: WinningCategory) {
        println("${category.numberOfMatched}개 일치 (${category.prize.value}원)- ${statistics.countLottoBy(category)}개")
    }

    private fun printRatioOfIncomeToExpenditure(
        statistics: WinningStatistics,
        lottoPrice: Money
    ) {
        println("총 수익률은 ${statistics.calculateRatioOfIncomeToExpenditure(lottoPrice).value}입니다.")
    }
}
