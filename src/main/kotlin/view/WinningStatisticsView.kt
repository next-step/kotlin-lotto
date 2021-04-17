package view

import domain.lotto.Lottos
import domain.money.Money
import domain.winning.WinningCategory
import domain.winning.WinningNumbers
import domain.winning.WinningStatistics

object WinningStatisticsView {
    fun print(statistics: WinningStatistics, lottos: Lottos, lottoPrice: Money) {
        printHeader()
        printCountsMatchedForAllCategories(lottos, statistics.winningNumbers)
        printRatioOfIncomeToExpenditure(statistics, lottoPrice)
    }

    private fun printHeader() {
        println("당첨 통계\n---------")
    }

    private fun printCountsMatchedForAllCategories(lottos: Lottos, winningNumbers: WinningNumbers) {
        val countByCategory = lottos.matches(winningNumbers)
        WinningCategory.values()
            .filter { it != WinningCategory.LOSE }
            .forEach { category ->
                println("${category.toDescription()} (${category.prize.value}원)- ${countByCategory[category] ?: 0}개")
            }
    }

    private fun printRatioOfIncomeToExpenditure(
        statistics: WinningStatistics,
        lottoPrice: Money
    ) {
        println("총 수익률은 ${statistics.calculateRatioOfIncomeToExpenditure(lottoPrice).value}입니다.")
    }

    private fun WinningCategory.toDescription(): String = when (this) {
        WinningCategory.SIX_CORRECT -> "6개 일치"
        WinningCategory.FIVE_WITH_BONUS_CORRECT -> "5개 일치, 보너스 볼 일치"
        WinningCategory.FIVE_CORRECT -> "5개 일치"
        WinningCategory.FOUR_CORRECT -> "4개 일치"
        WinningCategory.THREE_CORRECT -> "3개 일치"
        WinningCategory.LOSE -> "꽝"
    }
}
