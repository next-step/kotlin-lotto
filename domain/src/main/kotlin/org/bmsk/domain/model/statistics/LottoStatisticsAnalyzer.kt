package org.bmsk.domain.model.statistics

import org.bmsk.domain.model.lotto.LottoLottery
import org.bmsk.domain.model.lotto.LottoNumber

class LottoStatisticsAnalyzer(
    private val lottoTickets: List<LottoLottery>,
) {
    fun calculateLottoStatistics(winningNumbers: List<LottoNumber>): LottoStatistics {
        val winningNumbersAsSet = winningNumbers.toSet()
        val matchCounts = calculateMatchCounts(winningNumbersAsSet)
        val totalProfit = calculateTotalProfit(matchCounts)
        val profitRate = calculateProfitRate(totalProfit)

        return LottoStatistics(
            numberOfMatches3 = matchCounts[MATCH_3] ?: 0,
            numberOfMatches4 = matchCounts[MATCH_4] ?: 0,
            numberOfMatches5 = matchCounts[MATCH_5] ?: 0,
            numberOfMatches6 = matchCounts[MATCH_6] ?: 0,
            totalProfitRate = profitRate,
        )
    }

    private fun calculateMatchCounts(winningNumbersAsSet: Set<LottoNumber>): Map<Int, Int> {
        val matchCounts = mutableMapOf(
            MATCH_3 to 0,
            MATCH_4 to 0,
            MATCH_5 to 0,
            MATCH_6 to 0,
        )

        lottoTickets.forEach { ticket ->
            val matchCount = ticket.numbers.count { it in winningNumbersAsSet }
            matchCounts[matchCount] = matchCounts.getOrDefault(matchCount, 0) + 1
        }

        return matchCounts.toMap()
    }

    private fun calculateTotalProfit(matchCounts: Map<Int, Int>): Int {
        val prizeMoney = mapOf(
            MATCH_3 to PRIZE_3,
            MATCH_4 to PRIZE_4,
            MATCH_5 to PRIZE_5,
            MATCH_6 to PRIZE_6,
        )

        var totalProfit = 0
        matchCounts.forEach { (matchCount, count) ->
            totalProfit += prizeMoney.getOrDefault(matchCount, 0) * count
        }

        return totalProfit
    }

    private fun calculateProfitRate(totalProfit: Int): Double {
        val totalInvestment = lottoTickets.size * LottoLottery.DEFAULT_PRICE
        return totalProfit.toDouble() / totalInvestment
    }

    companion object {
        private const val MATCH_3 = 3
        private const val MATCH_4 = 4
        private const val MATCH_5 = 5
        private const val MATCH_6 = 6
        const val PRIZE_3 = 5000
        const val PRIZE_4 = 50000
        const val PRIZE_5 = 1500000
        const val PRIZE_6 = 2000000000
    }
}
