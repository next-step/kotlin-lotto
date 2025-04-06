package lotto.domain

import lotto.controller.WinningNumbers

class WinningStatisticsCalculator {
    fun calculate(winningNumbers: WinningNumbers, tickets: Tickets): WinningStatistics {
        val statistics = WinningStatistics()
        for (ticket in tickets.tickets) {
            val matches = checkMatches(winningNumbers, ticket)
            statistics.add(matches)
        }
        statistics.setRate(tickets.size())
        return statistics
    }

    private fun checkMatches(winningNumbers: WinningNumbers, ticket: Ticket): Int{
        return winningNumbers.numbers.intersect(ticket.lottoNumber).size
    }
}
