package lotto.domain

import lotto.controller.WinningNumbers

class WinningStatisticsCalculator {
    fun calculate(winningNumbers: WinningNumbers, tickets: Tickets): Pair<WinningStatistics, Double> {
        val statistics = WinningStatistics()
        tickets.checkMatches(winningNumbers, statistics)
        val rate = statistics.yieldRate(tickets.size())
        return Pair(statistics, rate)
    }
}
