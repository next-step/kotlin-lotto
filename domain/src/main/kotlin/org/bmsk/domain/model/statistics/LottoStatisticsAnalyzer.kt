package org.bmsk.domain.model.statistics

import org.bmsk.domain.model.lotto.LottoLottery
import org.bmsk.domain.model.lotto.LottoNumber

class LottoStatisticsAnalyzer(
    private val lottoLotteries: List<LottoLottery>,
) {
    fun calculateLottoStatistics(winningNumbers: List<LottoNumber>): LottoStatistics {
        val winningNumbersAsSet = winningNumbers.toSet()
        val matchCounts = calculateMatchCounts(winningNumbersAsSet)
        val totalProfit = calculateTotalProfit(matchCounts)
        val profitRate = calculateProfitRate(totalProfit)

        return LottoStatistics(
            matchCounts = matchCounts,
            totalProfitRate = profitRate,
        )
    }

    private fun calculateMatchCounts(winningNumbersAsSet: Set<LottoNumber>): Map<MatchCount, Int> {
        return lottoLotteries
            .map { lottery -> MatchCount.from(lottery.numbers.count { it in winningNumbersAsSet }) }
            .groupingBy { it }
            .eachCount()
    }

    private fun calculateTotalProfit(matchCounts: Map<MatchCount, Int>): Int {
        return matchCounts.entries.sumOf { (matchCount, count) ->
            PrizeMoney.from(matchCount).money * count
        }
    }

    private fun calculateProfitRate(totalProfit: Int): Double {
        val totalInvestment = lottoLotteries.size * LottoLottery.DEFAULT_PRICE
        return totalProfit.toDouble() / totalInvestment
    }
}
